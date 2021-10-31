/*
 * Author: Steven Taylor
 * Version: 3/25/2019
 * 
 * A enumerated class that contains different car wash options.
 * Car wash options are selected at random. 
 * Required: five types of options
 * variables: (int)time, (double)price, 
 * constructor ini fields
 * getters for ini variables
 */
import java.util.Random;

public enum CarWashOption {
	Basic(15, 2.75),
	Wash(20, 3.15),
	Standard(22, 3.75),
	Wax(30, 4.07),
	Premium(35, 5.25);
	
	private static CarWashOption[] vals = values();
	private static Random gen = new Random();
	
	private final int time;
	private final double cost;
	/*
	 * @param time the time it takes to wash a car based upon the type
	 * @param cost the cost for the type of wash associated with the type
	 */
	private CarWashOption(int time, double cost) {
		this.time = time;
		this.cost = cost;
	}
	/*
	 *@return time Retrieves the time variable
	 */
	public int getTime() {
		return time;
	}
	/*
	 * @return cost retrieves the cost variable
	 */
	public double getCost() {
		return cost;
	}
	/*
	 * @return returns the randomized option for the cars wash type based upon an int value
	 */
	public static CarWashOption getRandomOption() {
		return vals[(gen.nextInt(vals.length))];
	}
	
}
