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

    String googleSearchData = ConfigFileReader.getProperty("googleSearchData");
    String dropDownSelectionWord = ConfigFileReader.getProperty("dropDownSelectionWord");
    String managedApp = ConfigFileReader.getProperty("manageApplication");



    @Test
    public void  testSeleniumCaseStudy()  {

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchDataAndProceed(googleSearchData);
        orangeLinksPage = new OrangeLinksPage(driver);
        orangeLinksPage.clickOnFirstLink();
        orangeWebsitePage = new OrangeWebsitePage(driver);
        orangeWebsitePage.clickOnAllProductFrmSolution();
        orangeProductsPage = new OrangeProductsPage(driver);
        orangeProductsPage.selectProductByName(dropDownSelectionWord);
        orangeProductsPage.clickOnApplyButton();
        Assert.assertThat(orangeProductsPage.getCurrentUrl(), StringContains.containsString(dropDownSelectionWord));
        orangeCloudPage = new OrangeCloudPage(driver);
        orangeCloudPage.clickOnManagedAppLink();
        Assert.assertThat(orangeCloudPage.getCurrentUrl(), StringContains.containsString(managedApp));

    }

}
