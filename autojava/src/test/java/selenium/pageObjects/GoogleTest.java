package selenium.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageObjects.pages.GoogleMainPage;
import selenium.pageObjects.pages.GoogleResultPage;

public class GoogleTest extends BaseTest {

    @Test
    public void canFindScrumOrgOnGoogle(){
        String pageUrl = "https://www.scrum.org/";
        String pageTitle = "Scrum.org: Homepage";
    //open google main page
    GoogleMainPage googlePage = new GoogleMainPage(driver);

    // Search For Scrum.org
    GoogleResultPage resultPage = googlePage.search("Scrum.org");

    // Assert Scrum.org page is found
        Assertions.assertTrue(resultPage.contains(pageUrl));
        Assertions.assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle),
                "Scrum.org page has correct title");
    }

}
