package ru.sberbank.edu;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * Weather cache.
 */
public class WeatherCache {

    private final Map<String, WeatherInfo> cache = new HashMap<>();
    private WeatherProvider weatherProvider;

    /**
     * Default constructor.
     */
    public WeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Get ACTUAL weather info for current city or null if current city not found.
     * If cache doesn't contain weather info OR contains NOT ACTUAL info then we should download info
     * If you download weather info then you should set expiry time now() plus 5 minutes.
     * If you can't download weather info then remove weather info for current city from cache.
     *
     * @param city - city
     * @return actual weather info
     */
    public synchronized WeatherInfo getWeatherInfo(String city) throws IOException {
        WeatherInfo weatherInfo = cache.get(city);
        if (weatherInfo == null || Duration.between(weatherInfo.getExpiryTime(), LocalDateTime.now(ZoneId.of("UTC"))).getSeconds() > 300 ) {
            cache.put(city, weatherProvider.get(city));
        }
        return cache.get(city);
    }

    /**
     * Remove weather info from cache.
     **/
    public synchronized void removeWeatherInfo(String city) throws IOException {
        cache.remove(city);
    }
}