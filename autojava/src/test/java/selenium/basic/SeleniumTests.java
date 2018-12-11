package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumTests {

    private WebDriver driver;
    @BeforeEach
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void canFindCodeSprintersOnGoogle() {


        driver.get("https://www.google.pl/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("code sprinters");
        searchBox.submit(); //wciśniecie Enter

        Stream<WebElement> searchResult = driver.findElements(By.cssSelector("div.rc")).stream();
        Stream<WebElement> resultFiltered = searchResult
                .filter(r -> r.findElement(By.cssSelector("div.r > a"))
                        .getAttribute("href").equals("http://agileszkolenia.pl/"));
        List<WebElement> resultList = resultFiltered.collect(Collectors.toList());
        Assertions.assertEquals(1, resultList.size());

        WebElement result = resultList.get(0);
        Assertions.assertEquals("agileszkolenia.pl/",result.findElement(By.tagName("cite")).getText());

        driver.quit();

    }

    @AfterEach
    public void closeDriver(){
        driver.quit();
    }
}
