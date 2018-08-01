import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    String iskomuy;

    @Test(priority = 1)
    public void test1_7steps() {

        basePage.getUrl("https://www.tinkoff.ru");
        basePage.getScreenshot();
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
        Assert.assertEquals(oplataTitle, "Оплата ЖКХ без комиссии. Коммунальные платежи онлайн");

        zhkuMoskvaOplata.sendCode("123456789");
        zhkuMoskvaOplata.sendPeriod("13.2018");
        zhkuMoskvaOplata.clickComb();
        zhkuMoskvaOplata.sendCombination("15001");
        zhkuMoskvaOplata.clickButton();

        Assert.assertEquals("Поле неправильно заполнено", zhkuMoskvaOplata.getErrorCodeMessage());
        Assert.assertEquals("Поле заполнено некорректно", zhkuMoskvaOplata.getErrorPeriodMessage());
        Assert.assertEquals("Максимум — 15 000 \u20BD", zhkuMoskvaOplata.getErrorCombMessage());

    }
    @Test(priority = 2)
    public void  test8_11steps(){

        mainPage.clickPayments().inputSearchField(iskomuy);
        Assert.assertEquals("ЖКУ-Москва\n" +
        "Коммунальные платежи", paymentsPage.getFirstElementOfResult());
        paymentsPage.clickFirstElementOfResult();

        zhkuMoskva.clickOplata();
        String oplataTitle2 = zhkuMoskvaOplata.getTitle();
        Assert.assertEquals(oplataTitle2, "ЖКУ-Москва | Онлайн-проверка задолженностей ЖКУ-Москва");
    }

    @Test(priority = 3)
    public void test12_14steps(){

        mainPage.clickPayments().clickKommunalniePlatezhi().setRegion("Санкт-Петербург");
        Assert.assertFalse(kommunalniePlatezhi.searchIskomuy(iskomuy));
    }
}
