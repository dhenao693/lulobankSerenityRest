package co.com.lulo.utils.documents.xml;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlUtil {

	private XmlUtil() {
	}

	public static Document readerXML(String nombreArchivo) {
		Document doc = null;
		try {
			File fXmlFile = new File(nombreArchivo);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return doc;
	}

	public static String modifyXMLDocument(Document doc, List<String> tags, List<String> values) {

		StringWriter writer = null;
		try {

			for (int i = 0; i < tags.size(); i++) {
				doc.getElementsByTagName(tags.get(i)).item(0).setTextContent(values.get(i));
			}

			DOMSource domSource = new DOMSource(doc);
			writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return writer.toString();
	}
}
