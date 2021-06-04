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

    public GoogleSearchPage clickOnAllProductFrmSolution ()  {
        findElement(solutionsLink).click();
        moveToElement(solutionsMenu);
        int x =findElements(solutionsMenu).size();
        //list appear empty
        for (int i = 0 ; i<x ; i++)System.out.println(findElement(solutionsMenu).getText());
        findElement(allProducts).click();
        return new GoogleSearchPage(driver);
    }
}
