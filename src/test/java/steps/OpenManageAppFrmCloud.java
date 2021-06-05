package steps;

import cucumber.api.Scenario;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Arrays;
import java.util.List;


@RunWith(Cucumber.class)


public class OpenManageAppFrmCloud {

    private GoogleSearchPage googleSearchPage;
    private OrangeLinksPage orangeLinksPage;
    private OrangeWebsitePage orangeWebsitePage ;
    private OrangeProductsPage orangeProductsPage;
    private OrangeCloudPage orangeCloudPage ;


    String googleSearchData = ConfigFileReader.getProperty("googleSearchData");
    String dropDownSelectionWord = ConfigFileReader.getProperty("dropDownSelectionWord");
    String managedApp = ConfigFileReader.getProperty("manageApplication");

    List<String> expectedProductNameList= Arrays.asList("Solution","Business innovation","Cloud",
            "Collaborative workspace","Customer experience","Cyberdefense","Data intelligence",
            "Internet of Things","Mobile connectivity","Network transformation","Services");

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

    @Given("^google website opened successfully$")
    public void user_search_for_Orange_Business(){

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchDataAndProceed(googleSearchData);
    }

    @When("^user select first orange link$")
    public void click_on_first_link(){
        orangeLinksPage = new OrangeLinksPage(driver);
        orangeLinksPage.clickOnFirstLink();
    }

    @And("^select all products from solution$")
    public void select_all_product_from_solution(){
        orangeWebsitePage = new OrangeWebsitePage(driver);
        orangeWebsitePage.clickOnAllProductFrmSolution();
    }

    @Then("^get all product list values$")
    public void get_all_product_values(){
        orangeProductsPage = new OrangeProductsPage(driver);
        List<String> actualProductNameList = orangeProductsPage.getProductsNames();
        Assert.assertEquals(expectedProductNameList.size(), actualProductNameList.size());
        Assert.assertTrue(actualProductNameList.containsAll(expectedProductNameList));
    }

    @When("^choose cloud with clicking apply$")
    public void choose_cloud_option_and_click_apply() {
        orangeProductsPage = new OrangeProductsPage(driver);
        orangeProductsPage.selectProductByName(dropDownSelectionWord);
        orangeProductsPage.clickOnApplyButton();
    }

    @And("^choose manage application from cloud option$")
    public void open_manage_application_frm_cloud(){
        orangeCloudPage = new OrangeCloudPage(driver);
        orangeCloudPage.clickOnManagedAppLink();
    }

    @Then("^validate that the system opens the right article$")
    public void system_open_on_right_article() {
        Assert.assertThat(orangeCloudPage.getCurrentUrl(), StringContains.containsString(managedApp));
    }

    @After
    public static void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }
        driver.quit();
    }

}
