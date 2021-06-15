package page.objects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Elements
    public WebElement getCbxDepartDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='Date']"));
    }

    public WebElement getCbxDepartStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='DepartStation']"));
    }

    public WebElement getCbxArriveStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='ArriveStation']"));
    }

    public WebElement getCbxSeatType(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='SeatType']"));
    }

    public WebElement getCbxTicketAmount(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//select[@name='TicketAmount']"));
    }

    public WebElement getBtnBookTicket(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@value='Book ticket']"));
    }

    public BookTicketSuccessfullyPage bookTicket(int numberOfDays, String departStation, String arriveStation,
                                                 String seatType, int amountTicket){

        Utilities utilities = new Utilities();
        utilities.selectValueInCbx(getCbxDepartDate(), String.valueOf(numberOfDays));
        utilities.selectValueInCbx(getCbxDepartStation(), departStation);
        utilities.selectValueInCbx(getCbxArriveStation(), arriveStation);
        utilities.scrollDownPage(getCbxSeatType());
        utilities.selectValueInCbx(getCbxSeatType(),seatType);
        utilities.selectValueInCbx(getCbxTicketAmount(), String.valueOf(amountTicket));

        this.getBtnBookTicket().click();

        return new BookTicketSuccessfullyPage();
    }
}
