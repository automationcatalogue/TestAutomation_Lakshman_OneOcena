package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Utils;
import utilities.YAMLUtils;

import java.time.Duration;

public class AmazonHomePage {

    private static Logger log= LogManager.getLogger(AmazonHomePage.class.getName());
    WebDriver driver;
    public AmazonHomePage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement element_SearchTxtBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement element_SearchBtn;

    public void navigateToAmazon() throws Exception{
        String appURL= YAMLUtils.getData_Yaml("applicationURL");
        driver.get(appURL);
        log.info("Navigated to Amazon website "+appURL);
    }

    public void searchItem(String item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        element_SearchTxtBox.sendKeys(item);
        log.info(item+ " is entered as search item in Amazon website");
        element_SearchBtn.click();
        log.info("Search button is clicked");
    }

}
