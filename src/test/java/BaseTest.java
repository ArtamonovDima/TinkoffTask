import PageObjects.BasePage;
import PageObjects.KommunalniePlatezhi;
import PageObjects.MainPage;
import PageObjects.PaymentsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    BasePage basePage;
    MainPage mainPage;
    PaymentsPage paymentsPage;
    KommunalniePlatezhi kommunalniePlatezhi;

    @BeforeClass
    public void init(){
        basePage = new BasePage();
        mainPage = new MainPage();
        paymentsPage = new PaymentsPage();
        kommunalniePlatezhi = new KommunalniePlatezhi();
    }

    @AfterClass
    public void close(){
        basePage.close();
    }
}
