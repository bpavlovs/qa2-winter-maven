package homework.tvnet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TvNetTests {

    private final String HOME_PAGE_URL = "http://tvnet.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button [@mode = 'primary']");
    private final By HEADLINE_TITLE = By.xpath(".//span [@class = 'list-article__headline']");
    private final By ARTICLE_TITLE = By.xpath(".//h1 [@class = 'article-headline']");
    private final By ARTICLE_COMMENT_COUNT = By.xpath(".//span [@class = 'article-share__item--count']");
    private WebDriver browser;

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = browser.findElements(HEADLINE_TITLE);
        WebElement headlineTitle = headlines.get(8);
        String headlineTitle1 = headlineTitle.getText();
        int headlineCommentCount = Integer.parseInt(headlineTitle1.substring((headlineTitle1.indexOf("(") + 1), headlineTitle1.indexOf(")")));
        headlineTitle1 = headlineTitle1.substring(0, headlineTitle1.indexOf(" ("));

        wait.until(ExpectedConditions.elementToBeClickable(headlineTitle));
        headlineTitle.click();

        WebElement articleTitle = browser.findElement(ARTICLE_TITLE);
        String articleTitle1 = articleTitle.getText();

        WebElement articleComments = browser.findElement(ARTICLE_COMMENT_COUNT);
        int articleCommentCount = Integer.parseInt(articleComments.getText());

        Assertions.assertEquals(articleCommentCount, headlineCommentCount, "Comment count does not match!");
        Assertions.assertEquals(headlineTitle1, articleTitle1, "Titles are not equal!");
    }

    @AfterEach
    public void closeBrowser() {
        browser.quit();
    }
}
