/**
 * The class main1 contains the airportSimulation method which generates the 
 * results of the simulation.
 * 
 * @author Luke Newman 
 * 		10/13/2016
 *
 */
public class Main {
	/**
	 * airportSimulation(...) runs a simulation with the input information and 
	 * 		 returns the results of the simulation in a string format.
	 * 
	 * @param landingTime
	 * 		an integer that is the time it takes for a plane to land
	 * @param takeOffTime
	 * 		an integer that is the time it takes for a plane to takeoff
	 * @param landingProb
	 * 		the probability (0.0 - 1.0) that a plane will arrive in any given minute
	 * @param takeOffProb
	 * 		the probability (0.0 - 1.0) that a plane is scheduled to takeoff in any given minute
	 * @param fuelRemaining
	 * 		the amount of time that a plane can fly around waiting to land without crashing
	 * @param runways
	 * 		the number of runways available at an airport
	 * @param totalTime
	 * 		the total number of simulation minutes
	 * @precondition
	 * 		arguments are given in correct type and range
	 * @return
	 * 		returns a String with the input and generated output information
	 */
	public static String airportSimulation(int landingTime, int takeOffTime, 
			double landingProb, double takeOffProb, int fuelRemaining, int runways, int totalTime){
		// Initialize the arrival and takeoff queues
		IntQueue arrivalQueue = new IntQueue(25);
		IntQueue takeOffQueue = new IntQueue(25);
		// Initialize a boolean source with the specified arrival and departure rates
		BooleanSource dispatch = new BooleanSource(landingProb, takeOffProb);
		// Check if runways input is out of range
		if (runways < 1)
			throw new IllegalArgumentException("Number of runways must be at least one.");
		// Initialize an array of runways 
		Runway[] runwaysArray = new Runway[runways];
		for (int i = 0; i < runways;i++){
			runwaysArray[i] = new Runway(landingTime, takeOffTime);
		}
		// Initialize an averager to keep track of numbers
		Averager waitTimes = new Averager();
		// Declare int variables that wil be used during the simulation
		int nextLanding;
		int nextTakeOff;
		int currentMinute;
		
		String output ="Minutes to land: " + landingTime + "\nMinutes to takeoff: " + 
		takeOffTime + "\nProbability of plane arrival during a minute: " + landingProb +
		"\nProbability of plane scheduled to depart during a minute:" + takeOffProb +
		"\nNumber of runways at airport: " + runways + "\nTotal simulation minutes: " + totalTime + "\n";
		// Check for invalid input values
		if (landingTime<=0 || takeOffTime<=0 || landingProb<0 || landingProb>1 || 
				takeOffProb<0 || takeOffProb>1 || totalTime<=0 || fuelRemaining<=0)
			throw new IllegalArgumentException("Values out of range. Time to land, Time to takeoff,"
					+ " fuel remaining and simulation time must be greater than 0.");
		
		for (currentMinute = 0; currentMinute < totalTime; currentMinute++){
			
			if (dispatch.queryLanding())
				arrivalQueue.add(currentMinute);
			if (dispatch.queryTakeOff())
				takeOffQueue.add(currentMinute);
			int i;
			// for loop is executed for each runway 
			for (i = 0; i < runwaysArray.length;i++){
				if (!runwaysArray[i].isBusy()){ 
					if (!arrivalQueue.isEmpty()){
						boolean crashTest = true;
						// while loop will be executed the first time and after a crash
						while (crashTest && !arrivalQueue.isEmpty()){
							nextLanding = arrivalQueue.remove();
							if ((currentMinute - nextLanding) < fuelRemaining){
								waitTimes.addLanding(currentMinute - nextLanding);
								runwaysArray[i].startRunwayForLanding();
								crashTest = false;
							}
							else {
								waitTimes.addCrash();
							}
						}
					}
				
					else if (!takeOffQueue.isEmpty()){
						nextTakeOff = takeOffQueue.remove();
						waitTimes.addTakeOff(currentMinute - nextTakeOff);
						runwaysArray[i].startRunwayForTakeOff();
					}
				}
				
				runwaysArray[i].reduceRemainingTime();
			}
		}
		// Examine the rest of the arrival queue after the simulation 
		// to see whether there were any crashes.
		while (!arrivalQueue.isEmpty()){
			int examine = arrivalQueue.remove();
			if ((totalTime - examine) >= fuelRemaining)
				waitTimes.addCrash();
		}
		
		output += "\nNumber of planes that landed: " + waitTimes.howManyLandings() +
				"\nNumber of planes that took off: " + waitTimes.howManyTakeOffs() +
				"\nAverage wait time for arrival: " + waitTimes.landingAverage() +
				"\nAverage wait time for take off: " + waitTimes.takeOffAverage() +
				"\nNumber of crashes: " + waitTimes.howManyCrashes();
		return output;
		
		
		
	}

}
