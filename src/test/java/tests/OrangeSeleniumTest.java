package tests;

import dataProvider.ConfigFileReader;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import pages.*;


public class OrangeSeleniumTest extends BaseTest{

   private GoogleSearchPage googleSearchPage;
   private OrangeLinksPage orangeLinksPage;
   private OrangeWebsitePage orangeWebsitePage;
   private OrangeProductsPage orangeProductsPage;
   private OrangeCloudPage orangeCloudPage ;

    String searchData = ConfigFileReader.getProperty("searchData");
    String dropDownWord = ConfigFileReader.getProperty("search");
    String managedApp = ConfigFileReader.getProperty("manageApplication");


    @Test
    public void  testSeleniumCaseStudy()  {

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchDataAndProceed(searchData);
        orangeLinksPage = new OrangeLinksPage(driver);
        orangeLinksPage.clickOnFirstLink();
        orangeWebsitePage = new OrangeWebsitePage(driver);
        orangeWebsitePage.clickOnAllProductFrmSolution();
        orangeProductsPage = new OrangeProductsPage(driver);
        orangeProductsPage.selectCloud();
        Assert.assertThat(orangeProductsPage.getCurrentUrl(), StringContains.containsString(dropDownWord));
        orangeCloudPage = new OrangeCloudPage(driver);
        orangeCloudPage.clickOnManagedAppLink();
        Assert.assertThat(orangeCloudPage.getCurrentUrl(), StringContains.containsString(managedApp));

    }

}
