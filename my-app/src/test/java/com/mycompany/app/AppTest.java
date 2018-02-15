package com.mycompany.app;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;

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
     *
     */
    public void testApp()
    {
        RevenueCalculator rc = new CalculateRevenue();

        // happy path
        Assert.assertEquals(new BigDecimal(500).doubleValue(),
                rc.calculateRevenue(new BigDecimal(20), new BigDecimal(400)).doubleValue());


        // decimal
        Assert.assertEquals(new BigDecimal(12.85).doubleValue(),
                rc.calculateRevenue(new BigDecimal(17.89), new BigDecimal(10.55)).doubleValue());

        // 0%
        Assert.assertEquals(new BigDecimal(400).doubleValue(),
                rc.calculateRevenue(new BigDecimal(0), new BigDecimal(400)).doubleValue());

        // 0% free
        Assert.assertEquals(new BigDecimal(0).doubleValue(),
                rc.calculateRevenue(new BigDecimal(0), new BigDecimal(0)).doubleValue());


        // not possible as no cost
        try {
            rc.calculateRevenue(new BigDecimal(100), new BigDecimal(0));
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }

        // loss
        Assert.assertEquals(new BigDecimal(200).doubleValue(),
                rc.calculateRevenue(new BigDecimal(-100), new BigDecimal(400)).doubleValue());

        // rounding
        Assert.assertEquals(new BigDecimal(14.35).doubleValue(),
                rc.calculateRevenue(new BigDecimal(30.33), new BigDecimal(10)).doubleValue());

        // null arg
        try {
            rc.calculateRevenue(null, new BigDecimal(10));
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }

        // null arg
        try {
            rc.calculateRevenue(new BigDecimal(10),null);
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }

        // empty arg
        BigDecimal empty=null;
        try {
            rc.calculateRevenue(empty,new BigDecimal(10));
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }

        // empty arg
        try {
            rc.calculateRevenue(new BigDecimal(10), empty);
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }

        // -ve cost
        try {
            rc.calculateRevenue(new BigDecimal(10), new BigDecimal(-10));
            fail();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Cannot calculate");
        }
    }
}
