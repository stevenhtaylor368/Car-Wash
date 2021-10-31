/*
 * Author: Steven Taylor
 * Version: 3/31/2019
 * 
 * This class is used for testing and running the car wash simulation
 * the requirement is that new carWash objects are created and different
 * parameters are sent to the respective run method within the class. 
 */

public class CarWashManager {
	public static void main ( String [ ] args ) {
		CarWash cw1 = new CarWash(3) ;
		cw1.run(60, .1);
		cw1.printData();
		
		cw1.run(120, .25);
		cw1.printData();
		
		CarWash cw2 = new CarWash(10) ;
		cw2.run(240, .5);
		cw2.printData();
		
		cw2.run(360, .75);
		cw2.printData();
		CarWash cw3 = new CarWash(2);
		cw3.run(720, .001);
		cw3.printData();
		
		cw3.run(1440, .0025);
		cw3.printData();
		}

}
