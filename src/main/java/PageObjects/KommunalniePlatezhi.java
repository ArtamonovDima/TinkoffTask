package PageObjects;

import Core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class KommunalniePlatezhi {

    By region = By.xpath("//div[text() = 'ЖКХ']/span/span/span");
    By firstElement = By.xpath("//section[@class = 'UILayoutSection__section_32gTj']//li/span/a");
    By searchField = By.xpath(
            "//input [@class = 'Input__valueContent_1Os4v Input__valueContent_alone_2RBHi Input__valueContent_primary_3sxF0']");
    By searchRegion = By.xpath("//input[@class = 'ui-input__field']");
    By firstRegionByName = By.xpath("//div[@class = 'UiRegions__uiRegions__layout_2wFF-']/div");
    By webElementList = By.xpath("//section[@class = 'UILayoutSection__section_32gTj']");

    public String getRegionName(){
        return Element.getText(region);
    }

    public KommunalniePlatezhi setRegion(String name){
        Element.click(region);
        Element.sendKeys(searchRegion, name);
        Element.click(firstRegionByName);
        return this;
    }

    public String getFirstElementName(){
        return Element.getAttribute(firstElement, "title" );
        }

    public ZhkuMoskva clickZhkuMoskva(){
        Element.click(firstElement);
        return new ZhkuMoskva();
    }

    public Boolean searchIskomuy(String iskomuy){
        List<WebElement> array = Element.getListOfElements(webElementList);
        for (WebElement element : array) {
            if(element.getAttribute("title").equals(iskomuy)){
                return true;
            }
        }
        return false;
    }
}
