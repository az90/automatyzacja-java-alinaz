package selenium.wordPassAdmin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressNotePageAdmin {
    private final WebDriver driver;

    public WordPressNotePageAdmin(WebDriver driver){
        this.driver = driver;
    }

    public WordPressNotePageAdmin addNewNote(String title, String text) {
        WebElement titleBox = driver.findElement(By.id("title"));
        titleBox.sendKeys(title);
        WebElement textBox = driver.findElement(By.className("wp-editor-area"));
        textBox.sendKeys(text);
        WebDriverWait waitPublish = new WebDriverWait(driver, 30);
        waitPublish.until(ExpectedConditions.elementToBeClickable(By.id("publish")));
        WebElement publish = driver.findElement(By.id("publish"));
        publish.sendKeys(Keys.ENTER);
        //publish.click();



        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));

        return new WordPressNotePageAdmin(driver);
    }

    public WordPressNotePageAdmin logOut() {
        WebElement logOut = driver.findElement(By.id("wp-admin-bar-top-secondary"));
        logOut.click();
        WebElement logOut2 = driver.findElement(By.cssSelector("#wp-admin-bar-logout > a"));
        logOut2.click();
        return new WordPressNotePageAdmin(driver);
    }
}
