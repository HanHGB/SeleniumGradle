package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {

    //Elements
    protected WebElement getTxtTrainName(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th"));
    }

    protected WebElement getBtnBookTicket(String seatType){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='NoBorder']//td[contains(.,'" + seatType +"')]/..//a"));
    }

    //Methods
    public void gotoBookTicketPage(String seatType){
        this.getBtnBookTicket(seatType).click();
    }

    public String getTrainName(){
        return this.getTxtTrainName().getText();
    }
}
