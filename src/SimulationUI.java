import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
/**
 * The class SimulationUI creates the user interface to interact with the 
 * airport simulation method.  
 * 
 * @author Luke Newman largely copied from Sue Fitzgerald's UI.java
 * 			10/13/2016
 *
 */

public class SimulationUI extends JFrame{
	
	
		private JPanel inputPane;	
		
		private JTextField landingTimeTextField;
		private JTextField takeOffTimeTextField;
		private JTextField arrivalRateTextField;	
		private JTextField departureRateTextField;
		private JTextField fuelRemainingTextField;
		private JTextField numOfRunwaysTextField;	
		private JTextField simulationRuntimeTextField;
		private JTextField msgTextField;
		
		private JButton runSimulationButton;	
		private JButton clearButton;	

		// output panel
		private JPanel contentPane;  
		private JTextArea displayResults;
		/**
		 * The constructor of SimulationUI instantiates the user interface that will be used
		 * to run simulations.
		 */
		public SimulationUI() {
			
			super("Airport Simulation");
			
			

			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 500);
			
			contentPane = new JPanel();
			contentPane.setBorder(new LineBorder(new Color(112, 12, 102), 4, true));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			// Default font for the user interface
			Font defaultFont = new Font("Arial", Font.PLAIN, 12);
			
			inputPane = new JPanel();		
			inputPane.setBorder(new LineBorder(new Color(112, 12, 102), 1, true));
			inputPane.setBounds(10, 32, 974, 220);
			contentPane.add(inputPane);
			inputPane.setLayout(null);
			
			JLabel lblTimeToLand = new JLabel("Time to Land (>0)");
			lblTimeToLand.setFont(defaultFont);
			lblTimeToLand.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTimeToLand.setBounds(16, 11, 140, 14);
			inputPane.add(lblTimeToLand);
			
			JLabel lblTimeToTakeOff = new JLabel("Time to Takeoff (>0)");
			lblTimeToTakeOff.setFont(defaultFont);
			lblTimeToTakeOff.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTimeToTakeOff.setBounds(16, 36, 140, 14);
			inputPane.add(lblTimeToTakeOff);
			
			JLabel lblArrivalRate = new JLabel("Arrival Rate (0.0 - 1.0)");
			lblArrivalRate.setFont(defaultFont);
			lblArrivalRate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblArrivalRate.setBounds(16, 61, 140, 14);
			inputPane.add(lblArrivalRate);

			JLabel lblDepartureRate = new JLabel("Departure Rate (0.0 - 1.0)");
			lblDepartureRate.setFont(defaultFont);
			lblDepartureRate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDepartureRate.setBounds(16, 86, 140, 14);
			inputPane.add(lblDepartureRate);
			
			JLabel lblFuelRemaining = new JLabel("Fuel Remaining (>0)");
			lblFuelRemaining.setFont(defaultFont);
			lblFuelRemaining.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFuelRemaining.setBounds(16, 111, 140, 14);
			inputPane.add(lblFuelRemaining);
			
			JLabel lblRunways = new JLabel("Number of Runways (>0)");
			lblRunways.setFont(defaultFont);
			lblRunways.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRunways.setBounds(16,136,140,14);
			inputPane.add(lblRunways);
			
			JLabel lblSimulationRuntime = new JLabel("Simulation Run Time(>0)");
			lblSimulationRuntime.setFont(defaultFont);
			lblSimulationRuntime.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSimulationRuntime.setBounds(16, 161, 140, 14);
			inputPane.add(lblSimulationRuntime);
			
			JLabel errMsg = new JLabel("Messages");
			errMsg.setFont(defaultFont);
			errMsg.setHorizontalAlignment(SwingConstants.RIGHT);
			errMsg.setBounds(16, 185, 140, 14);
			inputPane.add(errMsg);
			
			arrivalRateTextField = new JTextField();
			arrivalRateTextField.setFont(defaultFont);
			arrivalRateTextField.setBounds(160, 58, 300, 20);
			inputPane.add(arrivalRateTextField);
			arrivalRateTextField.setColumns(25);		
			
			landingTimeTextField = new JTextField();
			landingTimeTextField.setFont(defaultFont);
			landingTimeTextField.setBounds(160, 8, 300, 20);
			inputPane.add(landingTimeTextField);
			landingTimeTextField.setColumns(15);
					
			fuelRemainingTextField = new JTextField();
			fuelRemainingTextField.setFont(defaultFont);
			fuelRemainingTextField.setBounds(160, 108, 300, 20);
			inputPane.add(fuelRemainingTextField);
			fuelRemainingTextField.setColumns(15);
				
			departureRateTextField = new JTextField();
			departureRateTextField.setFont(defaultFont);
			departureRateTextField.setBounds(160, 83, 300, 20);
			inputPane.add(departureRateTextField);
			departureRateTextField.setColumns(15);	
			
			takeOffTimeTextField = new JTextField();
			takeOffTimeTextField.setFont(defaultFont);
			takeOffTimeTextField.setBounds(160, 33, 300, 20);
			inputPane.add(takeOffTimeTextField);
			takeOffTimeTextField.setColumns(15);
			
