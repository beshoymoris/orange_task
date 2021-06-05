package pages;



import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class OrangeProductsPage extends BasePage {

    private By productDMenu = By.id("edit-solutions");
    private By applyButton = By.id("edit-actions");



    public OrangeProductsPage(WebDriver driver) {
        super(driver);
    }

    private CssMetaData<Styleable, Object> ConfigFileReader;
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }


    public OrangeProductsPage selectProductByName (String name)  {
        Select selector = new Select(driver.findElement (By.tagName("select")));

        selector.selectByVisibleText(name);
        return this;
    }

    public OrangeCloudPage clickOnApplyButton (){
        findElement(applyButton).click();
        return new OrangeCloudPage(driver);
    }

    public List<String> getProductsNames() {
        Select productsList = new Select(driver.findElement (By.tagName("select")));
        return productsList.getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
