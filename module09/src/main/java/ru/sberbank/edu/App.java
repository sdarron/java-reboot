package ru.sberbank.edu;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        WeatherCache cache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo = cache.getWeatherInfo("Moscow");
        System.out.println(weatherInfo.toString());
        sleep(2000);
        WeatherInfo weatherInfo1 = cache.getWeatherInfo("Moscow");
        System.out.println(weatherInfo1.toString());
    }
}
