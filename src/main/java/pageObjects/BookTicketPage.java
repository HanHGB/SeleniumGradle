package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Utilities.*;

public class BookTicketPage extends GeneralPage {

    //Elements
    protected WebElement getCbxName(String name) {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='" + name + "']"));
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@value='Book ticket']"));
    }

    protected WebElement getLblTicketAmountErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//label[@class='validation-error']"));
    }

    protected WebElement getLblBookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//p[@class='message error']"));
    }

    protected WebElement getLblTitle() {
        return Constant.WEBDRIVER.findElement(By.tagName("h1"));
    }

    //Methods
    public void bookTicket(String date, String departStation, String arriveStation,
                           String seatType, int amountTicket) {

        selectValueInCbx(getCbxName("Date"), date);
        selectValueInCbx(getCbxName("DepartStation"), departStation);
        selectValueInCbx(getCbxName("ArriveStation"), arriveStation);
        scrollDownPage(getCbxName("SeatType"));
        selectValueInCbx(getCbxName("SeatType"), seatType);
        selectValueInCbx(getCbxName("TicketAmount"), String.valueOf(amountTicket));
        this.getBtnBookTicket().click();
    }

    public String getTicketAmountMsg() {
        return this.getLblTicketAmountErrorMsg().getText();
    }

    public String getBookTicketErrorMsg() {
        return this.getLblBookTicketErrorMsg().getText();
    }

    public String getTitle() {
        return this.getLblTitle().getText();
    }

    public String getValueOfDepartStation() {
        return getValueInCbx(getCbxName("DepartStation"));
    }

    public String getValueOfArriveStation() {
        return getValueInCbx(getCbxName("ArriveStation"));
    }

    public String getValueOfDepartDate() {
        return getValueInCbx(getCbxName("Date"));
    }

    public String getValueOfTicketAmount() {
        return getValueInCbx(getCbxName("TicketAmount"));
    }

}
