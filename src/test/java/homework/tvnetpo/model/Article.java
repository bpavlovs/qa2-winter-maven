package homework.tvnetpo.model;

import org.openqa.selenium.WebElement;

public class Article {

    private String title;
    private int commentCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setCommentCount(WebElement webElement) {

        String commentsToParse = webElement.getText();
        commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
        this.commentCount = Integer.parseInt(commentsToParse);
    }
}
