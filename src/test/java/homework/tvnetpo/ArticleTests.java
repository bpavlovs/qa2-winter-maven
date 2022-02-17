package homework.tvnetpo;

import homework.tvnetpo.model.Article;
import homework.tvnetpo.pages.ArticlePage;
import homework.tvnetpo.pages.BaseFunctions;
import homework.tvnetpo.pages.CommentsPage;
import homework.tvnetpo.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleTests {

    private final String HOME_PAGE_URL = "tvnet.lv";
    private final int ARTICLE_NUMBER = 25;

    @Test
    public void titleAndCommentCountCheck() {

        BaseFunctions baseFunctions = new BaseFunctions();

        baseFunctions.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunctions);

        homePage.acceptCookies();

        Article article = homePage.getArticleById(ARTICLE_NUMBER);

        homePage.openArticlePage(ARTICLE_NUMBER);

        ArticlePage articlePage = new ArticlePage(baseFunctions);

        Assertions.assertEquals(article.getCommentCount(), articlePage.getCommentCount(), "Comment count on home page and article page isn't the same!");
        Assertions.assertEquals(article.getTitle(), articlePage.getTitle(), "Titles on home page and article page aren't the same!");

        articlePage.openCommentsPage();

        CommentsPage commentsPage = new CommentsPage(baseFunctions);

        Assertions.assertEquals(article.getCommentCount(), commentsPage.getCommentCount(), "Comment count on home page and comments page isn't the same!");
        Assertions.assertEquals(article.getTitle(), commentsPage.getTitle(), "Titles on home page and comments page aren't the same!");

    }
}
