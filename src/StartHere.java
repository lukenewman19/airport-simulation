import java.awt.EventQueue;

/** StartHere class
*
* Instantiates the user interface (View)
* 
* @author 	Luke Newman copied from Sue Fitzgerald's StartHere.java
* 			10/13/2016
 */

public class StartHere {
	/** main
	 * Invokes user interface.  Prints stack on exception.
	 * @param s - unused
	 */
	public static void main(String[] s) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationUI frame = new SimulationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}

