package tvnet;

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

public class TvNetTests {

    //FINAL variables are assigned using upper case and underscores
    private final String HOME_PAGE_URL = "http://www.tvnet.lv/";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private WebDriver browser;

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement firstTitle = browser.findElement(ARTICLE_TITLE);
        System.out.println(firstTitle.getText());

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE);
        System.out.println(titles.get(5).getText());
        titles.get(8).click();
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}

//DELFI - go, close cookies, save 1st title as variable,
// go there (click), on the open page get title,
// 1st sout both titles to console; 2nd compare the titles;
// 3rd go to comments page and check the title again

// Bonus - go to DELFI, to console all headlines