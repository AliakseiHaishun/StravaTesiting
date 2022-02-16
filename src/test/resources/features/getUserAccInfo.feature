@test
Feature: Get user's account info
  Scenario: Get user's account info and verify with
    When User is sends a get request to get the Account data.

    Then User's acc data are comparing with test data
    |96513877, "Frank", "Lampard"|