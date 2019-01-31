package src;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IncidentTest.
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class IncidentTest 
{
	private Incident incident1;
	
	/**
	 * Default constructor for test class IncidentTest
	 */
	public IncidentTest()
	{
		
	}
	
	/**
	 * Sets up the test fixture.
	 * 
	 * Called before every test case method.
	 */
	@Before
	public void setUp()
	{
		incident1 = new Incident(100, "NE1", "Feb", 2000);
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
	public void accessorTest()
	{
        assertEquals(2000, incident1.getYear(),0.1);
        assertEquals(100, incident1.getValue(),0.1);
        assertEquals("Feb", incident1.getMonth());
        assertEquals("NE1", incident1.getPostcode());
	}

}
