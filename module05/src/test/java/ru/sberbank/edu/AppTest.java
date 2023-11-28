package ru.sberbank.edu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

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

    public void testTravelService(){
        TravelService testService = new TravelService();
        testService.add(new CityInfo("Moscow", new GeoPosition("55(45'21'')", "37(36'56'')")));
        testService.add(new CityInfo("Pskov", new GeoPosition("57(49'00'')", "28(20'00'')")));
        testService.add(new CityInfo("Ekaterinburg", new GeoPosition("56(50'00'')", "60(35'00'')")));
        List<String> citiesNames = new ArrayList<>();
        citiesNames.add("Moscow");
        citiesNames.add("Pskov");
        citiesNames.add("Ekaterinburg");
        Assert.assertEquals("Test Names",citiesNames, testService.citiesNames());
        Assert.assertEquals("Test Cities Near", "Pskov", testService.getCitiesNear("Moscow", 1000).get(0));
        Assert.assertTrue( "Test Distance", testService.getDistance("Moscow", "Pskov") < 650
                                                            && testService.getDistance("Moscow", "Pskov") > 600);
    }
}
