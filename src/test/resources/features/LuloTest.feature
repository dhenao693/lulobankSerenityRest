Feature: Lulo

  Background:

  Scenario Outline:Get employees list
    Given the user send a request to <path>
    When When the service is type get
    Then status <statusService>
    And validate employees list, status and message
      | id | employee_name | employee_salary | employee_age | profile_image |
      | 1  | Tiger Nixon   | 320800          | 61           |               |
      | 1  | Tiger Nixon   | 320800          | 61           |               |


    Examples:
      | path      | statusService | status  | message |
      | employees | 200           | success | message |


  Scenario Outline:Get employee
    Given the user send a request to <path>/<id>
    When When the service is type get
    Then status <statusService>

    Examples:
      | path      | id | statusService |
      | employees | 1  | 200           |

  Scenario Outline:Get employee
    Given the user send a request to <path>/<id>
    When When the service is type post with request <request>
    Then status <statusService>

    Examples:
      | path   | request | id | statusService |
      | create | hola    |    |               |
