Feature: Login

  @LoginTwoBrowsers
  Scenario Outline: Login in different browsers
    Given User opens trello in <browser>
    When User logs in
    Then User is in a page with title "Boards | Trello"
    Examples:
      |browser|
      |"Google"|
      |"Firefox"|


  @LoginGoogle @Parallel
  Scenario: Login with GOOGLE
    Given User opens trello in "Google"
    When User logs in
    Then User is in a page with title "Boards | Trello"




  @LoginFirefox
    Scenario: Login with FIREFOX
    Given User opens trello in "Firefox"
    When User logs in
    Then User is in a page with title "Boards | Trello"


