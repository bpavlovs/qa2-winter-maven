package homework.ticketbooking.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightDetailsPage {
    private final By SELECTED_AIRPORTS = By.xpath(".//span[@class = 'bTxt']");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULT_COUNT_INPUT = By.id("adults");
    private final By KID_COUNT_INPUT = By.id("children");
    private final By BAG_COUNT_INPUT = By.id("bugs");
    private final By FLIGHT_SELECT = By.id("flight");
    private final By GET_PRICE_BUTTON = By.xpath(".//span[contains (@onclick, 'setLang')]");
    private final By BOOK_BUTTON = By.id("book2");
    private final By FINAL_BOOK_BUTTON = By.id("book3");
    private final By FLIGHT_SEATS = By.xpath(".//div[@class = 'seat']");
    private final By SELECTED_SEAT = By.xpath(".//div[@class = 'line']");
    private final By PASSENGER_NAME = By.xpath(".//div[@id = 'response']/span");

    private BaseFunctions baseFunctions;

    public FlightDetailsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public List<String> getSelectedAirports() {
        List<WebElement> selectedAirports = baseFunctions.findElements(SELECTED_AIRPORTS);

        List<String> result = new ArrayList<>();

        for (WebElement we : selectedAirports) {
            result.add(we.getText());
        }
        return result;
    }

    public int getSelectedSeat() {
        return Integer.parseInt(baseFunctions.findElement(SELECTED_SEAT).getText().split(": ")[1]);
    }

    public void fillFlightDetailsForm(Map<String, String> params) {
        baseFunctions.type(NAME_INPUT, params.get("first_name"));
        baseFunctions.type(SURNAME_INPUT, params.get("last_name"));
        baseFunctions.type(DISCOUNT_INPUT, params.get("discount"));
        baseFunctions.type(ADULT_COUNT_INPUT, Integer.parseInt(params.get("adult_count")));
        baseFunctions.type(KID_COUNT_INPUT, Integer.parseInt(params.get("kid_count")));
        baseFunctions.type(BAG_COUNT_INPUT, Integer.parseInt(params.get("bag_count")));
        baseFunctions.selectByVisibleText(FLIGHT_SELECT, params.get("flight_date"));
    }

    public void submitForm() {
        baseFunctions.click(GET_PRICE_BUTTON);
    }

    public String getPassengerName() {
        return baseFunctions.findElement(PASSENGER_NAME).getText().replace("!", "");
    }

    public void pressBookButton() {
        baseFunctions.click(BOOK_BUTTON);
    }

    public void pressFinalBookButton() {
        baseFunctions.click(FINAL_BOOK_BUTTON);
    }

    public void pressSeatButton(int seatId) {
        for (WebElement we : baseFunctions.findElements(FLIGHT_SEATS)){
            if (Integer.parseInt(we.getText()) == seatId) {
                we.click();
                break;
            }
        }
    }
}
