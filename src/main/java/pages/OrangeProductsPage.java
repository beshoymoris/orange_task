package pages;



import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;


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


    public OrangeCloudPage selectCloud ()  {
        Select selector = new Select(driver.findElement (By.tagName("select")));
        List<WebElement> op = selector.getOptions();

        String [] dropDownList= {"Solution","Business innovation","Cloud","Collaborative workspace"
                ,"Customer experience","Cyberdefense","Data intelligence","Internet of Things"
                ,"Mobile connectivity","Network transformation","Services"};
        int size  = op.size();
        for (int i = 0 ; i<size ; i++) {
            String options = op.get(i).getText();
            System.out.println(options);
            Assert.assertEquals(op.get(i).getText(),dropDownList[i]);

        }


        selector.selectByVisibleText("Cloud");
        findElement(applyButton).click();
        return new OrangeCloudPage(driver);
    }
}
