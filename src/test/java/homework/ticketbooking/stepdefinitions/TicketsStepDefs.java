package homework.ticketbooking.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import homework.ticketbooking.model.Reservation;
import homework.ticketbooking.pages.*;
import homework.ticketbooking.requesters.ReservationRequester;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsStepDefs {
    private List<Reservation> response;

    private BaseFunctions baseFunctions = new BaseFunctions();
    private Reservation givenReservation = new Reservation();
    private HomePage homePage;
    private FlightDetailsPage flightDetailsPage;
    private FlightConfirmationPage flightConfirmationPage;

    @Given("airports {string} and {string}")
    public void set_airports(String departure, String destination) {
        givenReservation.setFrom(departure);
        givenReservation.setTo(destination);
    }

    @Given("personal info is")
    public void set_personal_info(Map<String, String> params) {
        givenReservation.setName(params.get("first_name"));
        givenReservation.setSurname(params.get("last_name"));
        givenReservation.setDiscount(params.get("discount"));
        givenReservation.setAdultCount(Integer.parseInt(params.get("adult_count")));
        givenReservation.setChildren(Integer.parseInt(params.get("kid_count")));
        givenReservation.setBagCount(Integer.parseInt(params.get("bag_count")));
        givenReservation.setFlightDate(params.get("flight_date"));
    }

    @Given("seat id is {int}")
    public void set_seat_id(int seatId) {
        givenReservation.setSeat(seatId);
    }

    @Given("home page open")
    public void open_home_page() {
        baseFunctions.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunctions);
    }

    @When("selecting airports")
    public void select_airports() {
        homePage.selectAirports(givenReservation.getFrom(), givenReservation.getTo());
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoButton();
        flightDetailsPage = new FlightDetailsPage(baseFunctions);
    }

    @When("filing in flight details form")
    public void fill_personal_info() {
        flightDetailsPage.fillFlightDetailsForm(givenReservation);
    }

    @When("pressing Get Price button")
    public void press_get_price_button() {
        flightDetailsPage.submitForm();
    }

    @When("pressing Book! button")
    public void press_book_button() {
        flightDetailsPage.pressBookButton();
    }

    @When("pressing seat number button")
    public void press_seat_button() {
        flightDetailsPage.pressSeatButton(givenReservation.getSeat());
    }

    @When("pressing final Book! button")
    public void press_final_book_button() {
        flightDetailsPage.pressFinalBookButton();
        flightConfirmationPage = new FlightConfirmationPage(baseFunctions);
    }

    @When("we are requesting all reservations")
    public void request_reservation() throws JsonProcessingException {
        ReservationRequester requester = new ReservationRequester();
        response = requester.requestReservations();
    }

    @Then("selected airports appear on Flight Details Page")
    public void check_selected_airports() {
        List<String> selectedAirports = flightDetailsPage.getSelectedAirports();

        assertEquals(givenReservation.getFrom(), selectedAirports.get(0), "Departure airports do not match!");
        assertEquals(givenReservation.getTo(), selectedAirports.get(1), "Destination airports do not match!");
    }

    @Then("passenger name is shown")
    public void check_passenger_name() {
        assertEquals(givenReservation.getName(), flightDetailsPage.getPassengerName(), "Wrong passenger name!");
    }

    @Then("selected seat appears on the Flight Details Page")
    public void check_selected_seat() {
        assertEquals(givenReservation.getSeat(), flightDetailsPage.getSelectedSeat(), "Selected seats do not match!");
    }

    @Then("flight confirmation message appears")
    public void check_confirmation_message() {
        assertTrue(flightConfirmationPage.isConfirmationMessageCorrect());
    }

    @Then("reservation is present in the list with correct data")
    public void check_current_reservation() {

        Reservation actualReservation = null;
        for (Reservation r : response) {
            if (r.getName().equals(givenReservation.getName())) {
                actualReservation = r;
                break;
            }
        }

        assertNotNull(actualReservation, "There is no such reservation");
        assertEquals(givenReservation.getSurname(), actualReservation.getSurname(), "Surnames do not match");
        assertEquals(givenReservation.getDiscount(), actualReservation.getDiscount(), "Discounts do not match");
        assertEquals(givenReservation.getAdultCount(), actualReservation.getAdultCount(), "Adult counts do not match");
        assertEquals(givenReservation.getChildren(), actualReservation.getChildren(), "Children counts do not match");
        assertEquals(givenReservation.getBagCount(), actualReservation.getBagCount(), "Bag counts do not match");
        assertEquals(givenReservation.getFlightDay(), actualReservation.getFlightDay(), "Flight days do not match");
    }
}