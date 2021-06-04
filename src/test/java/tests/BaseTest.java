package tests;

import dataProvider.ConfigFileReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;


import java.io.IOException;

public class BaseTest  {

    protected static WebDriver driver ;
    protected static GoogleSearchPage googleSearchPage;

    @BeforeClass
    public static void setUp() throws IOException {
        String URl = ConfigFileReader.getProperty("url");
        String Chromedriver = ConfigFileReader.getProperty("chromeDriver");

        System.setProperty(Chromedriver,"resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URl);
        googleSearchPage = new GoogleSearchPage(driver);
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
