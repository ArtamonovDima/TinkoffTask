package PageObjects;

import Core.Element;
import org.openqa.selenium.By;

public class ZhkuMoskva {

    By oplata = By.xpath("//span[text() = 'Оплатить ЖКУ в Москве']");

    public ZhkuMoskvaOplata clickOplata(){
        Element.click(oplata);
        return new ZhkuMoskvaOplata();
    }
}
