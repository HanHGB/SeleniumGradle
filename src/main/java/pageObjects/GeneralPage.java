package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {

    //Elements
    protected WebElement getTabName(String tabName) {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[contains(., '" + tabName + "')]"));
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong"));
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void gotoLoginPage() {
        this.getTabName("Login").click();
    }

    public void logout() {
        this.getTabName("Log out").click();
    }

    public void gotoFAQPage() {
        this.getTabName("FAQ").click();
    }

    public void gotoContactPage() {
        this.getTabName("Contact").click();
    }

    public void gotoTimetablePage() {
        this.getTabName("Timetable").click();
    }

    public void gotoTicketPricePage() {
        this.getTabName("Ticket price").click();
    }

    public void gotoBookTicketPage() {
        this.getTabName("Book ticket").click();
    }

    public void gotoRegisterPage() {
        this.getTabName("Register").click();
    }

    public void gotoMyTicketPage() {
        this.getTabName("My ticket").click();
    }

    public void gotoChangePasswordPage() {
        this.getTabName("Change password").click();
    }

    public boolean doesTabNameExist(String tabName) {
        return this.getTabName(tabName).isDisplayed();
    }

    public boolean findTab(String tabName) {
        try {
            this.getTabName(tabName).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException err) {
            return false;
        }
    }
}
