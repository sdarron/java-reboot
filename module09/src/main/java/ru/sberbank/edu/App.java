package ru.sberbank.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 *  Проект для домашнего задания #9 Школы Java разработчиков
 *  @author Зайцев Денис Николевич
 *  @version 1.0
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.sberbank.edu");
        WeatherCache cache = context.getBean(WeatherCache.class);
        WeatherInfo weatherInfo = cache.getWeatherInfo("OMSK");
        System.out.println("GOOD! weather=" + weatherInfo);
    }
}
