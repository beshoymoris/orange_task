package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrangeCloudPage extends BasePage {

    private By manageAppLink = By.partialLinkText("Managed Applications: improve operational capability in the cloud");



    public OrangeCloudPage(WebDriver driver) {
        super(driver);
    }


    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public OrangeCloudPage clickOnManagedAppLink ()  {
        findElement(manageAppLink).click();

        return this;
    }
}
