package Assignment4;

/**
 * A class called ManagementCompany, that accepts input operates on the input and returns values or sets
 * variables that may be accessed with getters
 * @author Moe Diakite
 *
 */

public class ManagementCompany { //definition of Management Company class
	private String name; // hold name of company
	private final int MAX_PROPERTY = 5; // constant field that contains maximum amount of properties that can be hold by the properties array
	private double mgmFeePer; // fee percentage per company
	private Property[] properties; // to contain a list of properties
	private String taxID; // hold the tax id number
	private final int MGMT_WIDTH = 10; //total width of area that a company's properties can encompass
	private final int MGMT_DEPTH = 10; //total depth of area that a company's properties can encompass
	private Plot plot; //holds an instance of plot object
	private  int count = 0; // to hold the current number of properties in the properties array
	private double totalManagementFee; //to hold the total management fee of all the properties in the properties array
	
	/**
	 * A default constructor
	 */
	public ManagementCompany() { //no arg constructor that creates an isntance of properties array and an instance of plot object
		properties = new Property[MAX_PROPERTY];
		plot = new Plot();
	}
	/**
	 * Three arg constructor that calls overloaded constructor using the three passed arguments
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) { //3 arg constructor that invokes overloaded constructor and passes in arguments along with default coordinate
		this(name, taxID, mgmFee, 0, 0, 10, 10); //calling overloaded constructor with default coordinate values
	}
	/**
	 * 7 arg constructor that initializes attributes with passed arguments and creates an new instance of the class
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) { //7 arg constructor to create instance of company that is initialized with parameter values
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee/100;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * Copy constructor that creates a new instance of the class based on the values of an already existing instance 
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) { //copy constructor that creates new company instance by using attributes from an already existing company
		ManagementCompany anotherCompany = new ManagementCompany(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer);
		
	}
	/**
	 * Adds the passed parameter to the properties list and returns the current number of properties in the array if successful
	 * @param anotherProperty
	 * @return -1 -2 -3 -4 or current number of properties inside properties array
	 */
	public int addProperty(Property anotherProperty) { //adds the parameter object to the properties array
		if(anotherProperty == null) { //if passed object is null return -1
			return -1;
		}
	
		 if(count >= MAX_PROPERTY) { //compares current number of properties in properties array, if array is full, return -2
			 return -2; 
		 }
			
		 
		 if(plot.encompasses(anotherProperty.getPlot()) == false) { //returns - 3 if user attempts to add an jnstance of property that is not within the encompassing range of company
			 return -3;
		 }
			
		 for(int i = 0; i < properties.length; i++) { //loops through properties array to check if parameter property overlaps any property already in the array
				if(properties[i] != null && properties[i].getPlot().overlaps(anotherProperty.getPlot()) && properties[i] != anotherProperty) {
					//properties[count++] = anotherProperty;
					return -4;
				}	    
			}

		 properties[count] = anotherProperty; //if the three previous conditions are all false, property instance is added to the array and the number of properties is returned
		 return count++; //increments count before returning, number of elements in array is always one more than current placement of last element
		
	}
	/**
	 * Creates a new instances of class based on passed parameters, and returns the current number of instances inside the properties array if successful
	 * @param propertyName, the name of the property
	 * @param city, the name of the city
	 * @param rent, the cost of rent
	 * @param owner, the name of the owner 
	 * @return -1 -2 -3 -4 or current number of properties in array
	 */
	public int addProperty(String propertyName, String city, double rent, String owner) { //overloaded addProperty that uses parameter values to create a new property and add to the array
		Property anotherProperty = new Property(propertyName, city, rent, owner); //with default x y width and depth fields
		if(anotherProperty == null) { 
			return -1;
		 }
	
		 if(count >= MAX_PROPERTY) {
			 return -2; 
		 }
			
		 
		 if(plot.encompasses(anotherProperty.getPlot()) == false) {
			 return -3;
		 }
			
		 for(int i = 0; i < properties.length; i++) {
				if(properties[i] != null && properties[i].getPlot().overlaps(anotherProperty.getPlot()) && properties[i] != anotherProperty) {
					properties[count++] = anotherProperty;
					return -4;
				}	    
	   }
		 properties[count++] = anotherProperty;
		 return count;
	 }
	/**
	 * Creates and adds a new property instance to the array based on passed parameter values
	 * @param propertyName, property's name
	 * @param city, name of city
	 * @param rent, cost of rent
	 * @param ownerName, the owner's name
	 * @param x, the x coordinate for the plot in property
	 * @param y, the y coordinate for the plot in property
	 * @param width, width of the property's plot
	 * @param depth, depth of the property's plot
	 * @return -1 or -2 or -3 or - 4 or current number of properties in array
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, 
			int depth) { //8 arg overloaded version of addProperty, with passed values for coordinates as well
		Property property = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		if(property == null) 
			return -1;
	
		 if(count >= MAX_PROPERTY) 
			return -2;
		 
		 if(plot.encompasses(property.getPlot()) == false) {
			 return -3;
		 }
				
		 
		 for(int i = 0; i < properties.length; i++) {
				if(properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
					properties[count++] = property;
					return - 4;
				}	    
			}
		 
		 properties[count++] = property;
		 return count;
		
	}
	
	/**
	 * Method that returns the total rent amount
	 * @return total rent
	 */
	public double totalRent() { //returns the total cost of rent of all properties inside the properties array
		double total = 0; //to contain the total rent amount
		for(int i = 0; i < properties.length; i++) { //loops through the list, makes sure element is not null, retrieves cost of rent
			if(properties[i] != null) {
			total += properties[i].getRentAmount(); //retrieves and adds cost of rent to total
		}
		}
		totalManagementFee = total * mgmFeePer; //multiplies total cost by the fee percentage in order to get total fee charged by the company
		return total;
	}

