package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {

private static WebDriver driver = WebDriverSingleton.getInstance();
private static WebDriverWait wait = new WebDriverWait(driver, 20);

public static void click(By locator){
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}

public static void sendKeys(By locator, String text){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
}

public static String getText(By locator){
    return
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
}

public static String getTitle(){
    return
            driver.getTitle();
}

public static void getUrl(String url){
    driver.get(url);
}

public static void close(){
    WebDriverSingleton.close();
}
}