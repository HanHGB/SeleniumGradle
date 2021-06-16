package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {

    //Elements
//    protected WebElement getTabLogin(){
//        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']"));
//    }

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/Login.cshtml']"));
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/Logout']"));
    }

    protected WebElement getTabFAQ(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='#']"));
    }

    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/Contact.cshtml']"));
    }

    protected WebElement getTabTimetable(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='TrainTimeListPage.cshtml']"));
    }

    protected WebElement getTabTicketPrice(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/TrainPriceListPage.cshtml']"));
    }

    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/BookTicketPage.cshtml']"));
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/Register.cshtml']"));
    }

    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Page/ManageTicket.cshtml']"));
    }

    protected WebElement getTabChangePassword(){
        return Constant.WEBDRIVER.findElement(By.cssSelector("a[href^='/Account/ChangePassword.cshtml']"));
    }

    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong"));
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public HomePage logout(){
        this.getTabLogout().click();
        return new HomePage();
    }

    public FAQPage gotoFAQPage(){
        this.getTabFAQ().click();
        return new FAQPage();
    }

    public ContactPage gotoContactPage(){
        this.getTabContact().click();
        return new ContactPage();
    }

    public TimetablePage gotoTimetable(){
        this.getTabTimetable().click();
        return new TimetablePage();
    }

    public TrainTicketPricingListPage gotoTicketPrice(){
        this.getTabTicketPrice().click();
        return new TrainTicketPricingListPage();
    }

    public BookTicketPage gotoBookTicket(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public MyTicketPage gotoMyTicket(){
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public ChangePasswordPage gotoChangePassword(){
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }
}