	/**
	 * 
	 * @return total mamangement fee
	 */
	public double getTotalMgmFee() { //returns total fee
		return totalManagementFee;
	}
	
	/**
	 * 
	 * @return string representation of property with the highest cost of rent
	 */
	public String maxRentProp() { //returns the property that has the highest rent
		String highest = "";;
		highest = displayPropertyIndex(maxPropertyIndex());
		return highest;
	}
	
	/**
	 * A method that cycles through the properties array to retrieve the index of the element with the highest cost of rent
	 * @return index of property with highest rent cost
	 */
	private int maxPropertyIndex() { //returns the index of the property that has the highest rent
		int index = 0;
		double amount = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i].getRentAmount() > amount) {
				amount = properties[i].getRentAmount();
				index = i;
			}
		}
		return index;
	}
	/**
	 * A method that displays the property at the given index
	 * @param indx, the index of the property instance to retrieve from the array
	 * @return
	 */
	private String displayPropertyIndex(int indx) { //displays the string representation of the property instance located at the index value of passed parameter
		return properties[indx].toString(); //uses overloaded toString method to return properties object in string form
	}
	
	/**
	 * 
	 * @return name
	 */
	public String getName() { //returns the name of the company
		return name;
	}
	
	/**
	 * 
	 * @return max amount of properties that array can hold
	 */
	public int getMAX_PROPERTY() { //returns the maximum amount of elements that can be contained in properties array
		return MAX_PROPERTY;
	}
	
	/**
	 * 
	 * @return a plot instance
	 */
	public Plot getPlot() { //returns a deep copy of the plot reference field
		Plot p = new Plot(plot); //uses copy constructor of plot class
		return p; //returning of deep copy allows for maintenance of strong encapsulation of the class
	}
	
	/**
	 * Overloaded method from object class that returns string representation of the class
	 * @return field values of the class as a string
	 */
	public String toString() { //overloaded version of object class toString method, that returns the field values of an instance of management company
		String s = "";
		for(int i = 0; i < properties.length; i++) {
			s += "\n Property Name: "+ properties[i].getPropertyName() + "\n  Located "
					+ "in "+ properties[i].getCity() + "\n  Belonging to: "+ properties[i].getOwner() + "\n  Mortgage Amount: " 
					+ String.format("%.1f",properties[i].getRentAmount());
		}
		return "List of the properties for "+ name + ", taxID: "+ taxID +  "\n" + s + "\n\ntotal management Fee: "
		+ String.format("%.1f", totalManagementFee); //format to ensure that only one decimal place is displayed
	}
}
