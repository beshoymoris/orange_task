package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrangeWebsitePage extends BasePage {

    private By solutionsLink = By.linkText("Solutions");
    private By solutionsMenu = By.id("items_megamenu");
    private By allProducts = By.linkText("All products");


    public OrangeWebsitePage(WebDriver driver) {
        super(driver);
    }


    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public OrangeProductsPage clickOnAllProductFrmSolution ()  {
        findElement(solutionsLink).click();
        moveToElement(solutionsMenu);
        findElement(allProducts).click();
        return new OrangeProductsPage(driver);
    }
}
