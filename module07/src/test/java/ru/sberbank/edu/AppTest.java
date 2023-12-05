package ru.sberbank.edu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testWeather() throws IOException, InterruptedException {

        WeatherCache cache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo = cache.getWeatherInfo("Moscow");
        Assert.assertEquals("Test Weather Info City", "Moscow", weatherInfo.getCity());
        LocalDateTime time = weatherInfo.getExpiryTime();
        sleep(2000);
        WeatherInfo weatherInfo1 = cache.getWeatherInfo("Moscow");
        Assert.assertEquals("Test Weather cash", time, weatherInfo1.getExpiryTime());
        cache.removeWeatherInfo("Moscow");
        WeatherInfo weatherInfo2 = cache.getWeatherInfo( "Moscow");
        Assert.assertNotEquals("Test Weather no cash", time, weatherInfo2.getExpiryTime());

    }
}
