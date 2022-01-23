package homework.tvnetpo.pages;

import homework.tvnetpo.model.Article;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE = By.xpath(".//article[@class = 'list-article']");
    private final By COMMENT_COUNTER = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By ARTICLE_TITLE = By.xpath(".//span[@class = 'list-article__headline']");

    private BaseFunctions baseFunctions;

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void acceptCookies() {
        baseFunctions.click(ACCEPT_COOKIES_BTN);
    }

    public Article getArticleById(int articleNumber) {
        return mapArticle(locateArticle(articleNumber));
    }

    public void openArticlePage(int articleNumber) {
        locateArticle(articleNumber).click();

    }

    public WebElement locateArticle(int articleNumber) {
        List<WebElement> articleElements = baseFunctions.findElements(ARTICLE);
        Assertions.assertFalse(articleElements.isEmpty(), "There are no articles!");
        return articleElements.get(articleNumber - 1);
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

        WebElement articleTitle = baseFunctions.findElement(webElement, ARTICLE_TITLE);

        if (article.getCommentCount() != 0) {
            String[] splitTitle = articleTitle.getText().split(" ");
            splitTitle = Arrays.copyOf(splitTitle, splitTitle.length - 1);
            article.setTitle(String.join(" ", splitTitle));
        } else {
            article.setTitle(articleTitle.getText());
        }

        return article;
    }


}
