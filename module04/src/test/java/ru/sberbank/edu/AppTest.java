package ru.sberbank.edu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    public void testApp( )
    {
        assertTrue( true );
    }

    public void testPerson(){

        Integer[] numbers = {2, 4, 8, 9, 15, 21, 65};
        Integer[] testNumbers = {15, 2, 65, 21, 8, 9, 4};
        Arrays.sort(testNumbers, new CustomDigitComparator());
        Assert.assertEquals("Test Digit Comparator", numbers, testNumbers) ;


        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person( "Anna", "Boston", 15));
        persons.add(new Person( "Irina","Boston", 15));
        persons.add(new Person( "Anna", "Moscow", 15));
        persons.add(new Person( "Irina", "Moscow", 15));
        persons.add(new Person( "Masha", "Rostov", 15));

        ArrayList<Person> testPersons = new ArrayList<>();
        testPersons.add(new Person( "Masha", "Rostov", 15));
        testPersons.add(new Person( "Irina", "Moscow", 15));
        testPersons.add(new Person( "Anna", "Moscow", 15));
        testPersons.add(new Person( "Irina","Boston", 15));
        testPersons.add(new Person( "Anna", "Boston", 15));

        Collections.sort(testPersons);

        Assert.assertEquals("Test Person compare", persons, testPersons);

        Person person = new Person("Masha", "Rostov", 15);
        Person person2 = new Person("masha", "rostov", 15);
        Assert.assertEquals("Test Person Equals", person, person2);
        Assert.assertEquals("Test Person Equals Hash Code", person.hashCode(), person2.hashCode());

        Person person3 = new Person("Glasha", "rostov", 15);
        Assert.assertNotEquals("Test Person Equals 2", person, person3);
        Assert.assertNotEquals("Test Person Equals 2 Hash Code", person.hashCode(), person3.hashCode());
    }
}
