import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginTest extends BaseTest{
    LoginPage loginPage;

    public static Logger logger = Logger.getLogger(String.valueOf(LoginTest.class));

    @Test
    public void checkLogin(){
        loginPage = new LoginPage(webDriver);
        loginPage.login();
    }

}
