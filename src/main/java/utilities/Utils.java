package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    static WebDriver driver;
    public static WebDriver initializeDriver(String browser) {
        driver=null;
        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }else if(browser.equalsIgnoreCase("InternetExplorer") || browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("Opera") ) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        driver.manage().window().maximize();
        //Log.info("Browser window maximized");
        System.out.println("Browser window maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }



}
