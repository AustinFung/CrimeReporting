package src;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DistrictTest
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class DistrictTest 
{
	private District district1;
	private Incident incident1;
	private Incident incident2;
	private Incident incident3;
	private Incident incident4;
	
	/**
	 * Default constructor for test class DistrictTest
	 */
	public DistrictTest() 
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
        district1 = new District("Greendale");
        incident1 = new Incident(200, "NE1", "Jan", 2015);
        incident2 = new Incident(40, "NE4", "Mar", 2015);
        incident3 = new Incident(700, "SW10", "Apr", 2016);
        incident4 = new Incident(950, "CA22", "Apr", 2015);
        
        district1.addIncident(incident1);
        district1.addIncident(incident2);
        district1.addIncident(incident3);
        district1.addIncident(incident4);
	}
	
	/**
	 * Tears down the test fixture.
	 * 
	 * Call after every test case method.
	 */
	@After
	public void tearDown()
	{
		
	}
	
	@Test
	public void AverageValfor2015Is396()
	{
		assertEquals(396, district1.findAverageValue(2015), 0.1);
	}
	
	@Test
	public void AverageValfor2016Is700()
	{
		assertEquals(700, district1.findAverageValue(2016), 0.1);
	}
	
	@Test
	public void AverageValforUnknownYearis0()
	{
		assertEquals(0, district1.findAverageValue(2000), 0.1);
	}
	
	
	@Test
	public void biggestValIsIncident4()
	{
		assertEquals(incident4, district1.findBiggest());
	}
	
	@Test
	public void DistrictListNotNull()
	{
		assertNotNull(district1.crimesHigherThan(300));
	}
}
