package tickets.pages;

import tickets.pages.BaseFunctions;
import org.openqa.selenium.By;

public class FlightConfirmationPage {

    private final By CONFIRMATION_MESSAGE = By.xpath(".//div[@class = 'finalTxt']");

    private BaseFunctions baseFunctions;

    public FlightConfirmationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getConfirmationMessage() {
        return baseFunctions.findElement(CONFIRMATION_MESSAGE).getText();
    }
}
