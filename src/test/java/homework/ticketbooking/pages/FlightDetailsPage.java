package homework.ticketbooking.pages;

import homework.ticketbooking.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class FlightDetailsPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
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
        LOGGER.info("Getting selected airports");
        List<WebElement> selectedAirports = baseFunctions.findElements(SELECTED_AIRPORTS);

        List<String> result = new ArrayList<>();

        for (WebElement we : selectedAirports) {
            result.add(we.getText());
        }
        return result;
    }

    public int getSelectedSeat() {
        LOGGER.info("Getting selected seats");
        return Integer.parseInt(baseFunctions.findElement(SELECTED_SEAT).getText().split(": ")[1]);
    }

    public void fillFlightDetailsForm(Reservation reservation) {
        LOGGER.info("Filling in flight details form");
        baseFunctions.type(NAME_INPUT, reservation.getName());
        baseFunctions.type(SURNAME_INPUT, reservation.getSurname());
        baseFunctions.type(DISCOUNT_INPUT, reservation.getDiscount());
        baseFunctions.type(ADULT_COUNT_INPUT, reservation.getAdultCount());
        baseFunctions.type(KID_COUNT_INPUT, reservation.getChildren());
        baseFunctions.type(BAG_COUNT_INPUT, reservation.getBagCount());
        baseFunctions.selectByVisibleText(FLIGHT_SELECT, reservation.getFlightDate());
    }

    public void submitForm() {
        LOGGER.info("Submitting the form");
        baseFunctions.click(GET_PRICE_BUTTON);
    }

    public String getPassengerName() {
        return baseFunctions.findElement(PASSENGER_NAME).getText().replace("!", "");
    }

    public void pressBookButton() {
        LOGGER.info("Booking tickets");
        baseFunctions.click(BOOK_BUTTON);
    }

    public void pressFinalBookButton() {
        baseFunctions.click(FINAL_BOOK_BUTTON);
    }

    public void pressSeatButton(int seatId) {
        baseFunctions.waitUntilElementsCountAtLeast(FLIGHT_SEATS, 10);
        for (WebElement we : baseFunctions.findElements(FLIGHT_SEATS)){
            if (Integer.parseInt(we.getText()) == seatId) {
                we.click();
                break;
            }
        }
    }
}
