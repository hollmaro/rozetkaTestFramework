package com.rozetka.other;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.junit.Ignore;

/**
 * Unit test for simple App.
 */
@Ignore
public class AppTest 
    extends TestCase
{
Logger log = Logger.getLogger(getClass());
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {

        super( testName );
        log.info("Everything ok!!!");
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
        log.info("Everything ok!!!");
    }
}
