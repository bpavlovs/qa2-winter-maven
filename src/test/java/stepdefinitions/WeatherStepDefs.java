package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;


public class WeatherStepDefs {

    private String countryName;
    private String cityName;

    @Given("city name is {string}")
    public void city_name(String cityName) {
        this.cityName = cityName;
    }

    @And("country name is {string}")
    public void country_name(String countryName) {
        this.countryName = countryName;
    }

    @When("we are requesting weather data")
    public void get_weather_data(String cityName, String countryName) {

    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, String> generalInfo) {

    }

    @And("weather info is:")
    public void check_weather_info(Map<String, String> weatherInfo) {

    }

    @And("base is {string}")
    public void check_base(String base) {

    }

    @And("main info is:")
    public void check_main_info(Map<String, String> mainInfo) {

    }

    @And("visibility is {int}")
    public void check_visibility(int visibility) {

    }

    @And("wind is:")
    public void check_wind(Map<String, String> windInfo) {

    }

    @And("clouds are {string}")
    public void check_clouds(String cloudInfo) {

    }

    @And("dt is {int}")
    public void check_dt(int dt) {

    }

    @And("sys is:")
    public void check_sys(Map<String, String> sysInfo) {

    }

    @And("id is {int}")
    public void check_id(int id){

    }

    @And("name is {string}")
    public void check_name(String name){

    }

    @And("cod is {int}")
    public void check_cod(int cod){

    }


}






