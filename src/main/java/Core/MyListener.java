package Core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class MyListener extends AbstractWebDriverEventListener {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOGGER.info(" find" + by); }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println(by + " found");

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

        System.out.println(throwable);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File("C:\\screenshots\\ExcScreenshot.png"));
        }catch (IOException e){e.printStackTrace();}

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info( "click" + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println(" element clicked");
    }

}
