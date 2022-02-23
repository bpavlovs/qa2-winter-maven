package homework.delfipo.pages;

import org.openqa.selenium.By;

public class CommentsPage {
    private final By ARTICLE_TITLE = By.xpath(".//h1[@class='article-title']");
    private final By COMMENT = By.xpath(".//div[@class='comment-body']");
    private final By MORE_COMMENTS_BUTTON = By.id("btnLoadmore");

    private BaseFunctions baseFunctions;

    public CommentsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public int getCommentCount() {
        int extraComments;

        if (baseFunctions.findElements(MORE_COMMENTS_BUTTON).isEmpty()) {
            extraComments = 0;
        } else {
            String[] commentButton = baseFunctions.findElement(MORE_COMMENTS_BUTTON).getText().split(" ");
            String commentsToParse = commentButton[commentButton.length - 1];
            extraComments = Integer.parseInt(commentsToParse.substring(1, commentsToParse.length() - 1));
        }
        return baseFunctions.findElements(COMMENT).size() + extraComments;
    }

    public String getArticleTitle() {
        return baseFunctions.findElement(ARTICLE_TITLE).getText();
    }
}
