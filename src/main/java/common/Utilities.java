package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

    //Choose a value in a combo box
    public static void selectValueInCbx(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    //Scroll down to element of a page
    public static void scrollDownPage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Clear value in text box
    public static void clearValueInTxt(WebElement[] element) {
        for (int i = 0; i < element.length; i++)
            element[i].clear();
    }

    //Get value in combo box
    public static String getValueInCbx(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    //Change "\" to "/"
    public static String changeCharInWord(String str) {
        return str.replace("\\", "/");
    }
}
