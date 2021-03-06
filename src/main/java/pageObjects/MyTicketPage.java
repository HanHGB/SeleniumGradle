package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.Constant.WEBDRIVER;
import static common.Utilities.scrollDownPage;
import static common.Utilities.selectValueInCbx;

public class MyTicketPage extends GeneralPage {

    //Elements
    protected WebElement getTxtDepartDateFilter() {
        return WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']"));
    }

    protected WebElement getCbxFilterName(String name) {
        return WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='Filter" + name + "']"));
    }

    protected WebElement getBtnFilter() {
        return WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//input[@value='Apply Filter']"));
    }

    protected WebElement getLblTitle() {
        return WEBDRIVER.findElement(By.tagName("h1"));
    }

    protected WebElement getBtnCancel(String departStation, String arriveStation, String seatType, String departDate,
                                      String bookDate, String expiredDate, String status) {

        return WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departStation
                + "')]/following-sibling::td[contains(.,'" + arriveStation + "')]/following-sibling::td[contains(.,'" + seatType
                + "')]/following-sibling::td[contains(.,'" + departDate + "')]/following-sibling::td[contains(.,'" + bookDate
                + "')]/following-sibling::td[contains(.,'" + expiredDate + "')]/following-sibling::td[contains(.,'" + status
                + "')]/following-sibling::td/input"));
    }

    protected WebElement getLblFilterMsg() {
        return WEBDRIVER.findElement(By.xpath("//div[@class='Filter']//select[@name='FilterStatus']"));
    }

    protected WebElement getLblFilterDateErrorMsg() {
        return WEBDRIVER.findElement(By.xpath("///form[@name='FilterForm']//div[@class='Filter']/div[@class='error message']"));
    }

    protected WebElement getRowOfTicket(String departStation, String arriveStation, String seatType, String departDate,
                                        String bookDate, String expiredDate, String status) {
        return WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']//td[contains(.,'" + departStation
                + "')]/following-sibling::td[contains(.,'" + arriveStation + "')]/following-sibling::td[contains(.,'" + seatType
                + "')]/following-sibling::td[contains(.,'" + departDate + "')]/following-sibling::td[contains(.,'" + bookDate
                + "')]/following-sibling::td[contains(.,'" + expiredDate + "')]/following-sibling::td[contains(.,'" + status
                + "')]/parent::tr"));
    }

    //Methods
    public void filterTicket(String departStation, String arriveStation, String departDate, String status) {

        selectValueInCbx(getCbxFilterName("DpStation"), departStation);
        selectValueInCbx(getCbxFilterName("ArStation"), arriveStation);
        selectValueInCbx(getTxtDepartDateFilter(), departDate);
        selectValueInCbx(getCbxFilterName("Status"), status);

        this.getBtnFilter().click();
    }

    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String expiredDate, String status) {

        WebElement btnCancel = this.getBtnCancel(departStation, arriveStation, seatType, departDate, bookDate, expiredDate, status);
        scrollDownPage(btnCancel);
        btnCancel.click();
        WEBDRIVER.switchTo().alert().accept();
    }

    public String getFilterMsg() {
        return this.getLblFilterMsg().getText();
    }

    public String getFilterDateErrorMsg() {
        return this.getLblFilterDateErrorMsg().getText();
    }

    public String getTitle() {
        return this.getLblTitle().getText();
    }

    //Check ticket is exist or not
    public boolean findTicket(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String expiredDate, String status) {
        try {
            getRowOfTicket(departStation, arriveStation, seatType, departDate, bookDate, expiredDate, status);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public int getRowTable() {
        WebElement table = WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']/tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        return rows_table.size();
    }

}
