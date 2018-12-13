package selenium.wordPressObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressMainPage {
    public static final String WORDPRESS_URL = "http://automatyzacja.benedykt.net/";
    public static final By FIRST_ARTICLE_LOC = By.cssSelector(".entry-title > a");
    private final WebDriver driver;

    public WordPressMainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(WORDPRESS_URL);
    }

    public WordPressNotePage openFirstArticle(){
        WebElement firstArticle = driver.findElement(FIRST_ARTICLE_LOC);
        firstArticle.click();
        return new WordPressNotePage(driver);
    }

}
