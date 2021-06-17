package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketSuccessfullyPage extends GeneralPage{

    //Elements
    protected WebElement getTxtDepartStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtArriveStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtSeatType(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtDepartDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtBookDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Book Date']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtExpiredDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Expired Date']/preceding-sibling::th)+1]"));
    }

    protected WebElement getTxtAmount(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Amount']/preceding-sibling::th)+1]"));
    }
    protected WebElement getTxtTotalPrice(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Total Price']/preceding-sibling::th)+1]"));
    }

    protected WebElement getLblTitle() { return Constant.WEBDRIVER.findElement(By.tagName("h1")); }

    //Methods
    public String getDepartStation(){
        return this.getTxtDepartStation().getText();
    }

    public String getArriveStation(){
        return this.getTxtArriveStation().getText();
    }

    public String getSeatType(){
        return this.getTxtSeatType().getText();
    }

    public String getDepartDate(){
        return this.getTxtDepartDate().getText();
    }

    public String getBookDate(){
        return this.getTxtBookDate().getText();
    }

    public String getExpiredDate(){
        return this.getTxtExpiredDate().getText();
    }

    public String getAmountTicket(){
        return this.getTxtAmount().getText();
    }

    public String getTotalPrice(){
        return this.getTxtTotalPrice().getText();
    }

    public String getTitle(){
        return this.getLblTitle().getText();
    }
}
