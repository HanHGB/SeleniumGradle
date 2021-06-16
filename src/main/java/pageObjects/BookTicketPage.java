package pageObjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Declare
    private Utilities utilities = new Utilities();

    //Elements
    protected WebElement getCbxDepartDate(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='Date']")); }
    protected WebElement getCbxDepartStation(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='DepartStation']")); }
    protected WebElement getCbxArriveStation(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='ArriveStation']")); }
    protected WebElement getCbxSeatType(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='SeatType']")); }
    protected WebElement getCbxTicketAmount(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='TicketAmount']")); }
    protected WebElement getBtnBookTicket(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@value='Book ticket']")); }
    protected WebElement getLblTicketAmountErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form//label[@class='validation-error']")); }
    protected WebElement getLblBookTicketErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//p[@class='message error']")); }

    //Methods
    public BookTicketSuccessfullyPage bookTicket(int numberOfDays, String departStation, String arriveStation,
                                                 String seatType, int amountTicket){

        utilities.selectValueInCbx(getCbxDepartDate(), String.valueOf(numberOfDays));
        utilities.selectValueInCbx(getCbxDepartStation(), departStation);
        utilities.selectValueInCbx(getCbxArriveStation(), arriveStation);
        utilities.scrollDownPage(getCbxSeatType());
        utilities.selectValueInCbx(getCbxSeatType(),seatType);
        utilities.selectValueInCbx(getCbxTicketAmount(), String.valueOf(amountTicket));
        this.getBtnBookTicket().click();
        return new BookTicketSuccessfullyPage();
    }

    public String getTicketAmountMsg(){
        return this.getLblTicketAmountErrorMsg().getText();
    }

    public String getBookTicketErrorMsg(){
        return this.getLblBookTicketErrorMsg().getText();
    }
}
