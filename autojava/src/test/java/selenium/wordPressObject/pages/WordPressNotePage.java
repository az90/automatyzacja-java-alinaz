package selenium.wordPressObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordPressNotePage {
    private final WebDriver driver;

    //konstruktor
    public WordPressNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public WordPressNotePage addComment(String comment, String author, String email) {
        driver.findElement(By.id("comment")).sendKeys(comment);
        driver.findElement(By.id("author")).sendKeys(author);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("submit")).click();
        return new WordPressNotePage(driver);
    }

    public boolean commentExist(String comment, String author) {
        Stream<WebElement> listOfAuthorOfComments = driver.findElements(By.className("comment-meta"))
                .stream()
                .filter(n -> n.findElement(By.tagName("b")).getText().equals(author));

        List<WebElement> filterdAuthor = listOfAuthorOfComments.collect(Collectors.toList());

        return  filterdAuthor.size() == 1;
    }
}
