package page.objects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketSuccessfullyPage extends GeneralPage{

    //Elements
    public WebElement getTxtDepartStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtArriveStation(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtSeatType(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtDepartDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtBookDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Book Date']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtExpiredDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Expired Date']/preceding-sibling::th)+1]"));
    }

    public WebElement getTxtAmount(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Amount']/preceding-sibling::th)+1]"));
    }
    public WebElement getTxtTotalPrice(){
        return Constant.WEBDRIVER.findElement(By.xpath("//table//td[count(//th[.='Total Price']/preceding-sibling::th)+1]"));
    }

    //Methods
}
