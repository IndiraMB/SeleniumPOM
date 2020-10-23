import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PaymentTest extends BaseTest{
    LoginPage loginPage;
    SearchPage searchPage;
    PaymentPage paymentPage;
    public static Logger logger = Logger.getLogger(String.valueOf(PaymentTest.class));

    @Test
    public void checkPayment(){
        loginPage = new LoginPage(webDriver);
        searchPage = new SearchPage(webDriver);
        paymentPage = new PaymentPage(webDriver);
        loginPage.login();
        searchPage.addToCart("mobile");
        paymentPage.placeOrder();
    }

}
