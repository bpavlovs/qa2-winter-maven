package homework.ticketbooking.stepdefinitions;

import homework.ticketbooking.pages.BaseFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import homework.ticketbooking.pages.FlightConfirmationPage;
import homework.ticketbooking.pages.FlightDetailsPage;
import homework.ticketbooking.pages.HomePage;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsStepDefs {
    private String departure;
    private String destination;
    private int seatId;
    private Map<String, String> personalInfo;

    private BaseFunctions baseFunctions = new BaseFunctions();
    private HomePage homePage;
    private FlightDetailsPage flightDetailsPage;
    private FlightConfirmationPage flightConfirmationPage;


    @Given("airports {string} and {string}")
    public void set_airports(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    @Given("personal info is")
    public void set_personal_info(Map<String, String> params) {
        personalInfo = params;
    }

    @Given("seat id is {int}")
    public void set_seat_id(int seatId) {
        this.seatId = seatId;
    }

    @Given("home page open")
    public void open_home_page() {
        baseFunctions.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunctions);
    }

    @When("selecting airports")
    public void select_airports() {
        homePage.selectAirports(departure, destination);
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoButton();
        flightDetailsPage = new FlightDetailsPage(baseFunctions);
    }

    @When("filing in flight details form")
    public void fill_personal_info() {
        flightDetailsPage.fillFlightDetailsForm(personalInfo);
    }

    @When("pressing Get Price button")
    public void press_get_price_button() {
        flightDetailsPage.pressGetPriceButton();
    }

    @When("pressing Book! button")
    public void press_book_button() {
        flightDetailsPage.pressBookButton();
    }

    @When("pressing seat number button")
    public void press_seat_button() {
        flightDetailsPage.pressSeatButton(seatId);
    }

    @When("pressing final Book! button")
    public void press_final_book_button() {
        flightDetailsPage.pressFinalBookButton();
        flightConfirmationPage = new FlightConfirmationPage(baseFunctions);
    }

    @Then("selected airports appear on Flight Details Page")
    public void check_selected_airports() {
        List<String> selectedAirports = flightDetailsPage.getSelectedAirports();

        assertEquals(departure, selectedAirports.get(0), "Departure airports do not match!");
        assertEquals(destination, selectedAirports.get(1), "Destination airports do not match!");
    }

    @Then("selected seat appears on the Flight Details Page")
    public void check_selected_seat() {
        assertEquals(seatId, flightDetailsPage.getSelectedSeat(), "Selected seats di bit natch!");
    }

    //TODO: Can we do this with a getter? or do we need to use a step in .feature and pass value into variable?
    @Then("flight confirmation message appears")
    public void check_confirmation_message() {
        Assertions.assertEquals(flightConfirmationPage.getEXPECTED_MESSAGE(),
                flightConfirmationPage.getConfirmationMessage(), "Confirmation messages do not match!");
    }
}