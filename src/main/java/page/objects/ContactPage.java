package page.objects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {

    //Elements
    public WebElement getLinkEmail() { return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p/a")); }

    //Methods
    public void openMail(){
        this.getLinkEmail().click();
    }
}
