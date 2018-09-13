package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.nio.file.Path;
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
	private Button giveButton;
	private ImageView imgView;
	private String path;
	private String pathend = ".png";
	private int numberOfcard = 0;
	private Image setimg = null;
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
		
		addControlsToCanvas(canvas);
		
		Scene scene = new Scene(canvas, 800, 1000);
		primaryStage.setScene(scene);
		primaryStage.setTitle("21Ace");
		primaryStage.show();
	}
	
	
	private void setCardClickHandler() {
		
		imgView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			//logger.info("Card click detected");
			
			//imgView.setImage();
		});
	}
	private void addControlsToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 100;
		
		Label label = new Label("Welcome to Ace Game made by YidongWu");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 18));
		label.relocate(20, row1);

		
		giveButton = new Button("Card");
		giveButton.relocate(50, row2);
		
		resultBox = new TextField();
		resultBox.setMaxWidth(txtBoxWidth);
		resultBox.setEditable(false);
		resultBox.relocate(250, row2);
		
		setSolnBtnClickHandler(canvas);
		
		canvas.getChildren().addAll(label, giveButton, resultBox);
	}
	private void setSolnBtnClickHandler(Pane canvas) {
		giveButton.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent event) {

 				CalSolver solver = new CalSolver();
 				int mycardid = solver.getSimpleOfCard();
 				int mycardValue = solver.getValueOfCard(mycardid);
 				String mycard = solver.getCard(mycardid);
 				numberOfcard ++;
 				path  = "src/main/resources/Card/";
 				path += mycard;
 				path += pathend;
 				try {
 					setimg = new Image(new FileInputStream(path));
 				} catch (FileNotFoundException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				
 				logger.info("Get Card:"+ mycard);
 				imgView = new ImageView();
 				imgView.setImage(setimg);
 				imgView.relocate(20+180*(numberOfcard -1), 120);
 				imgView.setFitWidth(150);
 				imgView.setFitHeight(200);
 				imgView.setPreserveRatio(true);
 				
 				
 				setCardClickHandler();
 						
 				canvas.getChildren().addAll(imgView);
 			//resultBox.setText(answer);
			}
		});
	}
	
	
}
