package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import dataProvider.ConfigFileReader;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


@RunWith(Cucumber.class)


public class OpenManageAppFrmCloud {

    private GoogleSearchPage googleSearchPage;
    private OrangeLinksPage orangeLinksPage;
    private OrangeWebsitePage orangeWebsitePage ;
    private OrangeProductsPage orangeProductsPage;
    private OrangeCloudPage orangeCloudPage ;


    String searchData = ConfigFileReader.getProperty("searchData");
    String dropDownWord = ConfigFileReader.getProperty("search");
    String managedApp = ConfigFileReader.getProperty("manageApplication");

    protected static WebDriver driver ;

    @Before
    public static void setUp() {
        String URl = ConfigFileReader.getProperty("url");
        String Chromedriver = ConfigFileReader.getProperty("chromeDriver");

        System.setProperty(Chromedriver,"resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URl);
    }

    @Given("^user search for Orange Business services$")
    public void the_user_search_for_Orange_Business(){

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchDataAndProceed(searchData);
    }

    @When("^user select first link$")
    public void he_click_on_first_link(){
        orangeLinksPage = new OrangeLinksPage(driver);
        orangeLinksPage.clickOnFirstLink();
    }

    @And("^select all products from solution with viewing all options$")
    public void he_select_all_product_from_solution(){
        orangeWebsitePage = new OrangeWebsitePage(driver);
        orangeWebsitePage.clickOnAllProductFrmSolution();
    }


    @Then("^choose cloud with clicking apply$")
    public void he_choose_cloud() {
        orangeProductsPage = new OrangeProductsPage(driver);
        orangeProductsPage.selectCloud();
        Assert.assertThat(orangeProductsPage.getCurrentUrl(), StringContains.containsString(dropDownWord));
    }

    @And("^choose manage application from cloud$")
    public void he_open_manage_application_frm_cloud(){
        orangeCloudPage = new OrangeCloudPage(driver);
        orangeCloudPage.clickOnManagedAppLink();
    }

    @Then("^validate that the system opens the right article$")
    public void system_open_on_right_article() {
        Assert.assertThat(orangeCloudPage.getCurrentUrl(), StringContains.containsString(managedApp));
    }

    @After
    public static void tearDown(){
        driver.quit();
    }

}
