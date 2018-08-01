package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverSingleton {

    private static EventFiringWebDriver driver;

    private WebDriverSingleton(){}

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            driver.register(new MyListener());
        }
        return driver;
    }

    public static void close(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
