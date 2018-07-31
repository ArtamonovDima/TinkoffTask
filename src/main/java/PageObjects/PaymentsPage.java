package PageObjects;

import Core.Element;
import org.openqa.selenium.By;


public class PaymentsPage {

    By kommunalniePlatezhi = By.xpath("//span[text() = 'ЖКХ']");
    By searchField = By.xpath("//input[@class = 'Input__valueContent_1Os4v Input__valueContent_alone_2RBHi Input__valueContent_primary_3sxF0']");
    By webElementList = By.xpath("//div[@class = 'Grid__column_3qcJA Grid__column_size_12_2AOcu Grid__column_sizeMobile_12_1mA7y']");

    public KommunalniePlatezhi clickKommunalniePlatezhi(){
        Element.click(kommunalniePlatezhi);
        return new KommunalniePlatezhi();
    }

    public PaymentsPage inputSearchField(String name){
        Element.sendKeys(searchField, name);
        return this;
    }

    public void clickFirstElementOfResult(){
        Element.click(webElementList);
        //return webElementList.get(0);
    }
}
