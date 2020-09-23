package Assignment4;

/**
 * A class for creating plot objects
 * @author Moe Diakite
 *
 */
public class Plot { //definition of Plot class
	private int x; // holds x coordinate of upper left corner
	private int y; // holds y coordinate of upper left corner
	private int width; // holds width of plot object
	private int depth; // hold depth of plot object
	
	/**
	 * Default constructor
	 */
	public Plot() { //default constructor
	}
	/**
	 * A copy constructor that accepts an instance of a plot 
	 * @param plotArg, an intance of a plot 
	 */
	public Plot(Plot plotArg) { //copy constructor
		this(plotArg.getX(), plotArg.getY(), plotArg.getWidth(), plotArg.getDepth()); //calls the overloaded constructor and passes in value from plotArg
	}
	/**
	 * A 4 arg constructor that creates an instance of the class using parameter values
	 * @param x coordinate
	 * @param y coordinate
	 * @param width of plot
	 * @param depth of plot
	 */
	public Plot(int x, int y, int width, int depth) { // 4 arg constructor that creates plot instance by using parameter values
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * 
	 * @param plot
	 * @return true if overlaps and false if not
	 */
	public boolean overlaps (Plot plot) { //method that checks if any two plot locations overlap
		
		if(x <plot.getX() && plot.getX()< x + width && y + depth <plot.getY() && plot.getY()< y || 
				x < plot.getX() + plot.getWidth() && plot.getX() + plot.getWidth()  < x + width && y + depth < plot.getY() && plot.getY() < y)
			return true;
		  
		 if(x < plot.getX() + plot.getWidth() && plot.getX() + plot.getWidth()  < x + width && y + depth < plot.getY() && plot.getY() < y)
			 return true;
		 
		 if(x < plot.getX() + plot.getWidth()  && plot.getX() + plot.getWidth() < x + width && y + depth < plot.getY() + plot.getDepth())
			 return true;
		 
		 if(x <plot.getX() && plot.getX() < x + width && y + depth < plot.getY() + plot.getDepth() && plot.getY() + plot.getDepth() < y)
			 return true;
		 
		 return false;
		
		}
	  /**
	   * 
	   * @param plot
	   * @return true if plot instance encompasses plot parameter, false if not
	   */
	  public boolean encompasses(Plot plot) //method that checks to see if two plot instances encompass one another
       {
             if(plot.getX() >= x && plot.getX() <= x + width)
            	 if(plot.getY() >= y && plot.getY() <= y + depth)
            		 if(plot.getX() + plot.getWidth() >= x && plot.getX() + plot.getWidth() <= x + width)
            			 if(plot.getY() + plot.getDepth() >= y && plot.getY() + plot.getDepth() <= y + depth)
            				 return true;
             return false;
       }
	/**
	 * 
	 * @return x coordiante
	 */
	public int getX() { //returns x coordinate
		return x;
	}
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) { //sets x coordinate
		this.x = x;
	}
	/**
	 * 
	 * @return y coordinate
	 */
	public int getY() { //returns y coordinate
		return y;
	}
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) { // sets y coordinate
		this.y = y;
	}
	/**
	 * 
	 * @return width of plot
	 */
	public int getWidth() { //returns width
		return width;
	}
	/**
	 * 
	 * @param width of the plot
	 */
	public void setWidth(int width) { //sets width
		this.width = width;
	}
	/**
	 * 
	 * @return depth of plot
	 */
	public int getDepth() { //returns depth
		return depth;
	}
	/**
	 * 
	 * @param depth of the plot
	 */
	public void setDepth(int depth) { //sets depth
		this.depth = depth;
	}
	/**
	 * Overloaded version of method from Object class
	 * @return string containing values of attributes of plot instance
	 */
	public String toString() { //overrides object class toString method, returns string representation of plot object fields
		return "Upper left: (" + x + ","+ y + "); Width: "+ width + " Depth: "+ depth;
	}

}
