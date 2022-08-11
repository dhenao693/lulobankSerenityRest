Feature: Lulo

  Background:
    * url 'https://sso.muydev.com/v1'
    * header Accept = 'application/Json'

  Scenario:Lulo
    Given path '/path'
    When method GET
    Then status 200