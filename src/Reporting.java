package src;
import java.util.ArrayList;

/**
 * Info about all districts: includes methods to find the district with the largest
 * average crime value, the largest crime incident ever recorded and
 * a list of all incidents recorded with value higher than a given amount.
 * 
 * @author Austin_fung
 * @version Dec 2018
 */
public class Reporting 
{
	// The collection of districts
	private ArrayList<District> districtList;
	
	/**
	 * Constructor for objects of class Reporting
	 */
	public Reporting()
	{
		this.districtList = new ArrayList<>();
	}
	
	/**
	 * Add a district to the list
	 */
	public void addDistrict(District district)
	{
		districtList.add(district);
	}
	
	/**
	 * Retrieve the list of observatories
	 * @return ArrayList of observatories
	 */
	public ArrayList<District> getDistrictList()
	{
		return districtList;
	}
	
	/**
	 * Get the district with the largest average value incident
	 * @return district with the largest average value incident
	 */
	public District largestAvgIncident(int year)
	{
		double maxVal = 0.0;
		double currentVal = 0.0;
		District topDistrict = null;
		for(District currentDistrict : districtList)
		{
			currentVal = currentDistrict.findAverageValue(year);
			if(currentVal > maxVal)
			{
				topDistrict = currentDistrict;
				maxVal = currentVal;
			}
		}
		return topDistrict;
	}
	
	/**
	 * Highest value incident recorded
	 * @return highest value incident
	 */
	public Incident maxIncident()
	{
		Incident maxValIncident = null;
		Incident currentIncident = null;
		double maxVal = 0.0;
		double currentVal = 0.0;
		
		for(District currentDistrict : districtList)
		{
			currentIncident = currentDistrict.findBiggest();
			if(currentIncident != null)
			{
				currentVal = currentIncident.getValue();
				if(currentVal > maxVal)
				{
					maxValIncident = currentIncident;
					maxVal = currentVal;
				}
			}
		}
		return maxValIncident;
	}
	
	/**
	 * All incidents bigger than given value
	 * @return ArrayList of incidents bigger than given value
	 */
	public ArrayList<Incident> allIncidentsBiggerThan(double maxValue)
	{
		ArrayList<Incident> bigList = new ArrayList<>();
		for(District currentDistrict : districtList)
		{
			bigList.addAll(currentDistrict.crimesHigherThan(maxValue));
		}
		return bigList;
	}
}
