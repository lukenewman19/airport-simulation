/**
 * The class Runway represents a runway at an airport that is available for landing or takeoff
 * if it not already in use. 
 * 
 * @author Luke Newman
 * 		10/13/2016
 *
 */
public class Runway {
	private int minutesForLanding;
	private int minutesForTakeOff;
	private int runwayTimeLeft;
	/**
	 * The constructor for the Runway class uses two arguments, landingTime and 
	 * takeOffTime, to instantiate a Runway object.
	 * 
	 * @param landingTime
	 * 		an integer that is the amount of time it takes for a plane to land.
	 * @param takeOffTime
	 * 		an integer that is the amount of time it takes for a plane to takeoff.
	 * @postcondition
	 * 		a Runway object has been initialized with the instance variables, 
	 * 		minutesForLanding and minutesForTakeOff, being initialized with 
	 * 		the arguments.
	 */
	public Runway(int landingTime, int takeOffTime){
		minutesForLanding = landingTime;
		minutesForTakeOff = takeOffTime;
	}
	/**
	 * isBusy() is an accessor method to inform whether the runway is busy or not.
	 * 
	 * @return
	 * 		returns true if the runway is in use
	 * 		returns false if the runway is available
	 */
	public boolean isBusy(){
		return (runwayTimeLeft > 0);
	}
	/**
	 * reduceRemainingTime() will tell the runway another minute has passed.
	 * @postcondition
	 * 		if the runway is in use, the amount of time left for a plane to land
	 * 		or to takeoff will be decremented by one.
	 */
	public void reduceRemainingTime(){
		if (runwayTimeLeft > 0)
			runwayTimeLeft--;
	}
	/**
	 * startRunwayForLanding() starts a landing by setting the time left that the runway will
	 * be in use and not available.
	 * 
	 * @precondition
	 * 		runway must not be in use, i.e. runwayTimeLeft = 0
	 * @postcondition 
	 * 		if runway was available for use, a landing has started by setting 
	 * 		runwayTimeLeft = minutesForLanding
	 */
	public void startRunwayForLanding(){
		if (runwayTimeLeft > 0)
			throw new IllegalStateException("Runway is busy");
		runwayTimeLeft = minutesForLanding;
	}
	/**
	 * startRunwayForTakeOff() starts a takeoff by setting the time left that the runway will
	 * be in use and not available.
	 * 
	 * @precondition
	 * 		runway must not be in use, i.e. runwayTimeLeft = 0
	 * @postcondition 
	 * 		if runway was available for use, a takeoff has started by setting 
	 * 		runwayTimeLeft = minutesForTakeOff
	 */
	public void startRunwayForTakeOff(){
		if (runwayTimeLeft > 0)
			throw new IllegalStateException("Runway is busy");
		runwayTimeLeft = minutesForTakeOff;
	}

}
