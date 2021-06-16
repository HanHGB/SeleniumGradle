package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Elements
    public WebElement getLinkRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/Register.cshtml']"));
    }

    //Methods
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
