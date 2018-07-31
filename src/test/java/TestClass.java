import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    String iskomuy;

    @Test(priority = 1)
    public void test1_7steps() {

        basePage.getUrl("https://www.tinkoff.ru");
        mainPage.clickPayments().clickKommunalniePlatezhi();

        if (kommunalniePlatezhi.getRegionName().equals("Москве")) {
            iskomuy = kommunalniePlatezhi.getFirstElementName();
            Assert.assertEquals("ЖКУ-Москва", iskomuy);
            kommunalniePlatezhi.clickZhkuMoskva();
        } else {
            kommunalniePlatezhi.setRegion("Москва");
            iskomuy = kommunalniePlatezhi.getFirstElementName();
            Assert.assertEquals("ЖКУ-Москва", iskomuy);
            kommunalniePlatezhi.clickZhkuMoskva();
        }

        zhkuMoskva.clickOplata();
        String oplataTitle = zhkuMoskvaOplata.getTitle();
        System.out.println(oplataTitle);


        zhkuMoskvaOplata.sendCode("123");
        zhkuMoskvaOplata.sendPeriod("00");
        //zhkuMoskvaOplata.sendCombination("100000");//падает TimeoutExeption
        zhkuMoskvaOplata.clickButton();

        System.out.println(zhkuMoskvaOplata.getErrorCodeMessage());
        Assert.assertEquals("Поле неправильно заполнено", zhkuMoskvaOplata.getErrorCodeMessage());
        System.out.println(zhkuMoskvaOplata.getErrorPeriodMessage());
        Assert.assertEquals("Поле заполнено некорректно", zhkuMoskvaOplata.getErrorPeriodMessage());
        //System.out.println(zhkuMoskvaOplata.getErrorCombMessage());
        //Assert.assertEquals("Максимум — 15 000 \u20BD", zhkuMoskvaOplata.getErrorCombMessage());

    }
    @Test(priority = 2)
    public void  test8_11steps(){
        mainPage.clickPayments().inputSearchField(iskomuy);
        Assert.assertEquals("ЖКУ-Москва\n" +
        "Коммунальные платежи", paymentsPage.getFirstElementOfResult());
        paymentsPage.clickFirstElementOfResult();

        zhkuMoskva.clickOplata();
        String oplataTitle2 = zhkuMoskvaOplata.getTitle();
        System.out.println(oplataTitle2);
        //Assert.assertEquals(oplataTitle2, oplataTitle);
    }

    @Test(priority = 3)
    public void test12_14steps(){
        mainPage.clickPayments().clickKommunalniePlatezhi().setRegion("Санкт-Петербург");
        Assert.assertFalse(kommunalniePlatezhi.searchIskomuy(iskomuy));
    }
}
