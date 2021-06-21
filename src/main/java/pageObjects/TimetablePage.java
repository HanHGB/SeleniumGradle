package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Utilities.scrollDownPage;

public class TimetablePage extends GeneralPage {

    //Elements
    protected WebElement getTxtDepartStation(String departStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']"
                + "/preceding-sibling::th)+1][.='" + departStation + "']"));
    }

    protected WebElement getTxtArriveStation(String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']"
                + "/preceding-sibling::th)+1][.='" + arriveStation + "']"));
    }

    protected WebElement getLinkCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']/preceding-sibling::th)+1][.='" + departStation
                + "']/../td[count(//th[.='Arrive Station']/preceding-sibling::th)+1][.='" + arriveStation
                + "']/../td[count(//th[.='Check Price']/preceding-sibling::th)+1]"));
    }

    protected WebElement getLinkBookTicket(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[.='Depart Station']/preceding-sibling::th)+1][.='" + departStation
                + "']/../td[count(//th[.='Arrive Station']/preceding-sibling::th)+1][.='" + arriveStation
                + "']/../td[count(//th[.='Book ticket']/preceding-sibling::th)+1]"));
    }

    //Methods
    public void checkPrice(String departStation, String arriveStation) {

        WebElement linkCheckPrice = this.getLinkCheckPrice(departStation, arriveStation);
        scrollDownPage(linkCheckPrice);
        linkCheckPrice.click();
    }

    public void bookTicket(String departStation, String arriveStation) {

        WebElement linkBookTicket = this.getLinkBookTicket(departStation, arriveStation);
        scrollDownPage(this.getLinkBookTicket(departStation, arriveStation));
        this.getLinkBookTicket(departStation, arriveStation).click();
    }

    public String getDepartStation(String departStation) {
        return this.getTxtDepartStation(departStation).getText();
    }

    public String getArriveStation(String arriveStation) {
        return this.getTxtDepartStation(arriveStation).getText();
    }


}
