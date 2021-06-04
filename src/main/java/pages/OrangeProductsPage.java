package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class OrangeProductsPage extends BasePage {

    private By productDMenu = By.id("edit-solutions");
    private By applyButton = By.id("edit-actions");

    public OrangeProductsPage(WebDriver driver) {
        super(driver);
    }


    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }


    public GoogleSearchPage selectCloud ()  {
        Select selector = new Select(driver.findElement (By.tagName("select")));
        selector.selectByVisibleText("Cloud");
        findElement(applyButton).click();
        return new GoogleSearchPage(driver);
    }
}
