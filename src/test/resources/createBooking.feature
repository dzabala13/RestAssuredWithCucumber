Feature: I can create a hotel reservation as a user

  Scenario: User can create and delete a hotel reservation
    Given User creates a new reservation
    And the user gives the information needed for booking
    When User creates hotel reservation
    Then Reservation was successfully created
    And User cancels the created reservation