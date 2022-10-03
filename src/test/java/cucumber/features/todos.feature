Feature: Validate the information on the todos page

  Background:
    Given User is in the users page
    When User clicks on the "Leanne Graham" to see the details info

  Scenario: Validate that todos items can be moved to the left
    Then User validate that when moving to the left the new item is "quis ut nam facilis et officia qui" in "todos" page

  Scenario: Validate the todos associated with the user
    When User navigates to todos page
    Then User validates the todos associated with the user
      | delectus aut autem                 |
      | quis ut nam facilis et officia qui |
      | fugiat veniam minus                |
      | et porro tempora                   |

  Scenario: Validate that can change the status of a task
    When User navigates to todos page
    Then User change the status of the tasks
      | delectus aut autem                 |
      | quis ut nam facilis et officia qui |
      | fugiat veniam minus                |
      | et porro tempora                   |
      | illo expedita consequatur quia in  |