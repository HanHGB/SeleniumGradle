package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Elements
    protected WebElement getLinkRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/Register.cshtml']"));
    }

    //Methods
    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
