package homework.tvnetpo.pages;

import org.openqa.selenium.By;

public class ArticlePage {

    private final By COMMENT_COUNTER = By.xpath(".//span[@class = 'article-share__item--count']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline')]");
    private final By COMMENTS_PAGE_ICON = By.xpath(".//a[contains(@class, 'item--comments')]");

    private BaseFunctions baseFunctions;

    public ArticlePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getTitle() {
        return baseFunctions.findElement(ARTICLE_TITLE).getText();
    }

    public int getCommentCount() {

        String commentCounter;

        if (baseFunctions.findElements(COMMENT_COUNTER).size() != 0) {
            commentCounter = baseFunctions.findElement(COMMENT_COUNTER).getText();
        } else {
            commentCounter = "0";
        }

        return Integer.parseInt(commentCounter);
    }

    public void openCommentsPage() {
        baseFunctions.findElement(COMMENTS_PAGE_ICON).click();
    }

}
