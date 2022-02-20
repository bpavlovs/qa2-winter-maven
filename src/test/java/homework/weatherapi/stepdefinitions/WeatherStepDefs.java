package homework.weatherapi.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import homework.weatherapi.requesters.WeatherRequester;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import homework.weatherapi.model.Weather;
import homework.weatherapi.model.WeatherResponse;

import java.util.Map;

import static java.lang.Double.*;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city id is {long}")
    public void city_name(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester request = new WeatherRequester();
        response = request.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong lon!");
        assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong lat!");
    }

    @Then("weather info is:")
    public void check_weather_info(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(parseLong(params.get("id")), weather.getId(), "Wrong weather id!");
        assertEquals(params.get("main"), weather.getMain(), "Wrong weather main!");
        assertEquals(params.get("description"), weather.getDescription(), "Wrong weather description!");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong weather icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Wrong base!");
    }

    @Then("main info is:")
    public void check_main_info(Map<String, String> params) {
        assertEquals(parseDouble(params.get("temp")), response.getMain().getTemp(), "Wrong temp!");
        assertEquals(parseInt(params.get("pressure")), response.getMain().getPressure(), "Wrong pressure!");
        assertEquals(parseInt(params.get("humidity")), response.getMain().getHumidity(), "Wrong humidity!");
        assertEquals(parseDouble(params.get("temp_min")), response.getMain().getTempMin(), "Wrong min temp!");
        assertEquals(parseDouble(params.get("temp_max")), response.getMain().getTempMax(), "Wrong max temp!");
    }

    @Then("visibility is {int}")
    public void check_visibility(long visibility) {
        assertEquals(visibility, response.getVisibility(), "Wrong visibility!");
    }

    @Then("wind is:")
    public void check_wind(Map<String, String> windInfo) {
        assertEquals(parseDouble(windInfo.get("speed")), response.getWind().getSpeed(), "Wrong wind speed!");
        assertEquals(parseLong(windInfo.get("deg")), response.getWind().getDeg(), "Wrong wind deg!");
    }

    @Then("cloud's all is {long}")
    public void check_clouds(long cloudInfo) {
        assertEquals(cloudInfo, response.getClouds().getAll(), "Wrong cloud's all!");

    }

    @Then("dt is {long}")
    public void check_dt(long dt) {
        assertEquals(dt, response.getDt(), "Wrong dt!");
    }

    @Then("sys is:")
    public void check_sys(Map<String, String> sysInfo) {
        assertEquals(parseLong(sysInfo.get("type")), response.getSys().getType(), "Wrong type!");
        assertEquals(parseLong(sysInfo.get("id")), response.getSys().getId(), "Wrong id!");
        assertEquals(parseDouble(sysInfo.get("message")), response.getSys().getMessage(), "Wrong message!");
        assertEquals(sysInfo.get("country"), response.getSys().getCountry(), "Wrong country!");
        assertEquals(parseLong(sysInfo.get("sunrise")), response.getSys().getSunrise(), "Wrong sunrise!");
        assertEquals(parseLong(sysInfo.get("sunset")), response.getSys().getSunset(), "Wrong sunset!");
    }

    @Then("id is {long}")
    public void check_id(long id) {
        assertEquals(id, response.getId(), "Wrong ID!");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        assertEquals(name, response.getName(), "Wrong name!");
    }

    @Then("cod is {long}")
    public void check_cod(long cod) {
        assertEquals(cod, response.getCod(), "Wrong cod!");
    }
}






