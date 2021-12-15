package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenAccountPage extends Utility {
    public  OpenAccountPage(){
        PageFactory.initElements(driver,this);
    }
    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    @FindBy(xpath = "//div[@class='center']//button[@ng-class='btnClass2']")
    WebElement _openAccountBtn;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement _customerNameDropDown;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement _currencyDropDown;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement _processBtn;

    //This method clicks on Open Account Button
    public void clickOnOpenAccountBtn() {
        log.info("Clicks on Open Account Button " + _openAccountBtn.toString());
        clickOnElement(_openAccountBtn);
    }

    //This method selects Customer Name from DropDown
    public void selectCustomerName() {
        log.info("Selects Customer Name from Drop Down " + _customerNameDropDown.toString());
        clickOnElement(_customerNameDropDown);
        selectByIndexFromDropDown(_customerNameDropDown, 6);
    }

    //This method selects Currency from DropDown
    public void selectCurrencyDropDown() {
        log.info("Selects Currency Drop Down");
        selectByIndexFromDropDown(_currencyDropDown, 1);
    }

    // This method clicks on Process Button
    public void clickOnProcessBtn() {
        log.info("Clicks on Process Button " + _processBtn.toString());
        clickOnElement(_processBtn);
    }
    //pop up message
    public void verifyPopUpMessage() {
        Alert alertDialog = driver.switchTo().alert();
        String alertText = alertDialog.getText();
        Assert.assertTrue(alertText.contains("Account created successfully"));
        alertDialog.accept();

    }

}
