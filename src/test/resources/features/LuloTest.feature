Feature: Lulo

  Background:

  Scenario Outline:Get employees list
    Given the user send a request to <path>
    When When the service is type get
    Then status <statusService>
    And validate employees list
      | id | employee_name | employee_salary | employee_age | profile_image |
      | 1  | Tiger Nixon   | 320800          | 61           |               |
      | 3  | Ashton Cox    | 86000           | 66           |               |

    Examples:
      | path      | statusService | status  | message |
      | employees | 200           | success | message |


  Scenario Outline:Get employee
    Given the user send a request to <path>/<id>
    When When the service is type get
    Then status <statusService>
    And validate employee
      | id   | employee_name   | employee_salary   | employee_age   | profile_image   |
      | <id> | <employee_name> | <employee_salary> | <employee_age> | <profile_image> |

    Examples:
      | path      | id | statusService | id | employee_name | employee_salary | employee_age | profile_image |
      | employees | 1  | 200           | 1  | Tiger Nixon   | 320800          | 61           |               |


  Scenario Outline:Create employee
    Given the user send a request to <path>/<id>
    When When the service is type post with request <request>
    Then status <statusService>

    Examples:
      | path   | request | id | statusService |
      | create | hola    |    |         200      |
