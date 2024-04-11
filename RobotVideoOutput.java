/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

import com.commonwealthu.phuegler.RobotAPI.Robot;
import com.commonwealthu.phuegler.RobotAPI.Stream;

import interactivity.ButtonClickHandler;
import interactivity.KeyTypedHandler;
// Imports for Javafx, Robot code, and interactivity handlers.
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * This class outputs the streamed video from the robot's web camera
 * 	to a JavaFX window and adds controls directly below the streaming view.
 */
public class RobotVideoOutput {

	// Global double variables used to build scene that is returned in 'getScene()'.
	protected static double globalSceneWidth =  650.0;
	protected static double globalSceneHeight = 600.0;
	
	// Initialize the robot and stream.
	private static Robot robot;
	private static Stream stream;
	
	// Global Scene object that is returned at the end of getScene().
	private static Scene completeRobotView;
		
	/**
	 * Constructor initializes a new Robot and
	 * 	 Stream before '.getScene()' is called upon an instance
	 * 		of RobotVideoOutput. Catches exceptions if object creation failed.
	 */
	public RobotVideoOutput(){
		try {
			
			// Initialize all parts of the robot to be used in interactivity sub-classes.
			robot = new Robot();
			stream = new Stream();
			
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	/**
	 * Method returns a Scene object built with a parent AnchorPane container.
	 * 
	 * @return Scene : The scene is used a parameter in 'FXApp.start().primaryStage.setScene()'.
	 **/
	public Scene getScene() {
		
		// Top-Level element.
		AnchorPane topLevelElem = new AnchorPane();
		
		// For stacking of controls and the robot stream
		VBox mainContainer = new VBox();
			
		// Contains the keyboard bindings and mouse control elements.
		HBox wasd = new HBox();
		HBox controls = new HBox();
		HBox mouseLoc = new HBox();
		
		// Contains the streaming elements stacked on top of all controls.
		HBox robotStream = new HBox();
		
		// Create an image view and start the video streaming.
		ImageView streamView = new ImageView();
		stream.start(robot.getCameraURL(), streamView);
		
		// Buttons used for movement of the robot when clicked.
		Button upButton = new Button("Up");
		Button downButton = new Button("Down");
		Button leftButton = new Button("Left");
		Button rightButton = new Button("Right");
		
		// GridPane used for layout of buttons. Adds buttons to respective places.
		GridPane buttonGrid = new GridPane();
		buttonGrid.add(upButton, 1, 0); // Add W button to row 0, column 1
		buttonGrid.add(leftButton, 0, 1); // Add A button to row 1, column 0
        buttonGrid.add(downButton, 1, 1); // Add S button to row 1, column 1
        buttonGrid.add(rightButton, 2, 1); // Add D button to row 1, column 2
        
        // Used for stopping the robot using setOnMouseEntered.
        Rectangle stopSquare = new Rectangle(150, 140);
		Label forceStopLabel = new Label("Move Mouse into square to force stop.");
		
		// Alignment of elements.
		controls.setAlignment(Pos.CENTER);
		buttonGrid.setAlignment(Pos.CENTER);
		robotStream.setAlignment(Pos.CENTER);
		upButton.setAlignment(Pos.TOP_CENTER);
		mainContainer.setAlignment(Pos.CENTER);
		downButton.setAlignment(Pos.BOTTOM_CENTER);
		GridPane.setHalignment(upButton, HPos.CENTER);
		
		// Minimum/preferential width of elements.
		buttonGrid.setHgap(10);
		robotStream.setMinWidth(600);
		HBox.setHgrow(wasd, Priority.ALWAYS);
		HBox.setHgrow(mouseLoc, Priority.ALWAYS);
		robotStream.setPrefWidth(globalSceneWidth);
		mainContainer.setMinWidth(globalSceneWidth);
		
		// Sets minimum/preferential height of elements
		// Sets gap-ping of vertical dimensions.
		buttonGrid.setVgap(10);
		robotStream.setMinHeight(480);
		robotStream.setPrefHeight(480);
		
		// Set Padding.
		upButton.setPadding(new Insets(20));
		downButton.setPadding(new Insets(20));
		leftButton.setPadding(new Insets(20));
		rightButton.setPadding(new Insets(20));
		forceStopLabel.setPadding(new Insets(10));
		
		
		// Sets Border, Background, and Fill.
		stopSquare.setFill(Color.RED);
		wasd.setBackground(Background.fill(Paint.valueOf("Black")));
		robotStream.setBorder(Border.stroke(Paint.valueOf("Black")));
		
		// Set style and text-fill of force stop label.
		forceStopLabel.setStyle("-fx-font-weight: bold;");
		forceStopLabel.setTextFill(Paint.valueOf("White"));
		mouseLoc.setBackground(Background.fill(LinearGradient.valueOf(
				"from 0% 0% to 100% 100%, red  0% , blue 30%,  black 100%"
		)));
		
		// Adds all nodes to their respective parents.
		wasd.getChildren().addAll(buttonGrid);
		robotStream.getChildren().add(streamView);
		controls.getChildren().addAll(wasd, mouseLoc);
		topLevelElem.getChildren().addAll(mainContainer);
		mouseLoc.getChildren().addAll(stopSquare, forceStopLabel);
		mainContainer.getChildren().addAll(robotStream, controls);
		
		// Creates a new sized Scene object with AnchorPane as the Parent element.
		completeRobotView = new Scene(
			
			topLevelElem, 	  // AnchorPane will contain every node.
			globalSceneWidth, // X: Width as a {double}
			globalSceneHeight // Y: Height as a {double}
		);
		
		// Lambda functions for interactivity.
		stopSquare.setOnMouseEntered( (e) -> { RobotVideoOutput.getRobot().stop(); });
		leftButton.setOnMouseClicked( (e) -> { ButtonClickHandler.buttonMoveLeft(40); });
		rightButton.setOnMouseClicked( (e) -> { ButtonClickHandler.buttonMoveRight(40); });
		downButton.setOnMouseClicked( (e) -> { ButtonClickHandler.buttonMoveReverse(40); });
		upButton.setOnMouseClicked( (e) -> { ButtonClickHandler.buttonMoveForward(40, 40); });
		topLevelElem.setOnKeyPressed( (e) -> { KeyTypedHandler.moveKeyType(30, e.getCode()); });
		
		// Returns the built scene 'completeRobotView'.
		return completeRobotView;
	}

	/**
	 * Stops the stream from URL or from openCV index. Does not return anything.
	 */
	public void streamTakeDown() {
		
		try {
			
			stream.stop(); // Stops the global 'stream' object.
			robot.close(); // Closes the global 'robot' object.
			
		} catch(Exception x) {x.printStackTrace(); }		
	}
	
	/**
	 * Returns the Robot object created in constructor. Getter method used for
	 * 		accessing Robot methods in other classes. The robot is accessible in other classes.
	 * 
	 * @return Robot : The robot is initialized in constructor.
	 */
	public static Robot getRobot() {
		
		return robot;
	}
	
}