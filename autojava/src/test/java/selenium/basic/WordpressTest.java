package selenium.basic;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordpressTest {
    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void verifyIfCommentWasAdd() {
        driver.get("http://automatyzacja.benedykt.net/");
        WebElement firstArticle = driver.findElement(By.cssSelector(".entry-title > a"));
        firstArticle.click();

        driver.findElement(By.id("reply-title"));
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString();
        String comment = uuid.toString();
        driver.findElement(By.id("comment")).sendKeys(comment);
        driver.findElement(By.id("author")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys("aa@aa.pl");
        driver.findElement(By.name("submit")).click();
        Stream<WebElement> listOfAuthorOfComments = driver.findElements(By.className("comment-meta"))
                .stream()
                .filter(n -> n.findElement(By.tagName("b")).getText().equals(name));

        List<WebElement> filterdAuthor = listOfAuthorOfComments.collect(Collectors.toList());

        Assertions.assertEquals(1,filterdAuthor.size(), "Only one matching author");

        Stream<WebElement> listOfComments = driver.findElements(By.className("comment-content"))
                .stream()
                .filter(n -> n.findElement(By.tagName("p")).getText().equals(comment));
        List<WebElement> filterComment = listOfComments.collect(Collectors.toList());
        Assertions.assertEquals(1,filterComment.size(),"Only one matching comment");
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

}
