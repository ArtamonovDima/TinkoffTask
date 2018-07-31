package PageObjects;

import Core.Element;
import org.openqa.selenium.By;

public class ZhkuMoskvaOplata {

    By codeField = By.xpath("//input[@name = 'provider-payerCode']");
    By periodField = By.xpath("//input[@name = 'provider-period']");
    By combinationField = By.xpath("//div[@class = 'Input__value_2Kx90']/input");
    By codeFieldErrorMessage = By.xpath(
            "//div[@class = 'ui-form__row ui-form__row_text ui-form__row_default-error-view-visible']/div/div[2]");
    By periodFieldErrorMessage = By.xpath(
            "//div[@class = 'ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']/div/div[2]");
    By combinationFieldErrorMessage = By.xpath(
            "//div[@class = 'ui-form__row ui-form__row_amount ui-form__row_default-error-view-visible']/div/div[2]");
    By button = By.xpath("//button/h2[text() = 'Оплатить ЖКУ в Москве']");



    public void sendCode(String code){
        Element.sendKeys(codeField, code);
    }

    public void sendPeriod(String period){
        Element.sendKeys(periodField, period);
    }

    public void sendCombination(String comb){
        Element.sendKeys(combinationField, comb);
    }

    public String getErrorCodeMessage(){
        return Element.getText(codeFieldErrorMessage);
    }

    public String getErrorPeriodMessage(){
        return Element.getText(periodFieldErrorMessage);
    }

    public String getErrorCombMessage(){
        return Element.getText(combinationFieldErrorMessage);
    }

    public String getTitle(){
        return Element.getTitle();
    }

    public void clickButton(){
        Element.click(button);
    }
}
