@CreateBoard @Parallel
Feature: New board
  //Background: Complete Login
    //Given User Logs in with "Google"


  Scenario: Create a new board from 'Your workspaces'
    Given User Logs in with "Google"
    When User clicks on -Create new board- from -YOUR WORKSPACES-
      And User types board title "BoardTEST"
      And User clicks -Create- Button
    Then User is in "BoardTEST | Trello" page


    Scenario: Create a new board from templates
      Given User Logs in with "Google"
      When User clicks templates
        And User select "1-on-1 Meeting Agenda" template
        And User clicks -Create- Button
      Then User is in "1-on-1 Meeting Agenda | Trello" page

