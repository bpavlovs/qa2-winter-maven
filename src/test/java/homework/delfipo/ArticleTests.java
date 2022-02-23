package homework.delfipo;

import homework.delfipo.model.Article;
import homework.delfipo.pages.ArticlePage;
import homework.delfipo.pages.BaseFunctions;
import homework.delfipo.pages.CommentsPage;
import homework.delfipo.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleTests {

    private final String HOME_PAGE_URL = "delfi.lv";
    private final int ARTICLE_NUMBER = 9; //12

    @Test
    public void titleAndCommentCountCheck() {
        BaseFunctions baseFunctions = new BaseFunctions();
        baseFunctions.openUrl(HOME_PAGE_URL);

        HomePage homePage = new HomePage(baseFunctions);
        homePage.acceptCookies();

        Article article = homePage.getArticleById(ARTICLE_NUMBER);

        homePage.openArticlePage(ARTICLE_NUMBER);

        ArticlePage articlePage = new ArticlePage(baseFunctions);

        System.out.println(article.getCommentCount());
        System.out.println(article.getTitle());

        System.out.println(articlePage.getCommentCount());
        System.out.println(articlePage.getArticleTitle());

        Assertions.assertEquals(article.getCommentCount(), articlePage.getCommentCount(), "Comment counts do not match!");
        Assertions.assertEquals(article.getTitle(), articlePage.getArticleTitle(), "Titles do not match!");

        articlePage.openCommentsPage();

        CommentsPage commentsPage = new CommentsPage(baseFunctions);

        Assertions.assertEquals(article.getTitle(), commentsPage.getArticleTitle(), "Titles do not match!");
        Assertions.assertEquals(article.getCommentCount(), commentsPage.getCommentCount(), "Comment counts do not match!");

        System.out.println(commentsPage.getCommentCount());
        System.out.println(commentsPage.getArticleTitle());
    }
}