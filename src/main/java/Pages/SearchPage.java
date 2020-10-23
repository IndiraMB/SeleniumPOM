package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SearchPage {

    WebDriver webDriver;

    By searchBox = By.id("q");
    By searchButton = By.id("searchbtn");
    By product1 = By.xpath("//div[@id=product1]");
    By product2 = By.xpath("//div[@id=product2]");
    By product3 = By.xpath("//div[@id=product3]");
    By plus = By.xpath("//div[1]/span[@class=jcf-btn-inc]");
    By minus = By.xpath("//div[1]/span[@class=jcf-btn-dec]");
    By checkout = By.id("checkoutBtn");

    public static Logger logger = Logger.getLogger(String.valueOf(SearchPage.class));

    public SearchPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void enterSearchString(String query){
        webDriver.findElement(searchBox).sendKeys(query);
    }
    public void clickSearch(){
        webDriver.findElement(searchButton).click();
    }
    public void clickPlus(){
        webDriver.findElement(plus).click();
    }
    public void clickCheckout(){
        webDriver.findElement(checkout).click();
    }

    public void addToCart(String searchQuery){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver,100);
            wait.until(ExpectedConditions.visibilityOfElementLocated((searchBox)));
            logger.info("Navigated to Search Page");
            enterSearchString(searchQuery);
            clickSearch();
            clickPlus();
            clickCheckout();
            logger.info("Item added to cart and clicked on checkout");
        }catch (Exception exception){
            logger.info("Exception in Search Page");
            exception.printStackTrace();
        }
    }
}

