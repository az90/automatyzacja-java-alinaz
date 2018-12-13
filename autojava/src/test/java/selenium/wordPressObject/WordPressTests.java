package selenium.wordPressObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.wordPressObject.pages.WordPressMainPage;
import selenium.wordPressObject.pages.WordPressNotePage;

import java.util.UUID;

public class WordPressTests extends BasicTest{

    @Test
    public void addNewCommentAndCheck(){
        String comment = generateRandomText();
        String author = generateRandomText();
        String email = generateRandomEmail();

        //open WordPress
        WordPressMainPage wordPressMainPage = new WordPressMainPage(driver);
        //open first article
        WordPressNotePage firstNote = wordPressMainPage.openFirstArticle();
        //add comment
        WordPressNotePage firstNoteWithComment = firstNote.addComment(comment, author, email);
        //check is comment exist
        Assertions.assertTrue(firstNoteWithComment.commentExist(comment,author));
    }

    private String generateRandomEmail() {
        return generateRandomText() + "@testtesttest.com";
    }

    private String generateRandomText() {
        return UUID.randomUUID().toString();
    }
}
