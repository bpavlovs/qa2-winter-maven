package homework.delfipo.pages;

import org.openqa.selenium.By;

public class ArticlePage {

    private BaseFunctions baseFunctions;
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, '30 d-inline')]");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains(@class, 'd-print')]");
    private final By COMMENT_PAGE_BUTTON = By.xpath(".//a[contains(@class, 'btn btn-primary')]");
    private final By AD_CLOSE_BUTTON = By.id("closeButton");

    public ArticlePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void openCommentsPage() {
        baseFunctions.click(COMMENT_PAGE_BUTTON);
    }

    public String getArticleTitle() {
        String articleTitle = baseFunctions.findElement(ARTICLE_TITLE).getText();
        return articleTitle.substring(0, articleTitle.length() - 1);
    }

    public int getCommentCount() {
        String commentCounter;

        if (baseFunctions.findElements(COMMENT_COUNTER).size() != 0) {
            commentCounter = baseFunctions.findElement(COMMENT_COUNTER).getText();
            commentCounter = commentCounter.substring(1, commentCounter.length() - 1);
        } else {
            commentCounter = "0";
        }
        return Integer.parseInt(commentCounter);
    }
}
