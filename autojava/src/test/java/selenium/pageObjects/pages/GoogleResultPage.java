package selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class GoogleResultPage {
    private static final By RESULT_LOC = By.cssSelector("#search .rc .r");
    private final WebDriver driver;

    public GoogleResultPage(WebDriver driver){
    this.driver = driver;
    }
    public boolean contains(String resultUrl){
        Stream<WebElement> results = getResultsByUrl(resultUrl);
        return results.count() > 0;
    }
    public boolean containsResultWithTitle(String pageUrl, String pageTitle) {
        Stream<WebElement> results = getResultsByUrl(pageUrl)
                .filter(r -> r.findElement(By.tagName("h3")).getText().equals(pageTitle));

        return results.count() > 0;
    }
    private Stream<WebElement> getResultsByUrl(String resutlUrl) {
        return driver.findElements(RESULT_LOC).stream()
                .filter(n -> n.findElement(By.tagName("a")).getAttribute("href").equals(resutlUrl));
    }
}

