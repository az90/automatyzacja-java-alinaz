package selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class GoogleResultPage {
    public static final By RESULT_LOC = By.cssSelector("#search .rc .r");
    private final WebDriver grpDriver;

    public GoogleResultPage(WebDriver driver){
    grpDriver = driver;
    }
    public boolean contains(String resultUrl){
        Stream<WebElement> results = getResultByUrl(resultUrl);

        if (results.count() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean containsResultWithTitle(String pageUrl, String pageTitle) {
        Stream<WebElement> results = getResultByUrl(pageUrl)
                .filter(r -> r.findElement(By.tagName("h3")).getText().equals(pageTitle));

        if (results.count() > 0) {
            return true;
        } else {
            return false;
        }
    }
    private Stream<WebElement> getResultByUrl(String resutlUrl) {
        return grpDriver.findElements(RESULT_LOC).stream()
                .filter(n -> n.findElement(By.tagName("a")).getAttribute("href").equals(resutlUrl));
    }
}

