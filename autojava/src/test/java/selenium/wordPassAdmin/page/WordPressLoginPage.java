package selenium.wordPassAdmin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.wordPressObject.pages.WordPressMainPage;

public class WordPressLoginPage {
    public static final String URL_ADMIN_PAGE = "https://automatyzacja.benedykt.net/wp-admin";
    private final WebDriver driver;

    public WordPressLoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL_ADMIN_PAGE);

    }

    public WordPressMainPageAdmin login(String login, String passworld) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login")));
        WebElement logBox = driver.findElement(By.id("user_login"));
        logBox.sendKeys(login);
        WebElement passBox = driver.findElement(By.id("user_pass"));
        passBox.sendKeys(passworld);
        driver.findElement(By.id("wp-submit")).click();
        return new WordPressMainPageAdmin(driver);
    }
}
