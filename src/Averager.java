/**
 * The Averager class keeps track of the number of planes landed, planes departed, crashes,
 * and the average wait times for landings and takeoffs. 
 * 
 * @author Luke Newman
 * 		10/13/2016
 *
 */
public class Averager {
	private int landingCount;
	private int takeOffCount;
	private double landingSum;
	private double takeOffSum;
	private int crashes;
	/**
	 * The constructor to initialize an Averager object.
	 * 
	 * @postcondition
	 * 		all instance variables are set to 0
	 */
	public Averager(){
		landingCount = 0;
		takeOffCount = 0;
		landingSum = 0;
		takeOffSum = 0;
		crashes = 0;
	}
	/**
	 * addLanding(double value) adds a landing to the landing count and adds its wait time 
	 * to a total sum of wait times.  
	 * 
	 * @param value
	 * 		the time the plane had to wait before landing
	 * @postcondition
	 * 		the landing count has been incremented by 1 and the total wait time for all 
	 * 		planes landed has been incremented by value.
	 */
	public void addLanding(double value){
		if (landingCount == Integer.MAX_VALUE)
			throw new IllegalStateException("Too many numbers.");
		landingCount++;
		landingSum += value;
	}
	/**
	 * addTakeOff(double value) adds a takeoff to the takeoff count and adds its wait time 
	 * to a total sum of wait times.  
	 * 
	 * @param value
	 * 		the time the plane had to wait before taking off
	 * @postcondition
	 * 		the takeoff count has been incremented by 1 and the total wait time for all 
	 * 		planes departed has been incremented by value.
	 */
	public void addTakeOff(double value){
		if (takeOffCount == Integer.MAX_VALUE)
			throw new IllegalStateException("Too many numbers.");
		takeOffCount++;
		takeOffSum += value;
	}
	/**
	 * landingAverage() calculates the average wait time for landings and returns it
	 * 
	 * @return
	 * 		returns the average wait time for landings
	 */
	public double landingAverage(){
		if (landingCount == 0)
			return Double.NaN;
		else 
			return landingSum/landingCount;
	}
	/**
	 * takeOffAverage() calculates the average wait time for takeoffs and returns it
	 * 
	 * @return
	 * 		returns the average wait time for takeoffs
	 */
	public double takeOffAverage(){
		if (takeOffCount == 0)
			return Double.NaN;
		else 
			return takeOffSum/takeOffCount;
	}
	/**
	 * howManyLandings() is an accessor method that gives the landing count
	 * 
	 * @return
	 * 		returns the landing count
	 */
	public int howManyLandings(){
		return landingCount;
	}
	/**
	 * howManyTakeOffs() is an accessor method that gives the takeoff count
	 * 
	 * @return
	 * 		returns the takeoff count
	 */
	public int howManyTakeOffs(){
		return takeOffCount;
	}
	/**
	 * addCrash() increments the number of crashes by one
	 * @postcondition
	 * 		a crash has been added 
	 */
	public void addCrash(){
		crashes++;
	}
	/**
	 * howManyCrashes() is an accessor method that gives the number of crashes in the 
	 * simulation.
	 * 
	 * @return
	 * 		returns the number of crashes that occurred
	 */
	public int howManyCrashes(){
		return crashes;
	}

}