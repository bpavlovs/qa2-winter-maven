package tickets;

import homework.tvnetpo.pages.BaseFunctions;
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

    public void fillFlightDetailsForm(Map<String, String> params) {
        baseFunctions.type(NAME_INPUT, params.get("first_name"));
        baseFunctions.selectByVisibleText(FLIGHT_SELECT, params.get("flight_date"));
    }
}
