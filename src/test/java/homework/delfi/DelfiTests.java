package homework.delfi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DelfiTests {
    private final String HOME_PAGE_URL = "http://www.delfi.lv/";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By CLOSE_AD_BTN = By.id("closeButton");
    private final By OPEN_COMMENTS_BTN = By.xpath(".//a[contains (@class, 'd-print-none')]");
    private final By HEADLINE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_TITLE = By.xpath(".//h1[@class = 'article-title']");
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

        browser.switchTo().frame("frontTarget");
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_AD_BTN));
        browser.findElement(CLOSE_AD_BTN).click();

        browser.switchTo().defaultContent();

        List<WebElement> headlines = browser.findElements(HEADLINE_TITLE);
        WebElement headlineTitle = headlines.get(5);
        String headlineTitle2 = headlineTitle.getText().trim();
        headlineTitle.click();

        WebElement articleTitle = browser.findElement(ARTICLE_TITLE);
        String articleTitle2 = articleTitle.getText().trim();

        assert articleTitle2.equals(headlineTitle2);

        wait.until(ExpectedConditions.elementToBeClickable(OPEN_COMMENTS_BTN));
        browser.findElement(OPEN_COMMENTS_BTN).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(COMMENTS_TITLE));
        WebElement commentsTitle = browser.findElement(COMMENTS_TITLE);
        String commentsTitle2 = commentsTitle.getText().trim();

        System.out.println(articleTitle2);
        System.out.println(headlineTitle2);
        System.out.println(commentsTitle2);

        assert commentsTitle2.equals(headlineTitle2);

        browser.get(HOME_PAGE_URL);
        headlines = browser.findElements(HEADLINE_TITLE);

        System.out.println("");

        for (WebElement headline : headlines) {
            if(!headline.getText().isEmpty()){
                System.out.println(headline.getText());
            }
        }
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
