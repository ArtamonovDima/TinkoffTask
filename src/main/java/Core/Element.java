package Core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Element {

private static WebDriver driver = WebDriverSingleton.getInstance();
private static WebDriverWait wait = new WebDriverWait(driver, 20);

public static void click(By locator){
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}

    public static void click(WebElement element){
        element.click();
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

public static String getAttribute(By locator, String atr){
    return
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(atr);
}

public static List<WebElement> getListOfElements(By locator){
    return
    //driver.findElements(locator);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}

public static void getUrl(String url){
    driver.get(url);
}

public static void close(){
    WebDriverSingleton.close();
}

public static void getScreenshot(){
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try{
        FileUtils.copyFile(scrFile, new File(
                "target/generated-sources/screenshots/Screenshot.png" + System.currentTimeMillis()));
    }catch (IOException e){e.printStackTrace();}
}
}
