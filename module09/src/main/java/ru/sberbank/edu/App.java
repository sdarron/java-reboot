package ru.sberbank.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

    //    ApplicationContext context = new AnnotationConfigApplicationContext("ru.sberbank.edu");

     //   RestTemplate restTemplate = context.getBean(RestTemplate.class);
    //    WeatherCache cache = context.getBean(WeatherCache.class);
        WeatherCache cache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo = cache.getWeatherInfo("Moscow");
        System.out.println(weatherInfo.toString());
        sleep(2000);
        WeatherInfo weatherInfo1 = cache.getWeatherInfo("Moscow");
        System.out.println(weatherInfo1.toString());
    }
}
