/*
 * Author: Steven Taylor
 * Version: 3/31/2019
 * 
 * This class simulates a car wash and determines data based upon the number
 * of bays, cycles and a car's arrival probability. The car wash bays are represented
 * by an ArrayList and cars are placed in a Queue
 */

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class CarWash {
	int numberBays;
	private ArrayList<Queue<Car>> bays;
	private int[] maxLength;
	private Random gen;
	private int cycles;
	private double arrivalProb;
	private int totalCarsWashed =0;
	private double totalRevenue =0;
	private int totalCars = 0;
	DecimalFormat two = new DecimalFormat("0.00");
/*
 * @param numberBays the number of bays the carWash has
 */
	public CarWash(int numberBays) {
		bays = new ArrayList<>();
		maxLength = new int[numberBays];
		for (int i = 0; i < numberBays; i++) {
			bays.add(new ArrayDeque<Car>());
			maxLength[i] = 0;
		}
		gen = new Random();
	}
/*
 * @param cycles the number of time steps to execute 
 * @param arrivalProb the probability that a car will arrive
 */
	public void run(int cycles, double arrivalProb) {
		this.cycles = cycles;
		this.arrivalProb = arrivalProb;
		totalCars = 0;
		for (int i = 0; i < cycles; i++) {
			timeManager();
		}
	}
/*
 * this method reduces the time element in the car queue
 * once the time reaches 0 the car is removed from the bay
 * the total number of cars washed is incremented by one
 * the revenue is increased by the current car in the queue's cost
 * if the random number is less than the probability a car is added to the 
 * queue.
 * I would like to acknowledge the example Dr. Sheaffer provided for the logic of
 * this method
 */
	private void timeManager() {
		Car current;
		for (Queue<Car> bay : bays) {
			if (!bay.isEmpty()) {
				current = bay.element();
				current.reduceRemainingTime();
				if (current.getWashTimeLeft() == 0) {
					bay.remove();
					totalCarsWashed++;
					totalRevenue = current.option.getCost() + totalRevenue;
				}
			}
		}
		if (gen.nextDouble() < arrivalProb) {
			addCar();
		}
	}
/*
 * adds a car to the bay
 * I would like to acknowledge the example Dr. Sheaffer provided for the logic of
 * this method
 */
	private void addCar() {

		int shortLine = 0;
		for (int i = 1; i < bays.size(); i++) {
			if (bays.get(i).size() < bays.get(shortLine).size()) {
		
				shortLine = i;
			}
		}
		bays.get(shortLine).add(new Car(CarWashOption.getRandomOption()));
		if (bays.get(shortLine).size() > maxLength[shortLine]) {
			maxLength[shortLine]++;
		}
	}
/*
 * prints out: the number of time steps, num wash bays, arrival probability
 * Maximum length each bay reached in terms of size, the number of cars left in each bay
 * the total number of cars left in the queue, the total num of cars in the queue
 * the total number of cars washed, the amount of revenue the cycle generated.
 * 
 * 
 */
	public void printData() {
		System.out.println("----Begin Data Output---");
		System.out.println("Number of time steps :" + cycles);
		System.out.println("Number of car wash bays : " + bays.size());
		System.out.println("Probability of car arriving : " + arrivalProb);
		for (int i = 0; i < bays.size(); i++) {
			System.out.println("Maximum length bay " + (i+1) + " reached: " + maxLength[i]);
			System.out.println("Cars left in Bay " + (i+1) + " is : " + bays.get(i).size());
			totalCars = bays.get(i).size() + totalCars;
		}
		System.out.println("Cars left in Queue " + totalCars);
		totalCars = totalCarsWashed + totalCars;
		System.out.println("Total Cars that were in Queue " + totalCars);
		System.out.println("Total number of Cars washed is : " + totalCarsWashed);
		System.out.println("Total Revenue : " + two.format(totalRevenue));
		System.out.println("----End Data Output---");
	}

}
