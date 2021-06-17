package pageObjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{

    //Declare
    private Utilities utilities = new Utilities();

    //Elements
    protected WebElement getCbxDepartStationFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterDpStation']"));
    }

    protected WebElement getCbxArriveStationFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterArStation']"));
    }

    protected WebElement getTxtDepartDateFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']"));
    }

    protected WebElement getCbxStatusFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    protected WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@value='Apply Filter']"));
    }

    protected WebElement getLblTitle() { return Constant.WEBDRIVER.findElement(By.tagName("h1")); }

    protected WebElement getBtnCancel(String departStation, String arriveStation, String seatType, String departDate,
                                   String bookDate, String expiredDate, String status){

        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departStation
                + "')]/following-sibling::td[contains(.,'" + arriveStation + "')]/following-sibling::td[contains(.,'" + seatType
                + "')]/following-sibling::td[contains(.,'" + departDate + "')]/following-sibling::td[contains(.,'" + bookDate
                + "')]/following-sibling::td[contains(.,'" + expiredDate +"')]/following-sibling::td[contains(.,'" + status
                + "')]/following-sibling::td/input"));
    }

    protected WebElement getLblFilterMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    protected WebElement getLblFilterDateErrorMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("///form[@name='FilterForm']//div[@class='Filter']/div[@class='error message']"));
    }

    protected WebElement getRowOfTicket(String departStation, String arriveStation, String seatType, String departDate,
                                        String bookDate, String expiredDate, String status){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departStation
                + "')]/following-sibling::td[contains(.,'" + arriveStation + "')]/following-sibling::td[contains(.,'" + seatType
                + "')]/following-sibling::td[contains(.,'" + departDate + "')]/following-sibling::td[contains(.,'" + bookDate
                + "')]/following-sibling::td[contains(.,'" + expiredDate +"')]/following-sibling::td[contains(.,'" + status
                + "')]/parent::tr"));
    }

    //Methods
    public void filterTicket(String departStation, String arriveStation, String departDate, String status){

        utilities.selectValueInCbx(getCbxDepartStationFilter(), departStation);
        utilities.selectValueInCbx(getCbxArriveStationFilter(), arriveStation);
        utilities.selectValueInCbx(getTxtDepartDateFilter(), departDate);
        utilities.selectValueInCbx(getCbxStatusFilter(), status);

        this.getBtnFilter().click();
    }

    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String expiredDate, String status){

        WebElement btnCancel = this.getBtnCancel(departStation, arriveStation, seatType, departDate, bookDate, expiredDate, status);
        utilities.scrollDownPage(btnCancel);
        btnCancel.click();
        Constant.WEBDRIVER.switchTo().alert().accept();

    }

    public String getFilterMsg(){
        return this.getLblFilterMsg().getText();
    }

    public String getFilterDateErrorMsg(){
        return this.getLblFilterDateErrorMsg().getText();
    }

    public String getTitle(){
        return this.getLblTitle().getText();
    }

    //Check ticket is exist or not
    public boolean findTicket(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String expiredDate, String status) {
        try {
            getRowOfTicket(departStation,arriveStation, seatType,departDate,bookDate,expiredDate,status);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
