package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrangeLinksPage extends BasePage {

    private By orangeLink = By.partialLinkText("Orange Business Services: Your partner for digital");


    public OrangeLinksPage(WebDriver driver) {
        super(driver);
    }

    public OrangeWebsitePage clickOnFirstLink ()  {
        findElement(orangeLink).click();
        return new OrangeWebsitePage(driver);
    }
}
