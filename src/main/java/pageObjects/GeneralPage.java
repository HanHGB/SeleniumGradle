package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {

    //Elements
    protected WebElement getTabLogin(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/Login.cshtml']")); }
    protected WebElement getTabLogout(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/Logout']")); }
    protected WebElement getTabFAQ(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='#']")); }
    protected WebElement getTabContact(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/Contact.cshtml']")); }
    protected WebElement getTabTimetable(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='TrainTimeListPage.cshtml']")); }
    protected WebElement getTabTicketPrice(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/TrainPriceListPage.cshtml']")); }
    protected WebElement getTabBookTicket(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/BookTicketPage.cshtml']")); }
    protected WebElement getTabRegister(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']")); }
    protected WebElement getTabMyTicket(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/ManageTicket.cshtml']")); }
    protected WebElement getTabChangePassword(){ return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/ChangePassword.cshtml']")); }
    protected WebElement getLblWelcomeMessage(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong")); }
    protected WebElement getTxtTabName(String tabName){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='" + tabName + "']")); }

    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public void gotoLoginPage(){
        this.getTabLogin().click();
    }

    public void logout(){
        this.getTabLogout().click();
    }

    public void gotoFAQPage(){
        this.getTabFAQ().click();
    }

    public void gotoContactPage(){
        this.getTabContact().click();
    }

    public void gotoTimetablePage(){
        this.getTabTimetable().click();
    }

    public void gotoTicketPricePage(){
        this.getTabTicketPrice().click();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket().click();
    }

    public void gotoRegisterPage(){  this.getTabRegister().click(); }

    public void gotoMyTicketPage(){
        this.getTabMyTicket().click();
    }

    public void gotoChangePasswordPage(){
        this.getTabChangePassword().click();
    }

    public boolean getTabName(String tabName){
        return this.getTxtTabName(tabName).isDisplayed();
    }
}
