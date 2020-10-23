package Pages;

import Utilities.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class PaymentPage {
    WebDriver webDriver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    By name = By.id("name");
    By mobile = By.id("mobile");
    By address = By.id("address");
    By btnsubmit = By.className("btn_submit");
    By btnPay = By.id("pay");
    By OTP = By.id("otp");
    By confirmation = By.id("PaymentConfirmation");

    public static Logger logger = Logger.getLogger(String.valueOf(PaymentPage.class));

    public PaymentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setName(){
        webDriver.findElement(name).sendKeys(configFileReader.getName());
    }
    public void setMobile(){
        webDriver.findElement(mobile).sendKeys(configFileReader.getMobile());
    }
    public void setAddress(){
        webDriver.findElement(address).sendKeys(configFileReader.getAddress());
    }

    public void clickSubmit(){
        webDriver.findElement(btnsubmit).click();
    }

    public void placeOrder(){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver,100);
            logger.info("Payment page");
            setName();
            setMobile();
            setAddress();
            clickSubmit();
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation));
            logger.info("Payment is successful");
        }catch (Exception exception){
            logger.info("Exception throw in Payment Page");
            exception.printStackTrace();
        }
    }

}
