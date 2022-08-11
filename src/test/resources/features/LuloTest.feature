Feature: Lulo

  Background:

#  Scenario Outline:Get employees list
#    Given the user send a request to <path>
#    When When the service is type get
#    Then status <status>
#
#    Examples:
#      | path      | status|
#      | employees | 200   |


  Scenario Outline:Get employee
    Given the user send a request to <path>/<id>
    When When the service is type get
    Then status <status>

    Examples:
      | path      | id| status|
      | employees | 1  |200   |