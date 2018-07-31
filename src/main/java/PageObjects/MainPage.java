package PageObjects;

import Core.Element;
import org.openqa.selenium.By;

public class MainPage {

    By payments = By.xpath("//a[text() = 'Платежи']");

    public PaymentsPage clickPayments(){
        Element.click(payments);
        return new PaymentsPage();
    }
}
