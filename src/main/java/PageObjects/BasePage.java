package PageObjects;

import Core.Element;

public class BasePage {

    public void getUrl(String url){
        Element.getUrl(url);
    }

    public void close(){
        Element.close();
    }

    public void getScreenshot(){ Element.getScreenshot(); }
}
