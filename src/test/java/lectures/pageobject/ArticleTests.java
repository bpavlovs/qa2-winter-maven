package lectures.pageobject;

import lectures.pageobject.model.Article;
import lectures.pageobject.pages.BaseFunctions;
import lectures.pageobject.pages.HomePage;
import org.junit.jupiter.api.Test;

public class ArticleTests {

    private final String HOME_PAGE_URL = "http://tvnet.lv";

    @Test
    public void titleAndCommentCountCheck() {

        //Open browser window and maximize it
        BaseFunctions baseFunctions = new BaseFunctions();

        //Open home page
        baseFunctions.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunctions);

        //Accept cookies
        homePage.acceptCookies();

        //Get 3rd article title & comment count via Article
        Article article = homePage.getArticleById(1);
        System.out.println(article.getCommentCount());

        //Open 3rd article

        //Get title

        //Get comment count

        //Compare titles

        //Compare comment counts

        //...

    }

}
