package Pages;

import Utilities.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;


public class LoginPage {
    WebDriver webDriver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    public Logger logger = Logger.getLogger(String.valueOf(LoginPage.class));

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    By userName = By.id("username");
    By password = By.id("password");
    By clickbtn = By.name("btnClick");
    By searchBox = By.name("q");

    public void setUserName(){
        webDriver.findElement(userName).sendKeys(configFileReader.getUserName());
    }
    public void setPassword(){
        webDriver.findElement(password).sendKeys(configFileReader.getPassword());
    }
    public void clickButton(){
        webDriver.findElement(clickbtn).click();
    }

    public void login(){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver,100);
            wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
            logger.info("Homepage");
            setUserName();
            setPassword();
            clickButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
            logger.info("Login successful");

        } catch (Exception e){
            e.printStackTrace();
            logger.info("Exception in homepage");
        }
    }

}
