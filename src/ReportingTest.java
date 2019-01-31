package src;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ReportingTest.
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class ReportingTest 
{
    private Reporting reporter;
    private District district1;
    private Incident incident1;
    private Incident incident2;
    private Incident incident3;
    private Incident incident4;
    private District district2;
    private Incident incident5;
    private Incident incident6;
    private Incident incident7;
    
    /**
     * Default constructor for test class ReportingTest
     */
    public ReportingTest()
    {
    	
    }
    
    /**
     * Set up the test fixture.
     * 
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        reporter = new Reporting();
        district1 = new District("Greendale");
        incident1 = new Incident(200, "NE1", "Jan", 2015);
        incident2 = new Incident(40, "NE4", "Mar", 2015);
        incident3 = new Incident(700, "SW10", "Apr", 2016);
        incident4 = new Incident(950, "CA22", "Apr", 2015);
        district2 = new District("Newtown");
      
        
        district1.addIncident(incident1);
        district1.addIncident(incident2);
        district1.addIncident(incident3);
        district1.addIncident(incident4);
        reporter.addDistrict(district1);
        reporter.addDistrict(district2);
        incident5 = new Incident(400, "NE1", "Mar", 2015);
        incident6 = new Incident(450, "NE1", "Apr", 2016);
        incident7 = new Incident(700, "NE1", "Oct", 2018);
        district2.addIncident(incident5);
        district2.addIncident(incident6);
        district2.addIncident(incident7);
    }
    
    /**
     * Tears down the test fixture.
     * 
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    	
    }
    
    @Test
    public void maxIncidentNotNull()
    {
    	assertNotNull(reporter.maxIncident());
    }
    
    @Test
    public void maxIncidentIs4()
    {
        assertEquals(incident4, reporter.maxIncident());
    }
    

    @Test
    public void HighestAveragefor2015IsDistrict1()
    {
        assertEquals(district2, reporter.largestAvgIncident(2015));
    }
    
    @Test
    public void allIncidentBiggerNotNull()
    {
        assertNotNull(reporter.allIncidentsBiggerThan(400));
    }
}
