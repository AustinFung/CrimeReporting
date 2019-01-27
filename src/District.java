import java.util.ArrayList;
import java.util.Iterator;

/**
 * District: Records the name of the district, list of incidents
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class District 
{
	// instance variables
	private String name; // name of the district
	private ArrayList<Incident> incidentList; // list of crime incidents
	
	/**
	 * Constructor for objects of class District
	 */
	public District(String name)
	{
		// initialise instance variables
		this.name = name;
		this.incidentList = new ArrayList<>();
	}
	

}
