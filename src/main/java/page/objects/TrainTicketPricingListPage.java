package page.objects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainTicketPricingListPage {

    //Declare
    Utilities utilities = new Utilities();

    //Elements
    public WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='NoBorder']//li[text()=" + departStation + "to" +
                        arriveStation + "]/../following-sibling::td/a[text()='Check Price']"));
    }

    //Methods
    public TicketPricePage checkPrice(String departStation, String arriveStation){

        WebElement btnCheckPrice = this.getBtnCheckPrice(departStation, arriveStation);
        utilities.scrollDownPage(btnCheckPrice);
        btnCheckPrice.click();
        return new TicketPricePage();
    }
}