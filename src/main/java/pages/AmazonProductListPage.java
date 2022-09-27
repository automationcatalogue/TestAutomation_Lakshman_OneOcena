package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonProductListPage {
    private static Logger log= LogManager.getLogger(AmazonProductListPage.class.getName());
    WebDriver driver;
    public AmazonProductListPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    WebElement element_Sortdropdown;

    @FindBy(xpath = "//ul[@class='a-nostyle a-list-link']/li/a[contains(text(),'Customer Review')]")
    WebElement element_CustomerReview;

    @FindBy(xpath = "//ul[@aria-labelledby='p_n_age_range-title']//span[text()='5 to 7 Years']")
    WebElement element_Sortby5to7Age;

    @FindBy(xpath = "(//span[@data-component-type='s-search-results']//div[starts-with(@cel_widget_id,'MAIN-SEARCH_RESULTS')])//img")
    List<WebElement> elements_ListItems;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement element_AddToCart;



    public void sortCustomerReview(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element_Sortdropdown));
        element_Sortdropdown.click();
        log.info("Sort By: Featured drop-down is clicked");
        element_CustomerReview.click();
        log.info("Avg.Customer Review link is clicked");
    }

    public void sortByAge(String ageGroup){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element_Sortby5to7Age);
        log.info("Scrolled Down till the 5 to 7 years sorting option visible");
        js.executeScript("arguments[0].click()",element_Sortby5to7Age);
        log.info("5 to 7 Years Age check-box is clicked");
    }

    public void addItems(int numberOfItem){
        int itemCount=0;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for(WebElement element_Item: elements_ListItems){
            driver.navigate().refresh();
            element_Item.click();
            itemCount++;
            element_AddToCart.click();
            log.info(itemCount+ " is added to the Shopping Cart");
            driver.navigate().back();
            log.info("Navigated back to the Product Catalogue Page");
            driver.navigate().back();
            log.info("Navigated back to the Product List Page");
            if(itemCount==numberOfItem){
                break;
            }
        }
    }
}
