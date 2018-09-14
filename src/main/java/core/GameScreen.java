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
import javafx.scene.chart.ValueAxis;
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
	private TextField result1Box;
	private TextField result2Box;
	private TextField AIresult1Box;
	private TextField AIresult2Box;
	private Button giveButton;
	private Button resultButtom;
	private ImageView imgView;
	private ImageView imgAiView;
	private String path;
	private String pathend = ".png";
	private int numberOfcard = 0;
	private Image setimg = null;
	private String[] cardsgone =new String[53];
	private Ai dealer = new Ai();
	private Ai player = new Ai();
	private Button standButton;
	private int list = 0;
	private Label ScreenResult = new Label("");
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
		
		Scene scene = new Scene(canvas, 1000, 700);
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
		int row3 = 400;
		int txtBoxWidth = 100;
		
		Label label = new Label("Welcome to Ace Game made by YidongWu");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 18));
		label.relocate(20, row1);

		
		giveButton = new Button("Card");
		giveButton.relocate(50, row2);
		
		
		standButton = new Button("Stand");
		standButton.relocate(100, row2);
		
		resultButtom = new Button("Result");
		resultButtom.relocate(50, 400);
		resultButtom.setDisable(true);
		
		result1Box = new TextField();
		result1Box.setMaxWidth(txtBoxWidth);
		result1Box.setEditable(false);
		result1Box.relocate(250, row2);
		
		result2Box = new TextField();
		result2Box.setMaxWidth(txtBoxWidth);
		result2Box.setEditable(false);
		result2Box.relocate(350, row2);
		
		AIresult1Box = new TextField();
		AIresult1Box.setMaxWidth(txtBoxWidth);
		AIresult1Box.setEditable(false);
		AIresult1Box.relocate(250, row3);
		
		AIresult2Box = new TextField();
		AIresult2Box.setMaxWidth(txtBoxWidth);
		AIresult2Box.setEditable(false);
		AIresult2Box.relocate(350, row3);
		setSolnBtnClickHandler(canvas);
		setStandClickHandler(canvas);
		setResultClickHandler();
		canvas.getChildren().addAll(ScreenResult,label,resultButtom, giveButton, result1Box,result2Box,standButton,AIresult2Box,AIresult1Box);
	}
	

	
	private void setResultClickHandler() {
		// TODO Auto-generated method stub
		resultButtom.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent event) {
				CalSolver solver = new CalSolver();
				String resultend = solver.Whoiwin(player.gethandValue1(), player.gethandValue2(), dealer.gethandValue1(), dealer.gethandValue2());
				logger.info(resultend);
				ScreenResult.setText(resultend);
				ScreenResult.setFont(Font.font("Serif", FontWeight.NORMAL, 34));
				ScreenResult.relocate(200, 300);
 			}
		});
		
	}

	private void setStandClickHandler(Pane canvas) {
		standButton.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent event) {
 				standButton.setDisable(true);
 				giveButton.setDisable(true);
 				setAiAction(canvas);
 			}
		});
	}
	private void setAiAction(Pane canvas) {
		CalSolver solverAi = new CalSolver();
			int mycardid; 
			int mycardValue; 
			String mycard;
			while(true) {
				while(true) {
					mycardid = solverAi.getSimpleOfCard();
					mycardValue = solverAi.getValueOfCard(mycardid);
					mycard = solverAi.getCard(mycardid);
					int i;
					int samecard = 0;
					if(numberOfcard>0) {
						for(i=0; i<numberOfcard;i++) {
							if(cardsgone[i] == mycard) {
								samecard = 1;
							}
						}
					}
					if(samecard == 1) {
						
					}
					else {
						
						break;
					}
				}
				if(dealer.gethandValue1() + mycardValue >= 21||dealer.gethandValue2() == 21) {
					logger.info(" Dealer Stand:");
					resultButtom.setDisable(false);
					break;
				}
				cardsgone[numberOfcard] = mycard;
				dealer.addtohandValue(mycardValue);
				dealer.addCard(mycard);
				dealer.increasenumberOfCard();
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
				
				logger.info(" Dealer Get Card:"+ mycard);
				imgAiView = new ImageView();
				imgAiView.setImage(setimg);
				imgAiView.relocate(20+110*(list), 500);
				list++;
				imgAiView.setFitWidth(100);
				imgAiView.setFitHeight(150);
				imgAiView.setPreserveRatio(true);
				
				dealer.calValue();
 				String AIresult1string = String.valueOf(dealer.gethandValue1());
 				String AIresult2string = String.valueOf(dealer.gethandValue2());
 				//System.out.println(player.gethandValue1());
 				AIresult1Box.setText(AIresult1string);
 				AIresult2Box.setText(AIresult2string);
 				logger.info(" Dealer score:  "+ AIresult1string +"  and  " + AIresult2string);
				canvas.getChildren().addAll(imgAiView);
				
			}
	}
	
	private void setSolnBtnClickHandler(Pane canvas) {
		giveButton.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent event) {

 				CalSolver solver = new CalSolver();
 				int mycardid; 
 				int mycardValue; 
 				String mycard;
 				while(true) {
 					mycardid = solver.getSimpleOfCard();
 	 				mycardValue = solver.getValueOfCard(mycardid);
 	 				mycard = solver.getCard(mycardid);
 	 				int i;
 	 				int samecard = 0;
 	 				if(numberOfcard>0) {
 	 					for(i=0; i<numberOfcard;i++) {
 	 						if(cardsgone[i] == mycard) {
 	 							samecard = 1;
 	 						}
 	 					}
 	 				}
 					if(samecard == 1) {
 						
 					}
 					else {
 						cardsgone[numberOfcard] = mycard;
 						break;
 					}
 				}
 				player.addtohandValue(mycardValue);
 				player.addCard(mycard);
 				player.increasenumberOfCard();
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
 				
 				logger.info(" Player Get Card:"+ mycard);
 				imgView = new ImageView();
 				imgView.setImage(setimg);
 				imgView.relocate(20+110*(numberOfcard -1), 120);
 				imgView.setFitWidth(100);
 				imgView.setFitHeight(150);
 				imgView.setPreserveRatio(true);
 				
 				
 				setCardClickHandler();
 				player.calValue();
 				String result1string = String.valueOf(player.gethandValue1());
 				String result2string = String.valueOf(player.gethandValue2());
 				//System.out.println(player.gethandValue1());
 				result1Box.setText(result1string);
 				result2Box.setText(result2string);
 				if(player.gethandValue1() >21 && player.gethandValue2() >21) {
 					
 				}
 				logger.info(" Player score:  "+ result1string +"  and  " + result2string);
 				canvas.getChildren().addAll(imgView);
 			//resultBox.setText(answer);
			}
		});
	}
	
	
}
