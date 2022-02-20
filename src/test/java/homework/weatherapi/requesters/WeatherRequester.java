package homework.weatherapi.requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework.weatherapi.model.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {

    private final String URL_START = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String URL_END = "&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherResponse requestWeather(long cityId) throws JsonProcessingException {
        final String URL = URL_START + cityId + URL_END;

        //We are using spring-web to make queries and get response (as String)
        RestTemplate restTemplate = new RestTemplate();
        String jsonToParse = restTemplate.getForEntity(URL, String.class).getBody();

        //We are using Jackson to get objects with data as model from JSON (to convert / map)
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonToParse, WeatherResponse.class);
    }
}


