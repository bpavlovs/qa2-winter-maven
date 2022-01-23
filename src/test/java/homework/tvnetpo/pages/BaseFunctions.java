package homework.tvnetpo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunctions {

    private WebDriver browser;

//    WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

    public BaseFunctions() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void openUrl(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public List<WebElement> findElements(WebElement parentElement, By childElement) {
        return parentElement.findElements(childElement);
    }

    public WebElement findElement(By locator) {
        return browser.findElement(locator);
    }

    //should we declare wait outside?
    public WebElement findElement(WebElement parentElement, By childElement) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElement));
        return parentElement.findElement(childElement);
    }


}
