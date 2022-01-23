package pageobject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.model.Article;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By ARTICLE = By.tagName("article");
    private BaseFunctions baseFunctions;


    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void acceptCookies() {
        baseFunctions.click(ACCEPT_COOKIES_BTN);
    }

    public Article getArticleById(int articleNumber) {
        List<WebElement> articleElements = baseFunctions.findElements(ARTICLE);
        Assertions.assertFalse(articleElements.isEmpty(), "There are no articles!");

        WebElement currentArticle = articleElements.get(articleNumber-1);
        return mapArticle(currentArticle);

    }

    private Article mapArticle(WebElement webElement) {
        Article article = new Article();

        List<WebElement> commentCounters = baseFunctions.findElements(webElement, COMMENT_COUNT);
        Assertions.assertTrue(commentCounters.size() <= 1, "There is more than one counter!");

        if (commentCounters.isEmpty()) {
            article.setCommentCount(0);
        } else {
            article.setCommentCount(commentCounters.get(0));
        }

        return article;
    }
}
