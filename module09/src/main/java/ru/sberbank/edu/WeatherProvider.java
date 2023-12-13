package ru.sberbank.edu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Weather provider
 */
public class WeatherProvider {

    private RestTemplate restTemplate = null;

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        WeatherInfo weatherInfo = new WeatherInfo();

        String resourceUrl
                = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=449157eb11a57411ec0b4147d6f98095";

        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(resourceUrl, String.class);
        } catch (RestClientException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String productsJson = response.getBody();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> mapAll = new HashMap<String, Object>();
            mapAll = mapper.readValue(productsJson, new TypeReference<Map<String, Object>>() {
            });

            weatherInfo.setCity(mapAll.get("name").toString());
            weatherInfo.setExpiryTime(LocalDateTime.now(ZoneId.of("UTC")));

            Map<String, String> weathers = Splitter.on(",")
                    .withKeyValueSeparator("=")
                    .split(mapAll.get("weather").toString());
            weatherInfo.setDescription(weathers.get(" description"));

            Map<String, String> main = Splitter.on(",")
                    .withKeyValueSeparator("=")
                    .split(mapAll.get("main").toString());
            weatherInfo.setPressure(Double.parseDouble(main.get(" pressure")));
            weatherInfo.setTemperature(Double.parseDouble(main.get("{temp")));
            weatherInfo.setFeelsLikeTemperature(Double.parseDouble(main.get(" feels_like")));

            Map<String, String> wind = Splitter.on(",")
                    .withKeyValueSeparator("=")
                    .split(mapAll.get("wind").toString());
            weatherInfo.setWindSpeed(Double.parseDouble(wind.get("{speed")));

            String description = weatherInfo.getDescription();
            String[] descrArray = description.split(" ");
            weatherInfo.setShortDescription(descrArray[descrArray.length - 1]);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return weatherInfo;
    }
}
