package homework.delfipo.pages;

import homework.delfipo.model.Article;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BUTTON = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE = By.xpath(".//article[contains(@class, headline)]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains (@class, 'headline__title')]");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains (@class, 'comment')]");

    private BaseFunctions baseFunctions;

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void acceptCookies() {
        baseFunctions.click(ACCEPT_COOKIES_BUTTON);
    }

    public WebElement getArticle(int articleId) {
        List<WebElement> allArticles = baseFunctions.findElements(ARTICLE);
        Assertions.assertFalse(allArticles.isEmpty(), "There are no articles!");
        return allArticles.get(articleId - 1);
    }

    public Article getArticleById(int articleId) {
        return mapArticle(getArticle(articleId));
    }

    public void openArticlePage(int articleId) {
        getArticle(articleId).click();
    }

    public Article mapArticle(WebElement webElement) {

        Article article = new Article();

        List<WebElement> commentCounters = baseFunctions.findElements(webElement, COMMENT_COUNTER);
        Assertions.assertTrue(commentCounters.size() <= 1, "There is more than one comment counter!");

        if (commentCounters.isEmpty()) {
            article.setCommentCount(0);
        } else {
            article.setCommentCount(commentCounters.get(0));
        }
        article.setTitle(baseFunctions.findElement(webElement, ARTICLE_TITLE));

        return article;
    }
}
