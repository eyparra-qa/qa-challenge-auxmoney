Feature: Validate the information on the albums page

  Background:
    Given User is in the users page

  Scenario: Validate that album items can be moved to the left
    When User clicks on the "Leanne Graham" to see the details info
    Then User validate that when moving to the left the new item is "sunt qui excepturi placeat culpa" in "albums" page

  Scenario Outline: Validate the albums associated with the user
    When User clicks on the "<userName>" to see the details info
    And User navigates to albums page
    Then User validates the "<albums>" associated with the user
    Examples:
      | userName      | albums                                                                                                                              |
      | Leanne Graham | quidem molestiae enim,sunt qui excepturi placeat culpa,omnis laborum odio                                                           |
      | Ervin Howell  | quam nostrum impedit mollitia quod et dolor,consequatur autem doloribus natus consectetur,ab rerum non rerum consequatur ut ea unde |