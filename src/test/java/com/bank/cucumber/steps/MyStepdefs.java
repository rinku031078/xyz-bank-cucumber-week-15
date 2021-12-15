package com.bank.cucumber.steps;

import com.bank.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    @Given("^I am on xyz bank homepage$")
    public void iAmOnXyzBankHomepage() {
    }

    @And("^I click on bank manager Login button$")
    public void iClickOnBankManagerLoginButton() {
        new BankManagerLoginPage().clickOnBankManagerLoginBtn();
    }

    @When("^I add new customer account$")
    public void iAddNewCustomerAccount() {
        new AddCustomerPage().clickOnAddCustomerButton();
        new AddCustomerPage().enterFirstName();
        new AddCustomerPage().enterLastName();
        new AddCustomerPage().enterPostCode();
        new AddCustomerPage().clickOnAddToCustomerFinalBtn();
    }

    @Then("^I should add customer successfully$")
    public void iShouldAddCustomerSuccessfully() {
        new AddCustomerPage().verifyPopUpMessage();
    }

    @Given("^I have added a customer successfully$")
    public void iHaveAddedACustomerSuccessfully() {
        new BankManagerLoginPage().clickOnBankManagerLoginBtn();
        new AddCustomerPage().clickOnAddCustomerButton();
        new AddCustomerPage().enterFirstName();
        new AddCustomerPage().enterLastName();
        new AddCustomerPage().enterPostCode();
        new AddCustomerPage().clickOnAddToCustomerFinalBtn();
        new AddCustomerPage().verifyPopUpMessage();
    }

    @And("^I click on open account button by navigating on Home page under Bank managers login$")
    public void iClickOnOpenAccountButtonByNavigatingOnHomePageUnderBankManagersLogin() throws InterruptedException {
        new HomePage().clickOnHomeButton();
        new HomePage().clickOnBankManagerLoginBtn();
        new OpenAccountPage().clickOnOpenAccountBtn();
        new OpenAccountPage().selectCustomerName();
        new OpenAccountPage().selectCurrencyDropDown();
    }

    @When("^I click on process button$")
    public void iClickOnProcessButton() {
        new OpenAccountPage().clickOnProcessBtn();
    }

    @Then("^I should be able to open account successfully$")
    public void iShouldBeAbleToOpenAccountSuccessfully() {
        new OpenAccountPage().verifyPopUpMessage();
    }

    @And("^I click on customer login button by navigating on Home page$")
    public void iClickOnCustomerLoginButtonByNavigatingOnHomePage() {
        new CustomersPage().clickonHomeButton();
        new HomePage().clickOnCustomerLoginBtn();
    }

    @When("^I login using registered customer login details$")
    public void iLoginUsingRegisteredCustomerLoginDetails() throws InterruptedException {
        new OpenAccountPage().selectCustomerName();
       new  CustomerLoginPage().clickOnLoginBtn();
    }

    @Then("^I should be able to login successfully$")
    public void iShouldBeAbleToLoginSuccessfully() {
        new CustomersPage().isLogoutDisplayed();
    }

    @When("^I click on logout button$")
    public void iClickOnLogoutButton() {
        new CustomersPage().verifyMessage();
    }

    @Then("^I should be able to logout successfully$")
    public void iShouldBeAbleToLogoutSuccessfully() {
        new CustomersPage().isHomeButtonDisplayed();
    }

    @Given("^I have a valid bank account$")
    public void iHaveAValidBankAccount() throws InterruptedException {
        new BankManagerLoginPage().clickOnBankManagerLoginBtn();
        new AddCustomerPage().clickOnAddCustomerButton();
        new AddCustomerPage().enterFirstName();
        new AddCustomerPage().enterLastName();
        new AddCustomerPage().enterPostCode();
        new AddCustomerPage().clickOnAddToCustomerFinalBtn();
        new AddCustomerPage().verifyPopUpMessage();
        new HomePage().clickOnHomeButton();
        new HomePage().clickOnBankManagerLoginBtn();
        new OpenAccountPage().clickOnOpenAccountBtn();
        new OpenAccountPage().selectCustomerName();
        new OpenAccountPage().selectCurrencyDropDown();
        new OpenAccountPage().clickOnProcessBtn();
        new OpenAccountPage().verifyPopUpMessage();
    }

    @And("^I logged in using valid customer details$")
    public void iLoggedInUsingValidCustomerDetails() throws InterruptedException {
        new CustomersPage().clickonHomeButton();
        new HomePage().clickOnCustomerLoginBtn();
        new OpenAccountPage().selectCustomerName();
        new CustomerLoginPage().clickOnLoginBtn();
    }

    @When("^I deposit \"([^\"]*)\" money by navigating on deposit tab$")
    public void iDepositMoneyByNavigatingOnDepositTab(String depositAmount)  {
        new AccountPage().clickOnDepositTab();
        new AccountPage().depositMoney(depositAmount);
        new AccountPage().clickOnDepositFinalTab();

    }

    @Then("^I should be able to deposit money successfully$")
    public void iShouldBeAbleToDepositMoneySuccessfully() {
        //String expectedMessage = "Deposit Successful";
       // String actualMessage = AccountPage.getMessageToVerifyDeposit();
        //Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("^I withdraw \"([^\"]*)\" money$")
    public void iWithdrawMoney(String withdrawAmount) throws InterruptedException {
        new CustomersPage().clickonHomeButton();
        new HomePage().clickOnCustomerLoginBtn();
        new OpenAccountPage().selectCustomerName();
        new CustomerLoginPage().clickOnLoginBtn();
        new AccountPage().clickToWithdrawalBtn();
        new AccountPage().enterWithdrawalAmount(withdrawAmount);
        new AccountPage().clickOnWithdrawalFinalTab();
    }

    @Then("^I should be able to withdraw money successfully$")
    public void iShouldBeAbleToWithdrawMoneySuccessfully() {
    }
}
