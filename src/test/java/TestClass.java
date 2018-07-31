import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    String iskomuy;

    @Test
    public void test1(){

    basePage.getUrl("https://www.tinkoff.ru");
    mainPage.clickPayments().clickKommunalniePlatezhi();






    }
}
