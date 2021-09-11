@regression
Feature: Github login

@TestData 
Scenario: Github Test data setup
Given Create the test data

@Sanity 
Scenario: Github Login Test Scenario
Given user is already on Login Page
When title of login page is Git hub
Then loginpage is displayed

@Sanity 
Scenario: Github Login error Test Scenario
Given user is already on Login Page
When title of login page is Git hub
Then loginpage is displayed