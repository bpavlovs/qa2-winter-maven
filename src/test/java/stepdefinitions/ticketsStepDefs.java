package stepdefinitions;

import homework.tvnetpo.pages.BaseFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import tickets.FlightDetailsPage;
import tickets.HomePage;

import java.util.List;
import java.util.Map;

public class ticketsStepDefs {

    private String departure;
    private String destination;
    private Map<String, String> personalInfo;

    private BaseFunctions baseFunctions = new BaseFunctions();
    private HomePage homePage;
    private FlightDetailsPage flightDetailsPage;


    @Given("airports {string} and {string}")
    public void set_airports(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    @Given("personal info is")
    public void set_personal_info(Map<String, String> params) {
        personalInfo = params;
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunctions.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunctions);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(departure, destination);
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoButton();
        flightDetailsPage = new FlightDetailsPage(baseFunctions);
    }

    @When("we are filing in flight details form")
    public void fill_personal_info() {

    }

    @Then("selected airports appear on Flight Details Page")
    public void check_selected_airports() {
        List<String> selectedAirports = flightDetailsPage.getSelectedAirports();

        Assertions.assertEquals(departure, selectedAirports.get(0), "Departure airports do not match!");
        Assertions.assertEquals(destination, selectedAirports.get(1), "Destination airports do not match!");
    }

}

//fill, book, select seat, check the seat is correct, press book, assert that you are on successful page