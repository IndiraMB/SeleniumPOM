import Utilities.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends ConfigFileReader {
    ConfigFileReader configFileReader = new ConfigFileReader();
    public static WebDriver webDriver = new ChromeDriver();

    @BeforeSuite
    public void browserDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+configFileReader.getDriverPath());
    }

    @BeforeTest
    public void browserLoad(){
        webDriver.get(configFileReader.getApplicationURL());
    }

    @AfterTest
    public void driverClose(){
        webDriver.quit();
    }
}
