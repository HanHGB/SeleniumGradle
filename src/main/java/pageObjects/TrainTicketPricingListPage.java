package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Utilities.scrollDownPage;

public class TrainTicketPricingListPage extends GeneralPage {

    //Elements
    protected WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='NoBorder']//li[text()=" + departStation + "to" +
                arriveStation + "]/../following-sibling::td/a[text()='Check Price']"));
    }

    //Methods
    public void checkPrice(String departStation, String arriveStation) {

        WebElement btnCheckPrice = this.getBtnCheckPrice(departStation, arriveStation);
        scrollDownPage(btnCheckPrice);
        btnCheckPrice.click();
    }
}
