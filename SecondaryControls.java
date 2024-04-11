/**
 * @author gmh80623@lockhaven.edu
 */

package cmsc130;

import interactivity.SecondarySetOnActionHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

/**
 * Class represents the secondary controls/window used for controlling camera servo movement,
 * 		LED servo movement, and LED color output.
 */
public class SecondaryControls {

	// All buttons that have lambda functionality declared as instance variables.
	private static Button resetCamera; // Camera Servo
	
	private static Button redLEDControl; // LED
	private static Button blueLEDControl; // LED
	private static Button greenLEDControl; // LED
	
	private static Button ledHorizonalControlLeft; // LED Servo
	private static Button ledHorizonalControlRight; // LED Servo
	private static Button ledHorizonalControlCentre; // LED Servo
	
	private static Button cameraVerticalControlUp; // Camera Servo
	private static Button cameraVerticalControlDown; // Camera Servo
	private static Button cameraHorizonalControlLeft; // Camera Servo
	private static Button cameraHorizonalControlRight; // Camera Servo
	
	/**
	 * Initializes/Sets ID of all protected Button elements in this constructor.
	 */
	public SecondaryControls() {
		
		// Initializes all private Button elements.
		redLEDControl = new Button("RED");
		blueLEDControl = new Button("BLUE");
		greenLEDControl = new Button("GREEN");
		resetCamera = new Button("Reset Camera");
		ledHorizonalControlLeft  = new Button("LEFT");
		ledHorizonalControlRight = new Button("RIGHT");
		ledHorizonalControlCentre = new Button("CENTER");
		cameraVerticalControlUp = new Button("UP");
		cameraVerticalControlDown = new Button("DOWN");
		cameraHorizonalControlLeft = new Button("LEFT");
		cameraHorizonalControlRight = new Button("RIGHT");
		
		// Sets ID of all private Button elements.
		resetCamera.setId("resetCamera");
		redLEDControl.setId("redLEDControl");
		blueLEDControl.setId("blueLEDControl");
		greenLEDControl.setId("greenLEDControl");
		cameraVerticalControlUp.setId("cameraVerticalControlUp");
		ledHorizonalControlLeft.setId("ledHorizonalControlLeft");
		ledHorizonalControlRight.setId("ledHorizonalControlRight");
		ledHorizonalControlCentre.setId("ledHorizonalControlCentre");
		cameraVerticalControlDown.setId("cameraVerticalControlDown");
		cameraHorizonalControlLeft.setId("cameraHorizonalControlLeft");
		cameraHorizonalControlRight.setId("cameraHorizonalControlRight");
	}
	