			numOfRunwaysTextField = new JTextField();
			numOfRunwaysTextField.setFont(defaultFont);
			numOfRunwaysTextField.setBounds(160,133,300,20);
			inputPane.add(numOfRunwaysTextField);
			numOfRunwaysTextField.setColumns(15);
			
			simulationRuntimeTextField = new JTextField();
			simulationRuntimeTextField.setFont(defaultFont);
			simulationRuntimeTextField.setBounds(160, 158, 300, 20);
			inputPane.add(simulationRuntimeTextField);
			simulationRuntimeTextField.setColumns(15);	
			
			// Text field for error messages
			msgTextField = new JTextField();
			msgTextField.setFont(defaultFont);
			msgTextField.setBounds(160, 180, 600, 20);
			msgTextField.setEditable(false);
			inputPane.add(msgTextField);
			msgTextField.setColumns(15);	
			
			runSimulationButton = new JButton("Run");
			// Event trigger for the Run Simulation button
			runSimulationButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					runSimulation();
				}
			});
			
			runSimulationButton.setFont(defaultFont);
			runSimulationButton.setBounds(540, 11, 90, 28);
			inputPane.add(runSimulationButton);

	
			clearButton = new JButton("Clear");
			// Event trigger for the Clear button
			clearButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					clearFields();
				}
			});
			clearButton.setFont(defaultFont);
			clearButton.setBounds(540, 51, 90, 28);
			inputPane.add(clearButton);
			
		
			JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(10, 250, 974, 200);
			contentPane.add(scrollPane);
			
			displayResults = new JTextArea();
			displayResults.setFont(defaultFont);	
			scrollPane.setViewportView(displayResults);
			
			setLocationRelativeTo(null);
			setVisible(true);
		}
		
		/**
		 * runSimulation collects the information in the text fields and then runs 
		 * a simulation with that information.  The results are displayed in the text area.
		 * 
		 * @precondition 
		 * 		fields are filled in with appropriate type and in appropriate range
		 * @postcondition
		 * 		a simulation has been run and the results are displayed in the text area
		 */
		public void runSimulation ()	{
			
			int landingTime;
			int takeOffTime;
			double arrivalRate = 0.0;
			double departureRate = 0.0;
			int fuelRemaining;
			int numOfRunways;
			int totalSimulationTime;
			String output;
			
			try	{
				arrivalRate = Double.parseDouble (arrivalRateTextField.getText());
			} catch (Exception e)	{
				msgTextField.setText("Enter digits in arrival rate field");
				displayResults.setText("");
				return;
			} 
			
			if ((arrivalRate < 0.0) || (arrivalRate > 1.0))	{
				msgTextField.setText("Arrival rate must be between 0.0 and 1.0");
				displayResults.setText("");
				return;
			}
			
			try{ 
				departureRate = Double.parseDouble(departureRateTextField.getText());
			} catch (Exception e)	{
				msgTextField.setText("Enter digits in departure rate field");
				displayResults.setText("");
				return;
			}
			
			if ((departureRate < 0.0) || (departureRate > 1.0)){
				msgTextField.setText("Departure rate must be between 0.0 and 1.0");
				displayResults.setText("");
				return;
			}
			
			try{
				landingTime = Integer.parseInt(landingTimeTextField.getText());
			} catch (Exception e){
				msgTextField.setText("Enter an integer in landing time field");
				displayResults.setText("");
				return;
			}
			
			try{
				takeOffTime = Integer.parseInt(takeOffTimeTextField.getText());
			} catch (Exception e){
				msgTextField.setText("Enter an integer in take off time field");
				displayResults.setText("");
				return;
			}
			
			try{
				fuelRemaining = Integer.parseInt(fuelRemainingTextField.getText());	
			} catch (Exception e){
				msgTextField.setText("Enter an integer in fuel remaining field");
				displayResults.setText("");
				return;
			}
			
			try{
				numOfRunways = Integer.parseInt(numOfRunwaysTextField.getText());	
			} catch (Exception e){
				msgTextField.setText("Enter an integer in runways field");
				displayResults.setText("");
				return;
			}
			
			try{
				totalSimulationTime = Integer.parseInt(simulationRuntimeTextField.getText());
			} catch (Exception e){
				msgTextField.setText("Enter an integer in simulation time field");
				displayResults.setText("");
				return;
			}
			
			try{
				output = Main.airportSimulation(landingTime, takeOffTime, arrivalRate, departureRate, fuelRemaining, numOfRunways, totalSimulationTime);
			} catch (IllegalArgumentException e){
				msgTextField.setText(e.getMessage());
				displayResults.setText("");
				return;
			}
			msgTextField.setText("");
			displayResults.setText(output);
		}
		/**
		 * clearFields will clear all the information inside the text fields
		 * 
		 * @postcondition
		 * 		all information within the text fields has been erased
		 */
		public void clearFields()	{
			
			landingTimeTextField.setText("");
			takeOffTimeTextField.setText("");
			arrivalRateTextField.setText("");
			departureRateTextField.setText("");
			fuelRemainingTextField.setText("");
			numOfRunwaysTextField.setText("");
			simulationRuntimeTextField.setText("");
			msgTextField.setText("");
			displayResults.setText("");
		}

}
