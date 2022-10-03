Feature: Validate the information on the post page

  Background:
    Given User is in the users page
    When User clicks on the "Leanne Graham" to see the details info

  Scenario: Validate that post items can be moved to the left
    Then User validate that when moving to the left the new item is "qui est esse" in "posts" page

  Scenario: Validate the post's associated with the user
    When User navigates to posts page
    Then User validates the posts associated with the user
      | sunt aut facere repellat provident occaecati excepturi optio reprehenderit |
      | qui est esse                                                               |
      | ea molestias quasi exercitationem repellat qui ipsa sit aut                |

  Scenario: Validate the comments associated with the user's post
    When User navigates to posts page
    And User clicks on the first comment
    Then User validates the comments of the first post
      | id labore ex et quam laborum              |
      | quo vero reiciendis velit similique earum |

  Scenario: Validate that can return to the main page
    When User navigates to posts page
    And User clicks on the first comment
    Then User checks that can go back to the main page