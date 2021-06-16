package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmCodePage extends GeneralPage {
    //Elements
    public WebElement getTxtCode(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='confirmationCode']")); }
    public WebElement getBtnConfirm(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")); }

    //Methods
    public ConfirmCodePage confirmationCode(String code){
        this.getTxtCode().sendKeys(code);
        this.getBtnConfirm().click();
        return new ConfirmCodePage();
    }
}
