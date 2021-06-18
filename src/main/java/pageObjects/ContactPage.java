package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {

    //Elements
    protected WebElement getLinkEmail() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p/a"));
    }

    //Methods
    public void openMail() {
        this.getLinkEmail().click();
    }
}
