package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }
    private static final Logger log = LogManager.getLogger(AccountPage.class.getName());

    @FindBy(xpath = "//button[2][contains(text(),'Deposit')]")
    WebElement _depositClick;

    @FindBy(xpath = "//div[@class='form-group']/input")
    WebElement _depositAmount;

    @FindBy(xpath = "//form[@name='myForm']/button")
    WebElement _depositFinalClick;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement _getMessageDeposit;

    @FindBy(xpath = "//button[3][contains(text(),'Withdraw')]")
    WebElement _withdrawalBtn ;

    @FindBy(xpath = "//div[@class='form-group']/input")
    WebElement _withdrawalAmount;

    @FindBy(xpath = "//form[@name='myForm']/button")
    WebElement _withdrawalFinalClick;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement _getTransactionMessage;



    //This method will click to deposit Tab
    public void clickOnDepositTab() {
        log.info("Click on Deposit " + _depositClick.toString() );
        clickOnElement(_depositClick);
    }
    //This method will deposit money
    public void depositMoney(String money) {
        log.info("Deposit Money " + _depositAmount.toString());
        sendTextToElement(_depositAmount, money);
    }

    public void clickOnDepositFinalTab() {
        log.info("Click on deposit" + _depositFinalClick.toString());
        clickOnElement(_depositFinalClick);
    }

    public String getMessageToVerifyDeposit() {
        log.info("Get Message to verify " + _getMessageDeposit.toString());
        return getTextFromElement(_getMessageDeposit);
    }
    public String getTransactionMessage() {
        log.info("Get Message to verify " + _getTransactionMessage.toString());
        return getTextFromElement(_getTransactionMessage);
    }

    //This method will click on withdrawal btn
    public void clickToWithdrawalBtn(){
        log.info("clicking on Withdrawal Button " + _withdrawalBtn.toString());
        clickOnElement(_withdrawalBtn);

    }
    //This method will withdrawal amount
    public void enterWithdrawalAmount(String withdrawal){
        log.info("Enter Withdrawal Amount " + _withdrawalAmount.toString());
        sendTextToElement(_withdrawalAmount,withdrawal);
    }
    public void clickOnWithdrawalFinalTab() {
        log.info("Clicking on Withdrawal " + _withdrawalFinalClick.toString());
        clickOnElement(_withdrawalFinalClick);
    }

    public String getMessageToVerify() {
        log.info("Get message to verify " + _getMessageDeposit.toString());
        return getTextFromElement(_getMessageDeposit);
    }
}
