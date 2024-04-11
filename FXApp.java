/**
 * PROJECT NAME: 'CMSC130_Project1_RobotGUI'.
 * 
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * The FXApp class is where other classes and methods are used for displaying/running JavaFX.
 */
public class FXApp extends Application {
	
	/**
	 * The main(String[] args) method is used to run 'launch( ... command line arguments )'.
	 * Launch() is ran once to launch the JavaFX stand alone application.
	 * @param args : Command-Line Arguments.
	 */
	public static void main(String[] args) { launch(args); }
	
	/**
	 * This is where the JavaFX application launches, not in 'main()'.
	 * Stage primaryStage : the primary top-level JavaFX container used as a param.
	 * 
	 * @exception java.lang.Exception : throws a checked exception if Javafx cannot run the application.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Initialize the secondary stage first. (primaryStage is already INIT).
		Stage secondaryControls = new Stage();
		
		// New stream and main controls for robot.
		RobotVideoOutput newStream = new RobotVideoOutput();
	
		// New secondary controls for the robot.
		SecondaryControls s = new SecondaryControls();
		
		// Gets the window dimensions and stores in a 2D Rectangle object.
		Rectangle2D screenWidth = Screen.getPrimary().getVisualBounds();
		
		// Sets primaryStage's scene.
		primaryStage.setScene(newStream.getScene());
		
		// Sets scene of the new secondary controls stage.
		secondaryControls.setScene( s.getScene(400, 600) );
		
		// Sets titles of both window(s)/stage(s).
		primaryStage.setTitle("GUI Controls For Robot");
		secondaryControls.setTitle("Secondary Controls");
		
		// Sets X location of the primaryStage to the center of your screen.
		primaryStage.setX( (screenWidth.getWidth() / 2) - (RobotVideoOutput.globalSceneWidth / 2) );
		
		// Sets Y location of the primaryStage to the center of your screen.
		primaryStage.setY( (screenWidth.getHeight()/ 2) - (RobotVideoOutput.globalSceneWidth / 2) );
		
		// Sets X location of secondaryControls to the right of primaryStage.
		secondaryControls.setX( primaryStage.getX() + RobotVideoOutput.globalSceneWidth + 20 );
		
		// Sets Y location of secondaryControls to the right of primaryStage.
		secondaryControls.setY( primaryStage.getY() + 100 );

		// Set resizable, alwaysOnTop, and minWidth/minHeight of primaryStage.
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setMinWidth(RobotVideoOutput.globalSceneWidth);
		primaryStage.setMinHeight(RobotVideoOutput.globalSceneWidth);
		
		// Closes both stages and stops streaming concurrently when either window is closed.
		primaryStage.setOnCloseRequest( (e) -> {
			primaryStage.close();
			secondaryControls.close();
			newStream.streamTakeDown();
		});
		
		secondaryControls.setOnCloseRequest( (e) -> {
			primaryStage.close();
			secondaryControls.close();
			newStream.streamTakeDown();
		});
				
		// Finally, shows the primary and secondary controls to the user.
		primaryStage.show();
		secondaryControls.show();
	}
}