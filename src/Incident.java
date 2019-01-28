package src;
/**
 * Incident: store information about value, post code, date of crime, position and year of an earthquake event
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class Incident 
{
	// instance variables
	private double value; // loss associated with the crime
	private String postcode; // not expecting validity checks
	private String month;
	private int year;
	
	/**
	 * Constructor for objects of class Incident
	 */
	public Incident(double value, String postcode, String month, int year)
	{
		// initialise instance variables
		this.value = value;
		this.postcode = postcode;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Get the value
	 * 
	 * @return value
	 */
	public double getValue()
	{
		return value;
	}
	
	/**
	 * Get the postcode
	 * 
	 * @return postcode
	 */
	public String getPostcode()
	{
		return postcode;
	}
	
	/**
	 * Get the month
	 * 
	 * @return month
	 */
	public String getMonth()
	{
		return month;
	}
	
	/**
	 * Get the year
	 * 
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}
}
