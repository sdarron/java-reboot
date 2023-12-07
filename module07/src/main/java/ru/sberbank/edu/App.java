package ru.sberbank.edu;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 *  Проект для домашнего задания #7 Школы Java разработчиков
 *  @author Зайцев Денис Николевич
 *  @version 1.0
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
