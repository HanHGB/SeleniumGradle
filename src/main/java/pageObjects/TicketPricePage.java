package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    //Elements
    public WebElement getTxtTrainName(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th"));
    }

    public WebElement getBtnBookTicket(String seatType){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='NoBorder']//td[contains(.,'" + seatType +"')]/."
                + ".//a"));
    }

    //Methods
    public BookTicketPage gotoBookTicketPage(String seatType){
        this.getBtnBookTicket(seatType).click();
        return new BookTicketPage();
    }

}
