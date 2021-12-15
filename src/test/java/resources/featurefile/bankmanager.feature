Feature: xyz bank test
  As a user I want to all bank functionality
  @Smoke @Regression
  Scenario: Verify that Bank manager should add customer successfully
    Given I am on xyz bank homepage
    And I click on bank manager Login button
    When I add new customer account
    Then I should add customer successfully
  @Sanity @Regression
  Scenario: Verify that Bank manager should open account successfully
    Given I have added a customer successfully
    And I click on open account button by navigating on Home page under Bank managers login
    When I click on process button
    Then I should be able to open account successfully
  @Regression
  Scenario: Verify that customer should login and logout successfully
    Given I have added a customer successfully
    And I click on customer login button by navigating on Home page
    When I login using registered customer login details
    Then I should be able to login successfully
    When I click on logout button
    Then I should be able to logout successfully
  @Regression
  Scenario: verify that customer should be able to deposit money successfully
    Given I have a valid bank account
    And I logged in using valid customer details
    When I deposit "100" money by navigating on deposit tab
    Then I should be able to deposit money successfully
  @Regression
  Scenario: Verify that customer should be able to withdraw money successfully
    Given I have a valid bank account
    And I logged in using valid customer details
    And I deposit "100" money by navigating on deposit tab
    When I withdraw "50" money
    Then I should be able to withdraw money successfully