package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.Utils;
import utilities.YAMLUtils;

public class AmazonHooks {
    public static WebDriver driver;
    private static Logger log= LogManager.getLogger(AmazonHooks.class.getName());
    @Before
    public void setup() throws Exception{
        log.info("******** Execution Start ******************");
        String browserName= YAMLUtils.getData_Yaml("browser");
        System.out.println("browserName is:"+browserName);
        driver= Utils.initializeDriver(browserName);
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
        log.info("******** Execution End ******************");
    }
}
