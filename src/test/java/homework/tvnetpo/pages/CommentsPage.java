package homework.tvnetpo.pages;

import org.openqa.selenium.By;

public class CommentsPage {

    private final By COMMENT_COUNTER = By.xpath(".//span[contains(@class, 'count')]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[@class = 'article-headline']");

    private BaseFunctions baseFunctions;

    public CommentsPage(BaseFunctions baseFunctions){
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

}
