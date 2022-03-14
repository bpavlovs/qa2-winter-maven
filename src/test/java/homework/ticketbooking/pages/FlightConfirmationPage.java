package homework.ticketbooking.pages;

import org.openqa.selenium.By;

public class FlightConfirmationPage {
    private final By CONFIRMATION_MESSAGE = By.xpath(".//div[@class = 'finalTxt']");
    private final String EXPECTED_MESSAGE = "Thank You for flying with us!";

    private BaseFunctions baseFunctions;

    public FlightConfirmationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public boolean isConfirmationMessageCorrect() {
        return (baseFunctions.findElement(CONFIRMATION_MESSAGE).getText().equals(EXPECTED_MESSAGE));
    }
}
