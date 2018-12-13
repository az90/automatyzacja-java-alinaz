package selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    private final WebDriver driver;
    private static final String GOOGLE_URL = "http://google.com/";
    private static final By SEARCH_BOX_LOC = By.name("q");

    //konstruktor klasy
    public GoogleMainPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(GOOGLE_URL);
    }

    public GoogleResultPage search(String searchQuery){
        WebElement boxSearch = driver.findElement(SEARCH_BOX_LOC);
        boxSearch.sendKeys(searchQuery);
        boxSearch.submit();

        return new GoogleResultPage(driver);
    }

}
