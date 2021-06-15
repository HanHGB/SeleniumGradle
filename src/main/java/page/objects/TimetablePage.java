package page.objects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage {

    //Declare
    Utilities utilities = new Utilities();

    //Elements
    public WebElement getTxtDepartStation(String departStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']"
                + "/preceding-sibling::th)+1][.='" + departStation + "']"));
    }

    public WebElement getTxtArriveStation(String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']"
                + "/preceding-sibling::th)+1][.='" + arriveStation + "']"));
    }

    public WebElement getLinkCheckPrice(String departStation, String arriveStation){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']/preceding-sibling::th)+1][.='" + departStation
                        + "']/../td[count(//th[.='Arrive Station']/preceding-sibling::th)+1][.='" + arriveStation
                        + "']/../td[count(//th[.='Check Price']/preceding-sibling::th)+1]"));
    }

    public WebElement getLinkBookTicket(String departStation, String arriveStation){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']/preceding-sibling::th)+1][.='" + departStation
                + "']/../td[count(//th[.='Arrive Station']/preceding-sibling::th)+1][.='" + arriveStation
                + "']/../td[count(//th[.='Book ticket']/preceding-sibling::th)+1]"));
    }

    //Methods
    public TicketPricePage gotoCheckPricePage(String departStation, String arriveStation){

        WebElement linkCheckPrice = this.getLinkCheckPrice(departStation, arriveStation);
        utilities.scrollDownPage(linkCheckPrice);
        linkCheckPrice.click();
        return new TicketPricePage();
    }

    public BookTicketPage gotoBookTicketPage(String departStation, String arriveStation){

        WebElement linkBookTicket = this.getLinkBookTicket(departStation, arriveStation);
        utilities.scrollDownPage(this.getLinkBookTicket(departStation, arriveStation));
        this.getLinkBookTicket(departStation, arriveStation).click();
        return new BookTicketPage();
    }
}
