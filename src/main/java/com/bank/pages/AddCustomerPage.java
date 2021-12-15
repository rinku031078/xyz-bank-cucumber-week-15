package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddCustomerPage extends Utility {
    public AddCustomerPage()
    {
        PageFactory.initElements(driver,this);}
    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @FindBy(xpath = "//div[@class='center']//button[@ng-class='btnClass1']")
    WebElement _addCustomerBtn;

    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='First Name']")
    WebElement _firstNameField;

    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='Last Name']")
    WebElement _lastNameField;

    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='Post Code']")
    WebElement _postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement _addCustomerBtnFinal;

    // This method Clicks on Add To Customer Button
    public void clickOnAddCustomerButton() {
        log.info("Clicks on Add Customer Button " + _addCustomerBtn.toString());
        clickOnElement(_addCustomerBtn);
    }

    //This method clicks and send text to First Name Field
    public void enterFirstName() {
        log.info("Click on Add First Name Field " + _firstNameField.toString());
        clickOnElement(_firstNameField);
        sendTextToElement(_firstNameField, "Deeva");
    }

    //This method clicks and send text to Last Name Field
    public void enterLastName() {
        log.info("Sends text to LastName Field " + _lastNameField.toString());
        clickOnElement(_lastNameField);
        sendTextToElement(_lastNameField, "Jimulia");
    }
    //This method clicks and send text to Post Code Field
    public void enterPostCode() {
        log.info("Send text to PostCode Field " + _postCodeField.toString());
        clickOnElement(_postCodeField);
        sendTextToElement(_postCodeField, "GGG hhh");
    }
    // This method clicks on Final Add Customer Button
    public void clickOnAddToCustomerFinalBtn() {
        log.info("Clicks on Add to Customer Button " + _addCustomerBtnFinal);
        clickOnElement(_addCustomerBtnFinal);
    }
    public void verifyPopUpMessage() {
        Alert alertDialog = driver.switchTo().alert();
        String alertText = alertDialog.getText();
        Assert.assertTrue(alertText.contains("Customer added successfully"));
        alertDialog.accept();
    }
}
