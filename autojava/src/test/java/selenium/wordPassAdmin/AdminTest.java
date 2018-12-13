package selenium.wordPassAdmin;

import org.junit.jupiter.api.Test;
import selenium.wordPassAdmin.page.WordPressLoginPage;
import selenium.wordPassAdmin.page.WordPressMainPageAdmin;
import selenium.wordPassAdmin.page.WordPressNotePageAdmin;

import java.util.UUID;

public class AdminTest extends BasicTest {

    @Test
    public void addNoteAsAdmin(){
        String login = "automatyzacja";
        String passworld = "jesien2018";
        String title = generiteText();
        String text = generiteText();

        //open page
        WordPressLoginPage loginPage = new WordPressLoginPage(driver);
        //login
        WordPressMainPageAdmin mainPage = loginPage.login(login, passworld);

        //open newArticle
        WordPressNotePageAdmin firstNote = mainPage.openNewNote();
        //add new Article
        WordPressNotePageAdmin newArticle = firstNote.addNewNote(title,text);
        //wyloguj
        WordPressNotePageAdmin logOutPage = newArticle.logOut();

        //check if comment was add
    }

    private String generiteText() {
        return UUID.randomUUID().toString();
    }
}
