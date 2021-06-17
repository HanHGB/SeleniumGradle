package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmCodePage extends GeneralPage {
    //Elements
    protected WebElement getTxtCode(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='confirmationCode']")); }
    protected WebElement getBtnConfirm(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")); }

    //Methods
    public void confirmationCode(String code){
        this.getTxtCode().sendKeys(code);
        this.getBtnConfirm().click();
    }
}
