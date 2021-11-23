package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    @Test
    public void firstTvNetTest() {

        //Setting a path to the driver
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

        //Opening browser window (driver instead of browser)
        WebDriver browser = new ChromeDriver();

        //Switching browser window to fullscreen
        browser.manage().window().maximize();

        //Opening TVNet webpage
        browser.get("http://www.tvnet.lv/");

        //Locators ID -> Name -> Xpath(universal locator) -> Class
        By acceptButton = By.id("button");
        By emailInput = By.name("user[email]");
        By xpathButton = By.xpath(".//button[@mode = 'primary']");

        browser.findElement(xpathButton).click();

        //XPath
        //   // -> Selenium will always look through the whole window
        //   .// -> Selenium will look within a specific element (preferred)

        //   .//button <- exact tag [@mode = 'primary']
        //    //* <- any tag

        //   .//button[@mode = 'primary']
        //   .//div[@class = 'users-session__content-panel users-session__content-panel--secondary'] <- full
        //   .//div[contains(@class, 'secondary')] <- partial









    }

}
