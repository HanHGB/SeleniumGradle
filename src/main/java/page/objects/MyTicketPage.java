package page.objects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{

    //Declare
    Utilities utilities = new Utilities();

    //Elements
    public WebElement getCbxDepartStationFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']"));
    }

    public WebElement getCbxArriveStationFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterArStation']"));
    }

    public WebElement getTxtDepartDateFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']"));
    }

    public WebElement getCbxStatusFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    public WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@value='Apply Filter']"));
    }

    public WebElement getBtnCancel(String departStation, String arriveStation, String seatType, String departDate,
                                   String bookDate, String expiredDate, String status){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[.='" + departStation
                + "']/following-sibling::td[.='" + arriveStation + "']/following-sibling::td[.='" + seatType
                + "']/following-sibling::td[.='" + departDate + "']/following-sibling::td[.='" + bookDate
                + "']/following-sibling::td[.='" + expiredDate +"']/following-sibling::td[.='" + status
                + "']/following-sibling::td/input"));
    }

    //Methods
    public void filterTicket(String departStation, String arriveStation, String departDate, String status){

        utilities.selectValueInCbx(getCbxDepartStationFilter(), departStation);
        utilities.selectValueInCbx(getCbxArriveStationFilter(), arriveStation);
        utilities.selectValueInCbx(getTxtDepartDateFilter(), departDate);
        utilities.selectValueInCbx(getCbxStatusFilter(), status);

        this.getBtnFilter().click();
    }

    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate,
                             String bookDate, String expiredDate, String status){

        WebElement btnCancel = this.getBtnCancel(departStation, arriveStation, seatType, departDate, bookDate,
                expiredDate, status);
        utilities.scrollDownPage(btnCancel);
        btnCancel.click();

    }
}
