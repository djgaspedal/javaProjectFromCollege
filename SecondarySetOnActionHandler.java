/**
 * @author gmh80623@lockhaven.edu
 */

package interactivity;

import cmsc130.RobotVideoOutput;
import javafx.scene.control.Button;

/**
 * Class contains all nested code used in lambda functions
 *  for interactivity attached to Button objects. The single
 *   method runSetOnActionLambda() accepts a Button's ID and
 *    switches to the correct functionality.
 */
public class SecondarySetOnActionHandler {
	
	/**
	 * Contains all nested code that gets ran from a "setOnAction(e->{})"
	 * 	lambda function activated from a Button object in the SecondaryControls class.
	 * 
	 * NOTE for case redLEDControl:
	 * 	'Integer.valueOf(0)' is used to prevent warnings about expressions of
	 * 	  type Integer being u-n-box-e-d into INT.
	 *
	 * @param clickedButton : A button passed in from the SecondaryControls class
	 * 	 with a specific ID will activate switch statement between different functionalities.
	 */
	public static void runSetOnActionLambda(Button clickedButton) {
		
		// If Id doesn't exist, lambda will not do anything.
		// Get ID, switch between IDs.
		if(clickedButton.getId() != null) {
			
			switch( clickedButton.getId() ) {
				
				case "redLEDControl": // RED LED ON/OFF
					
					if(RobotVideoOutput.getRobot().getLEDColor().get(0) == Integer.valueOf(0)) {
						clickedButton.setStyle("-fx-background-color: red");
						RobotVideoOutput.getRobot().setLEDColor(255, 0, 0);
					} else {
						clickedButton.setStyle("-fx-background-color: gray");
						RobotVideoOutput.getRobot().setLEDColor(0, 0, 0);
					}
					
					break;
					
				case "greenLEDControl": // GREEN LED ON/OFF
					
					if(RobotVideoOutput.getRobot().getLEDColor().get(1) == Integer.valueOf(0)) {
						clickedButton.setStyle("-fx-background-color: green");
						RobotVideoOutput.getRobot().setLEDColor(0, 255, 0);
					} else {
						clickedButton.setStyle("-fx-background-color: gray");
						RobotVideoOutput.getRobot().setLEDColor(0, 0, 0);
					}
					
					break;
					
				case "blueLEDControl": // BLUE LED ON/OFF
					
					if(RobotVideoOutput.getRobot().getLEDColor().get(2) == Integer.valueOf(0)) {
						clickedButton.setStyle("-fx-background-color: rgb(3, 100, 184)");
						RobotVideoOutput.getRobot().setLEDColor(0, 0, 255);
					} else {
						clickedButton.setStyle("-fx-background-color: gray");
						RobotVideoOutput.getRobot().setLEDColor(0, 0, 0);
					}
					
					break;
				
				case "ledHorizonalControlLeft": // LED HORIZONTAL MOVEMENT
					
					try { RobotVideoOutput.getRobot().moveLED(2450); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "ledHorizonalControlCentre": // LED HORIZONTAL MOVEMENT
					
					try { RobotVideoOutput.getRobot().moveLED(1450); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "ledHorizonalControlRight": // LED HORIZONTAL MOVEMENT
					
					try { RobotVideoOutput.getRobot().moveLED(550); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "resetCamera": // CAMERA POSITION RESET
					
					try { RobotVideoOutput.getRobot().moveLEDHome(); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "cameraHorizonalControlLeft": // CAMERA POSITION LEFT
					
					try { RobotVideoOutput.getRobot().moveCamera(2400, 1475); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "cameraHorizonalControlRight": // CAMERA POSITION RIGHT
					
					try { RobotVideoOutput.getRobot().moveCamera(600, 1475); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "cameraVerticalControlUp": // CAMERA POSITION UP
					
					try { RobotVideoOutput.getRobot().moveCamera(1450, 2400); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
				
				case "cameraVerticalControlDown": // // CAMERA POSITION DOWN
					
					try { RobotVideoOutput.getRobot().moveCamera(1450, 600); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					
					break;
			
			}
		}
	}
}