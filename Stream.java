/**
 * 	 NOTE:
 * 
 * 		+ PACKAGE_NAME_FORMAT: "com.companyName.author.nameOfGroupedCode"
 * 
 *		+ COPIED FROM 'https://www.commonwealthu.brightSpace.com'.
 *
 * 		+ INCLUDED IN 'com.commonwealthu.phuegler.RobotAPI' PACKAGE.
 * 
 * 		+ JAVADOCS FOR implementation/API LOCALLY REFERENCED IN:
 * 				PATH_IN_PROJECT: CMSC130_Project1_RobotGUI/javadoc
 * 
 * 		+ INCLUDED IN PROJECT, WITH PERMISSION:
 * 				ORIGINAL_AUTHOR: Dr. Peter Heugler
 */


// Package contains robot code not written by me.
package com.commonwealthu.phuegler.RobotAPI;

// [4] Library imports for: 'java.util' && 'java.io'.
import java.io.ByteArrayInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// [5] Library imports for: 'org.opencv'.
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

// [3] Library imports for: 'javafx'.
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Stream a video using openCV.
 * 
 * @author phuegler@commonwealthu.edu
 */
public class Stream {
	
	// Instance variable of timer used to display frames in the 'ImageView' object.
	private ScheduledExecutorService scheduler;
	
	/**
	 * This is the only the main constructor for the Stream class.
	 */
	public Stream() {

		// Load the native library for openCV
		System.loadLibrary("opencv_java490"); //Core.NATIVE_LIBRARY_NAME
		
		// Create the scheduler for frame updates.
		this.scheduler = Executors.newSingleThreadScheduledExecutor();
	}
	
	/**
	 * Start streaming the video source to an ImageView using an URL.
	 * 
	 * @param source : The URL for the source of the video.
	 * @param view   : The ImageView object to use.
	 */
	public void start( String source, ImageView view ) {
		
		// open the capture device
		VideoCapture capture = new VideoCapture(source);
		
		// Create the timer to update the scene.
		this.scheduleUpdate(capture, view);
	}
	
	/**
	 * Start streaming the video source to an ImageView using an openCV index.
	 * 
	 * @param source : The openCV index of the source of the video.
	 * @param view   : The ImageView object to use.
	 */
	public void start( int source, ImageView view ) {
		
		// Open the capture device.
		VideoCapture capture = new VideoCapture( source );
		
		// Create the timer to update the scene.
		this.scheduleUpdate( capture, view );
		
	}
		
	/**
	 * Schedule an update to the ImageView object with a frame from the video source.
	 * 
	 * @param capture : An openCV VideoCapture object for the video input.
	 * @param view    : The ImageView object to update.
	 */
	private void scheduleUpdate(VideoCapture capture, ImageView view) {

		// Update the image view every 16 milliseconds [SAME AS 60fpS].
		// 	  Method gets executed every 33 milliseconds.
		this.scheduler.scheduleAtFixedRate( () -> {
			
			// Create a new frame [image] and fill it from the capture device.
			Mat frame = new Mat();
			capture.read(frame);
			
			// Not every camera will need to flip the image.
			//Core.flip(frame, frame, 0);
		
			// Convert the frame to something the javafx image control can use
			MatOfByte byteMat = new MatOfByte();
			Imgcodecs.imencode(".bmp", frame, byteMat);
			
			// Schedule a JavaFX task to update the ImageView with the frame from the stream.
			Platform.runLater(new Runnable() {
				@Override public void run()  {
					view.imageProperty().set(
						new Image( new ByteArrayInputStream(
							byteMat.toArray()
						)
						)
					);
				}
			});	
			
		}
		, 0  // Initial wait.
		, 16 // Long period.
		, TimeUnit.MILLISECONDS // Time unit.
		
		);
		
	}
	
	/**
	 * Stops the streaming and handles any errors locally.
	 */
	public void stop() {
		
		try {
			
			// Stops the timer.
			this.scheduler.shutdown();
			this.scheduler.awaitTermination(100, TimeUnit.MILLISECONDS);
			
		} catch(Exception event) {
			
			// Prints the exception.
			System.err.println("Exception when stopping the streaming: " +event.getMessage());
			
		}
		
	}

}