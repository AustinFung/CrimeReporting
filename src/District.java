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
	
	/**
	 * Add an incident to the list
	 */
	public void addIncident(Incident incident)
	{
		incidentList.add(incident);
	}
	
	/**
	 * Get name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * get the list of incidents
	 */
	public ArrayList getIncidentList()
	{
		return incidentList;
	}
	
	/**
	 * Retrieve largest value incident
	 * @return incident with biggest value
	 */
	public Incident findBiggest() 
	{
		double maxValue = 0.0;
		Incident highestValueIncident = null;
		
		
		return highestValueIncident;
	}
}
