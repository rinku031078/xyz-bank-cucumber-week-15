package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public  HomePage(){
        PageFactory.initElements(driver,this);
    }
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement _homeButton;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement _customerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement _bankManagerLoginBtn;

    //This method clicks on Customer Login Button
    public void clickOnCustomerLoginBtn() {
        log.info("Click on Customer Login Button " + _customerLoginBtn.toString());
        clickOnElement(_customerLoginBtn);
    }
    public void clickOnHomeButton() throws InterruptedException {
        log.info("Clicks on Home Button " + _homeButton.toString());
        Thread.sleep(2000);
        clickOnElement(_homeButton);
    }
    //This methid clicks on Bank Manager Login Button
    public void clickOnBankManagerLoginBtn() {
        log.info("Click on Bank Manager Login Button " + _bankManagerLoginBtn.toString() + "<br>");
        clickOnElement(_bankManagerLoginBtn);
    }
}
