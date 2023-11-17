package ru.sberbank.edu;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    public void testSaveFile() {
        String fileData = "File name: " + "Test.txt" +
                "; max line: " + "test test" +
                "; count space: " + "1" +
                "; count line: " + "1" + "\n";
        SavingToFile saveToFile = new SavingToFile( fileData, "FileStatistic.txt");
        saveToFile.goSave();

        String message = saveToFile.getResult();
        assertEquals("Test Save File", "success", message);
    }
}
