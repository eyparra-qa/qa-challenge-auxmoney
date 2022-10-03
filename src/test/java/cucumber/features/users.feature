Feature: Validate the information on the users page

  Scenario Outline: Review user information
    Given User is in the users page
    Then User searches the list by "<user>"
    And Verify that the user name is "<user>"
    And Verify that the "<user>" have the nickName "<nickName>"
    And Verify that the "<user>" have the company name "<company>"
    Examples:
      | user             | nickName  | company            |
      | Leanne Graham    | Bret      | Romaguera-Crona    |
      | Ervin Howell     | Antonette | Deckow-Crist       |
      | Clementine Bauch | Samantha  | Romaguera-Jacobson |

  Scenario: Check scroll Down works
    Given User is in the users page
    Then User check that can scroll down in the page

  Scenario Outline: User validates the detail information
    Given User is in the users page
    When User clicks on the "<user>" to see the details info
    Then User verify that the user name is "<user>"
    And User verify that the nick name is "<nickName>"
    And User verify that the webside is "<webside>"
    And User verify that the email is "<email>"
    And User verify that the company is "<company>"
    Examples:
      | user          | nickName  | webside       | email             | company         |
      | Leanne Graham | Bret      | hildegard.org | Sincere@april.biz | Romaguera-Crona |
      | Ervin Howell  | Antonette | anastasia.net | Shanna@melissa.tv | Deckow-Crist    |

  Scenario: User validates back functionality
    Given User is in the users page
    When User clicks on the "Leanne Graham" to see the details info
    Then User clicks on back button and should see list of users page