/*
 * Author: Steven Taylor
 * Version: 3/25/2019
 * 
 *A class that is a representation of a customers car
 *A wash type is randomly selected and the time it takes to wash the car.
 *
 *Required: 
 *var (CarWashOption)[option] contains randomly chosen wash option for the customers car
 *var (int)[washTimeLeft] contains the time remaining to wash the car
 */
public class Car {
	CarWashOption option = CarWashOption.getRandomOption();
	int washTimeLeft = option.getTime();
	/*
	 * @param option the randomly chosen option for the cars wash type
	 */
	public Car(CarWashOption option) {
		this.option = option;
	}
	/*
	 * Reduces the amount of wash time remaining by decrementing by one from the 
	 * washTimeLeft variable
	 */
	public void reduceRemainingTime()
	   {

	        washTimeLeft--;

	   }
	/*
	 * @return option returns the option of the cars randomly selected option
	 */
	public CarWashOption getOption() {
		return option;
	}
	/*
	 * @return washTimeLeft returns the value of the wash time remaining for the car.
	 */
	public int getWashTimeLeft() {
		return washTimeLeft;
	}

}
