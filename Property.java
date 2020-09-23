package Assignment4;

/**
 * A class for creating property objects
 * @author Moe Diakite
 *
 */
public class Property { //definition of Property class
	private String propertyName;  //to hold the property's name
	private String city;		  //to hold the name of the city where the property is located
	private String owner;		  //to hold the owner's name
	private double rentAmount;	  //to hold the cost of rent of a property
	private Plot plot;			  //to hold a reference to a plot object
	
	/**
	 * no arg constructor
	 */
	public Property() {	//default constructor
	}
	
	/**
	 * 
	 * @param propArg, an instance of property
	 */
	public Property(Property propArg) {	//copy constructor
		this(propArg.getPropertyName(),propArg.getCity(),propArg.getRentAmount(), propArg.getOwner()); //calls overloaded constructor
	}
	
	/**
	 * 
	 * @param propertyName the name of property
	 * @param city, the city the property is located
	 * @param rentAmount, cost of rent
	 * @param owner, owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) { //constructor that accepts 4 arguments
		this(propertyName, city, rentAmount, owner, 0, 0, 0, 0);  //calls overloaded constructor to instantiate a property object with passed values
	}
	
	/**
	 * 
	 * @param propertyName, property name
	 * @param city, city property is located
	 * @param rentAmount, cost of rent
	 * @param owner, owner's name
	 * @param x, x coordinate of plot object inside property instance
	 * @param y, y coordinate of plot object inside property instance
	 * @param width, width of the plot inside property
	 * @param depth, depth of the plot inside property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) { //8 arg constructor
		this.propertyName = propertyName; //creates instance of a property by using parameter values of the constructor
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * 
	 * @return city field
	 */
	public String getCity() { //returns the city name
		return city;
	}
	/**
	 * 
	 * @param city, where property is located
	 */
	public void setCity(String city) { //sets the city's name
		this.city = city;
	}
	
	/**
	 * 
	 * @return name of the property
	 */
	public String getPropertyName() { //returns the property's name
		return propertyName;
	}
	
	/**
	 * 
	 * @param propertyName, name of the property
	 */
	public void setPropertyName(String propertyName) { //sets the property's name	
		this.propertyName = propertyName;
	}
	
	/**
	 * 
	 * @return cost of rent
	 */
	public double getRentAmount() {  //returns the cost of rent value
		return rentAmount;
	}
	
	/**
	 * 
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) { //sets the cost of rent amount
		this.rentAmount = rentAmount;
	}
	
	/**
	 * 
	 * @return a copy of plot member field
	 */
	public Plot getPlot() { //returns deep copy field reference variable to maintain strong encapsulation
		Plot p = new Plot(plot);
		return p;
	}
	
	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param width of plot instance
	 * @param depth of plot instance
	 * @return a new instance of plot
	 */
	public Plot setPlot(int x, int y, int width, int depth) { //declares and initializes a plot object
		Plot copyPlot;
		plot = new Plot();
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		copyPlot = new Plot(plot); //calling plot class copy constructor
		return copyPlot;
	}
	
	/**
	 * 
	 * @return owner's name
	 */
	public String getOwner() { //returns the owner's name
		return owner;
	}
	
	/**
	 * 
	 * @param owner of property
	 */
	public void setOwner(String owner) { //sets the owner's name
		this.owner = owner;
	}
	
	/**
	 * @return string containing attributes values of property instance
	 */
	public String toString() { //overrides toString method from object class and returns a string containing the field values of the property
		return "Property Name: "+propertyName + "\n Located in " + city + "\n Belonging to: " + owner + "\n Mortgage Amount: " +
		String.format("%.1f", rentAmount);
	}

}
