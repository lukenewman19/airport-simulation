/**
 * The class BooleanSource contains the arrival rate and departure rate for an airport. 
 * It is inquired every simulation minute to determine whether a plane has arrived for 
 * landing or if a plane is scheduled to takeoff.
 * 
 * @author Luke Newman
 * 		10/13/2016
 *
 */
public class BooleanSource {
	private double landingProbability;
	private double takeOffProbability;
	/**
	 * The constructor for BooleanSource takes two arguments that will be the 
	 * arrival rate and the departure rate. 
	 * 
	 * @param landingProb
	 * 		the arrival rate for an airport
	 * @param takeOffProb
	 * 		the departure rate for an airport
	 * @precondition
	 * 		arguments must be double values in between 0.0 and 1.0
	 * @postcondition
	 * 		a BooleanSource has been initialized with the specified rates
	 */
	public BooleanSource(double landingProb, double takeOffProb){
		if (landingProb < 0 || landingProb > 1)
			throw new IllegalArgumentException("Illegal landing probability: " + landingProb);
		if (takeOffProb < 0 || takeOffProb >1)
			throw new IllegalArgumentException("Illegal takeoff probability: " + takeOffProb);
		landingProbability = landingProb;
		takeOffProbability = takeOffProb;
	}
	/**
	 * queryLanding() generates a random number and compares this number to the arrival 
	 * rate in order to simulate the actual arrival rate of an airport. The method then 
	 * returns a boolean to indicate whether a plane has arrived to land. 
	 * 
	 * @return
	 * 		returns true if a plane has arrived
	 * 		returns false if a plane has not arrived
	 */
	public boolean queryLanding(){
		return (Math.random() < landingProbability);
	}
	/**
	 * queryTakeOff() generates a random number and compares this number to the departure 
	 * rate in order to simulate the actual departure rate of an airport. The method then 
	 * returns a boolean to indicate whether a plane is ready to takeoff or not. 
	 * 
	 * @return
	 * 		returns true if a plane is ready to takeoff
	 * 		returns false if a plane is not ready to takeoff
	 */
	public boolean queryTakeOff(){
		return (Math.random() < takeOffProbability);
	}

}