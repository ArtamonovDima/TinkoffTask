import PageObjects.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    BasePage basePage;
    MainPage mainPage;
    PaymentsPage paymentsPage;
    KommunalniePlatezhi kommunalniePlatezhi;
    ZhkuMoskva zhkuMoskva;
    ZhkuMoskvaOplata zhkuMoskvaOplata;

    @BeforeClass
    public void init(){
        basePage = new BasePage();
        mainPage = new MainPage();
        paymentsPage = new PaymentsPage();
        kommunalniePlatezhi = new KommunalniePlatezhi();
        zhkuMoskva = new ZhkuMoskva();
        zhkuMoskvaOplata = new ZhkuMoskvaOplata();
    }

    @AfterClass
    public void close(){
        basePage.close();
    }
}