	/**
	 * Returns a scene with secondary controls to control the robot with.
	 * 
	 * @param windowSizeX : How big the window X is set to when method is called.
	 * @param windowSizeY : How big the window Y  is set to when method is called.
	 * @return Scene : GUI for secondary controls (camera &&s led).
	 **/
	public Scene getScene(double windowSizeX, double windowSizeY) {
		
		// Parent Element returned as parameter to a new Scene().
		VBox v = new VBox();
		
		// HBoxes contain centered elements.
		HBox h0 = new HBox();
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		HBox h4 = new HBox();
		HBox h5 = new HBox();
		HBox h6 = new HBox();
		HBox h7 = new HBox();
		
		// Labels used for the controls.
		Label onOffLabel = new Label("LED COLOR:");
		Label ledDirection = new Label("LED DIRECTION:");
		Label cameraDirection = new Label("CAMERA DIRECTION:");
		
		// Groups used for setting style of multiple elements.
		Group groupLED = new Group();
		Group groupHBox = new Group();
		Group groupHVCamera = new Group();
		
		// Add elements to groups before style is set.
		groupHBox.getChildren().addAll(
			h1, h2,
			h3, h4,
			h5, h6, h7
		);
		
		groupHVCamera.getChildren().addAll(
			cameraVerticalControlUp,
			cameraVerticalControlDown,
			cameraHorizonalControlLeft,
			cameraHorizonalControlRight
		);
		
		groupLED.getChildren().addAll(
			redLEDControl,
			blueLEDControl,
			greenLEDControl
		);
		
		// Padding set to Insets 10 of buttons and labels.
		onOffLabel.setPadding(new Insets(10));
		resetCamera.setPadding(new Insets(10));
		ledDirection.setPadding(new Insets(10));
		redLEDControl.setPadding(new Insets(10));
		blueLEDControl.setPadding(new Insets(10));
		greenLEDControl.setPadding(new Insets(10));
		
		// Mass setting of text alignment and alignment.
		resetCamera.setAlignment(Pos.CENTER);
		resetCamera.setTextAlignment(TextAlignment.CENTER);
		
		redLEDControl.setAlignment(Pos.CENTER);
		blueLEDControl.setAlignment(Pos.CENTER);
		greenLEDControl.setAlignment(Pos.CENTER);
		redLEDControl.setTextAlignment(TextAlignment.CENTER);
		blueLEDControl.setTextAlignment(TextAlignment.CENTER);
		greenLEDControl.setTextAlignment(TextAlignment.CENTER);
		
		ledHorizonalControlLeft.setAlignment(Pos.CENTER);
		ledHorizonalControlRight.setAlignment(Pos.CENTER);
		ledHorizonalControlCentre.setAlignment(Pos.CENTER);
		ledHorizonalControlLeft.setTextAlignment(TextAlignment.CENTER);
		ledHorizonalControlRight.setTextAlignment(TextAlignment.CENTER);
		ledHorizonalControlCentre.setTextAlignment(TextAlignment.CENTER);
		
		cameraVerticalControlUp.setAlignment(Pos.CENTER);
		cameraVerticalControlDown.setAlignment(Pos.CENTER);
		cameraHorizonalControlLeft.setAlignment(Pos.CENTER);
		cameraHorizonalControlRight.setAlignment(Pos.CENTER);
		cameraVerticalControlUp.setTextAlignment(TextAlignment.CENTER);
		cameraVerticalControlDown.setTextAlignment(TextAlignment.CENTER);
		cameraHorizonalControlLeft.setTextAlignment(TextAlignment.CENTER);
		cameraHorizonalControlRight.setTextAlignment(TextAlignment.CENTER);
		
		// Label formatting style and TextFill.
		onOffLabel.setStyle("-fx-font-weight: bold;");
		onOffLabel.setTextFill(Paint.valueOf("White"));
		ledDirection.setStyle("-fx-font-weight: bold;");
		ledDirection.setTextFill(Paint.valueOf("White"));
		cameraDirection.setStyle("-fx-font-weight: bold;");
		cameraDirection.setTextFill(Paint.valueOf("White"));
		
		// Button styling.
		groupLED.setStyle("-fx-background-radius: 10;");
		groupLED.setStyle("-fx-background-color: gray");
		resetCamera.setStyle("-fx-background-radius: 20;");
		
		// VBOX FORMATTING FOR SIZE, ALIGNMENT, and COLOR.
		v.setAlignment(Pos.CENTER);
		v.setMinSize(windowSizeX, windowSizeY);
		v.setStyle("-fx-background-color: rgb(15, 27, 117);");
		
		// Sets how the elements will respond to X-coordinate window resizing.
		HBox.setHgrow(groupHVCamera, Priority.ALWAYS);
		HBox.setHgrow(cameraVerticalControlUp, Priority.ALWAYS);
		HBox.setHgrow(cameraVerticalControlDown, Priority.ALWAYS);
		HBox.setHgrow(cameraHorizonalControlLeft, Priority.ALWAYS);
		HBox.setHgrow(cameraHorizonalControlRight, Priority.ALWAYS);
		
		// Alignment of HBoxes.
		h0.setAlignment(Pos.CENTER);
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		h3.setAlignment(Pos.CENTER);
		h4.setAlignment(Pos.CENTER);
		h5.setAlignment(Pos.CENTER);
		h6.setAlignment(Pos.CENTER);
		h7.setAlignment(Pos.CENTER);
		
		// Padding of HBoxes.
		h0.setPadding(new Insets(2));
		h1.setPadding(new Insets(7));
		h1.setPadding(new Insets(10));
		h2.setPadding(new Insets(10));
		h3.setPadding(new Insets(10));
		h4.setPadding(new Insets(15,0,5,0));
		h5.setPadding(new Insets(10));
		h6.setPadding(new Insets(10));
		h7.setPadding(new Insets(5));
		
		// Adds elements and creates hierarchy with HB/VBox(s).
		h0.getChildren().add(onOffLabel);
		h1.getChildren().add(redLEDControl);
		h2.getChildren().add(greenLEDControl);
		h3.getChildren().add(blueLEDControl);
		h4.getChildren().add(cameraDirection);
		h5.getChildren().addAll(
			cameraVerticalControlUp,
			cameraVerticalControlDown,
			cameraHorizonalControlLeft,
			cameraHorizonalControlRight);
		h6.getChildren().add(resetCamera);
		h7.getChildren().addAll(
			ledHorizonalControlLeft,
			ledHorizonalControlCentre,
			ledHorizonalControlRight);
		v.getChildren().addAll(
			onOffLabel,
			h0, h1, h2,
			h3, h4, h5, h6,
			ledDirection, h7
		);
		
		// Lambda Functions for all buttons on secondary control stage.
		resetCamera.setOnAction(sev -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				resetCamera);
		});
		redLEDControl.setOnAction((e) -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				redLEDControl);
		});
		blueLEDControl.setOnAction((e) -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				blueLEDControl);
		});
		greenLEDControl.setOnAction((e) ->  {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				greenLEDControl);
		});
		ledHorizonalControlLeft.setOnAction((e) -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				ledHorizonalControlLeft);
		});
		ledHorizonalControlRight.setOnAction((e) -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				ledHorizonalControlRight);
		});
		ledHorizonalControlCentre.setOnAction((e) -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				ledHorizonalControlCentre);
		});
		cameraVerticalControlUp.setOnAction(event -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				cameraVerticalControlUp
		);});
		cameraVerticalControlDown.setOnAction(event -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				cameraVerticalControlDown
		);});
		cameraHorizonalControlLeft.setOnAction(event -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				cameraHorizonalControlLeft
		);});
		cameraHorizonalControlRight.setOnAction(event -> {
			SecondarySetOnActionHandler.runSetOnActionLambda(
				cameraHorizonalControlRight
		);});
		
		// Finally, return our Secondary Controls scene.
		return new Scene(v);
	}
	
}