package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketSuccessfullyPage extends GeneralPage {

    //Elements
    protected WebElement getTxtName(String name) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='" + name + "']/preceding-sibling::th)+1]"));
    }

    protected WebElement getLblTitle() {
        return Constant.WEBDRIVER.findElement(By.tagName("h1"));
    }

    //Methods
    public String getValueOfTxt(String name) {
        return this.getTxtName(name).getText();
    }

    public String getTitle() {
        return this.getLblTitle().getText();
    }
}
