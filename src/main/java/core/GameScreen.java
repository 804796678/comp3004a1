package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Random;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameScreen extends Application {
	private static final Logger logger = LogManager.getLogger(GameScreen.class);
	private TextField resultBox;
	private Image[] cardsImg;
	private ImageView imgView;
	
	
	
	//---------------------------------
	public static void main(String[] args) {
		logger.info("Game Ace booting up ...");
		
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	
	private void initUI(Stage primaryStage) {
		Pane canvas = new Pane();
		canvas.setStyle("-fx-background-color: green");
		
		//addControlsToCanvas(canvas);
		//setupCardAnimation(canvas);
		
		Scene scene = new Scene(canvas, 320, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("21Ace");
		primaryStage.show();
	}
	
	
}
