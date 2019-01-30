package src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ReportingIO takes care of IO. 
 * 
 * Enter, via the console, the details of districts and crimes.
 * - Presents the user with a menu (printed to the console) of features: enter district data; 
 * enter incident data; provide monitoring statistics; or exit)
 * - Takes user input from the console to choose one of the menu features
 * - Allows user to input, via the console, the details of districts and incidents
 * - After executing one of the features, returns the user to the menu to choose another option
 * 
 * @author Austin_fung 
 * @version Dec 2018
 */
public class ReportingIO 
{
	private Scanner reader;
	private Reporting reporter;
	
	/**
	 * Create new scanner to read from terminal
	 */
	public ReportingIO()
	{
		reader = new Scanner(System.in);
		reporter = new Reporting();
	}
	
	/**
	 * main method sets up menu and calls appropriate methods, looping until q is chosen
	 */
	public static void main(String []s)
	{
		ReportingIO reportIO = new ReportingIO();
		// loop to offer choices
		boolean finished = false;
		char choice;
		
		reportIO.printWelcome();
		
		while(!finished)
		{
			reportIO.listChoices();
			choice = reportIO.getChoice();
			// could use switch / case statements here
			if(choice == 'd'){
				reportIO.inputDistricts();
			}
			else if(choice == 'i'){
				reportIO.inputIncidents();
			}
			else if(choice == 's'){
				reportIO.outputStats();
			}
			else if(choice == 'q'){
				finished = true;
			}
			else{
				System.out.println("Not an option, please try again.");
			}
		}
		reportIO.printGoodbye();
	}
	
	/**
	 * Print a welcome message
	 */
	public void printWelcome()
	{
		System.out.println("Welcome to the Crime Incident Reporting System");
		System.out.println("==============================================");
		System.out.println();
	}
	
	/**
	 * Print farewell message
	 */
	public void printGoodbye()
	{
		System.out.println("Thanks for using the Crime Incident Reporting System");
	}

	/**
	 * List the available choices
	 */
	public void listChoices()
	{
		System.out.println("Menu");
		System.out.println("----");
		System.out.println("D. Input districts");
		System.out.println("I. Input incident data for a district");
		System.out.println("S. Provide monitoring status");
		System.out.println("Q. Quit");
	}
	
	/**
	 * Return the character input at console, converted to lower case.
	 */
	public char getChoice()
	{
		System.out.println("Please enter your choice from the above options");
		
		String inputLine = reader.nextLine().trim().toLowerCase();
		char firstChar = inputLine.charAt(0);
		return firstChar;
	}
	
	/**
	 * Get a list of districts from terminal.
	 * Input is requested comma separated rather than one line at a time.
	 * If data is valid (no exception raised) then the new district is added to the list.
	 */
	public void inputDistricts()
	{
		System.out.println("Enter district name");
		System.out.println("Enter blank line to finish");
		boolean finished = false;
		while(!finished) 
		{
			String inputLine = reader.nextLine().trim();
			if(inputLine.isEmpty())
			{
				finished = true;
			}
			else
			{
				try {
					String name = inputLine.trim();
					reporter.addDistrict(new District(name));
				}
				catch(RuntimeException e) {
					System.out.println("Invalid data: " + e.getMessage() + "Please try again.");
				}
			}
		}	
	}
	
	/**
	 * Get a list of incidents for a given district. This could prompt the user for a specific district
	 * to add the crime data to, but the approach here is to list each district and ask for data specific to each one.
	 */
	public void inputIncidents()
	{
		for(District district : reporter.getDistrictList())
		{
			System.out.println("Enter incident details for district " + district.getName());
			System.out.println("Data must be comma separated: value, postcode, month, year");
			System.out.println("When finished (or if no data for this district), just hit enter.");
			
			boolean finished = false;
			while(!finished)
			{
				String inputLine = reader.nextLine().trim();
				if(inputLine.isEmpty())
				{
					finished = true;
				}
				else
				{
					String[] incidentDetail = inputLine.split(","); // split at commas
					try
					{
						double value = Double.parseDouble(incidentDetail[0].trim());
						String postcode = incidentDetail[1].trim();
						String month = incidentDetail[2].trim();
						int year = Integer.parseInt(incidentDetail[3].trim());
						
						district.addIncident(new Incident(value, postcode, month, year));
					}
					catch(NumberFormatException e)
					{
						System.out.println("Invalid data: " + e.getMessage() + "Please try again.");
					}
				}
			}
		}
	}
	
	/**
	 * Provide reporting stats: largest average crime value, largest value ever, 
	 * all crimes with value bigger than a given number. 
	 * Requests number for "incidents higher in value than" method using getMaxValInput() and year using getTheYear method.
	 */
	public void outputStats()
	{
		double maxVal = getMaxValInput();
		int theYear = getTheYear();
		
		District topDistrict = reporter.largestAvgIncident(theYear);
		if(topDistrict != null)
		{
			System.out.println("Largest average incident value recorded in " + theYear + " is " + 
					topDistrict.findAverageValue(theYear) + " at " + topDistrict.getName());
		}
		else
		{
			System.out.println("No incidents recorded");
		}
		
		Incident topIncident = reporter.maxIncident();
		if(topIncident != null)
		{
			System.out.println("Largest ever incident is " + topIncident.getValue());
		}
		
		ArrayList<Incident> bigList = reporter.allIncidentsBiggerThan(maxVal);
		if(bigList != null)
		{
			System.out.println("Incidents bigger than " + maxVal + ":");
			for(Incident incident : bigList)
			{
				System.out.println(incident.getValue() + ", " + incident.getPostcode() +
						", " + incident.getMonth() + ", " + incident.getYear());
			}
		}
		else
		{
			System.out.println("No incidents recorded bigger than " + maxVal + ".");
		}
	}
	public double getMaxValInput()
	{
		boolean done = false;
		double maxInput = 0;
		while(!done) 
		{
			System.out.println("Please enter the maximum value");
			try
			{
				maxInput = Double.parseDouble(reader.nextLine().trim());
				done = true;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid input. Try again");
			}
		}
		return maxInput;
	}
	public int getTheYear()
	{
		boolean done = false;
		int theYear = 0;
		while(!done)
		{
			System.out.println("Please enter the year for average report");
			try
			{
				theYear = Integer.parseInt(reader.nextLine().trim());
				done = true;
			}
			catch(NumberFormatException e) 
			{
				System.out.println("Invalid input. Try again");
			}
		}
		return theYear;
	}
}
