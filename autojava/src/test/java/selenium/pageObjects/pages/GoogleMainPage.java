package selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    public static final String GOOGLE_URL = "http://google.com/";
    public static final By SEARCH_BOX_LOC = By.name("q");

    private final WebDriver gmpDriver;

    public GoogleMainPage(WebDriver driver){
        gmpDriver = driver;
        gmpDriver.get(GOOGLE_URL);
    }

    public GoogleResultPage search(String searchQuery){
        WebElement boxSearch = gmpDriver.findElement(SEARCH_BOX_LOC);
        boxSearch.sendKeys(searchQuery);
        boxSearch.submit();

        return new GoogleResultPage(gmpDriver);
    }

}
