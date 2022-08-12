Feature: Lulo

  Background:

  Scenario Outline:Get employees list
    Given the user send a request to <path>
    When the service is type get
    Then status <statusService>
    And validate status and massage
      | status   | message   |
      | <status> | <message> |
    And validate employees list
      | id | employee_name | employee_salary | employee_age | profile_image |
      | 1  | Tiger Nixon   | 320800          | 61           |               |
      | 3  | Ashton Cox    | 86000           | 66           |               |

    Examples:
      | path      | statusService | status  | message                                     |
      | employees | 200           | success | Successfully! All records has been fetched. |

  Scenario Outline:Get employee
    Given the user send a request to <path>/<id>
    When the service is type get
    Then status <statusService>
    And validate employee
      | id   | employee_name   | employee_salary   | employee_age   | profile_image   |
      | <id> | <employee_name> | <employee_salary> | <employee_age> | <profile_image> |

    Examples:
      | path      | id | statusService | id | employee_name | employee_salary | employee_age | profile_image |
      | employees | 1  | 200           | 1  | Tiger Nixon   | 320800          | 61           |               |

  Scenario Outline:Create employee
    Given the user send a request to <path>/<id>
    When the service is type post with request <request>
    Then status <statusService>
    And validate create response

    Examples:
      | path   | request                                   | statusService |
      | create | {"name":"test","salary":"123","age":"23"} | 200           |

  Scenario Outline:Dekete employee
    Given the user send a request to <path>/<id>
    When  the service is type delete
    Then status <statusService>
    And validate status and massage
      | status   | message   |
      | <status> | <message> |

    Examples:
      | path   | id | statusService | status  | message                       |
      | delete | 2  | 200           | success | successfully! deleted Records |

