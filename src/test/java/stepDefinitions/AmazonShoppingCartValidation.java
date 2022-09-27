package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonHomePage;
import pages.AmazonProductListPage;

public class AmazonShoppingCartValidation {
    private static Logger log= LogManager.getLogger(AmazonShoppingCartValidation.class.getName());
    AmazonHomePage homePage = PageFactory.initElements(AmazonHooks.driver, AmazonHomePage.class);
    AmazonProductListPage productListPage = PageFactory.initElements(AmazonHooks.driver, AmazonProductListPage.class);

    @Given("^User navigates to Amazon website$")
    public void navigateToAmazonWebsite()throws Exception{
        log.info("User navigates to Amazon website");
        homePage.navigateToAmazon();
    }

    @When("^User Searches for \"(.*)\"$")
    public void searchItems(String itemName)throws Exception{
        log.info("User Searches for "+itemName);
        homePage.searchItem(itemName);
    }

    @And("^User Sort results according to the Customer Review$")
    public void sortResults()throws Exception{
        log.info("User Sort results according to the Customer Review");
        productListPage.sortCustomerReview();
    }

    @And("^User Selects the Age range between \"(.*)\" old$")
    public void selectFilter(String ageGroup)throws Exception{
        log.info("User Selects the Age range between "+ageGroup+" old");
        productListPage.sortByAge(ageGroup);
    }

    @Then("^User adds first \"(.*)\" items in his cart$")
    public void addFirstTwoItems(int itemCount)throws Exception{
        log.info("User adds first two items in his cart");
        productListPage.addItems(itemCount);
    }

    @And("^Validate the Shopping Cart with two added items$")
    public void validateShoppingCart()throws Exception{
        log.info("Validate the Shopping Cart with two added items");
    }



}
