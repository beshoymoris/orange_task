package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleSearchPage extends BasePage{

    private By orangeLink = By.name("q");


    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }


    public void enterSearchDataAndProceed (String keyword) {
        WebElement searchField = findElement(orangeLink);
        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.ENTER);
    }


}
