package selenium.wordPassAdmin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressMainPageAdmin {
    private final WebDriver driver;
    public static final By FIRST_ARTICLE_LOC = By.cssSelector(".entry-title > a");

    public WordPressMainPageAdmin(WebDriver driver){
        this.driver = driver;

    }

    public WordPressNotePageAdmin openNewNote() {
        WebElement wpisy = driver.findElement(By.id("menu-posts"));
        wpisy.click();
        WebElement newWpis = driver.findElement(By.className("page-title-action"));
        newWpis.click();
        return new WordPressNotePageAdmin(driver);
    }

}
