package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

    //Methods
    public void selectValueInCbx(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void scrollDownPage(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
