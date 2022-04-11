package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Withdraws extends GridPane{

	Button btnLogout;
	Button btnMenu;
	//with out saving
	Button clear;
	//with saving
	Button newW;
	Button enter;
	Button pay;
	TextField txt;
	ToggleButton w;
	ToggleButton pb;
	ToggleGroup withdrawalToggle;
	
	ChoiceBox<String> accountChoiceBox;
	TextField billChoiceBox;
	
	public Withdraws() {

		Text withdrawTitle = new Text("WITHDRAW or PAY A BILL");
		
		Text accntLabl = new Text("SELECT ACCOUNT:");
		Text amntLabel = new Text("AMOUNT:");
		Text billLabel = new Text("BILL NAME:");
		
		// Toggle buttons
		w = new ToggleButton("WITHDRAW"); 
		pb = new ToggleButton("PAY A BILL"); 
		
		withdrawalToggle = new ToggleGroup(); 
		w.setToggleGroup(withdrawalToggle);   
		pb.setToggleGroup(withdrawalToggle); 

		accountChoiceBox = new ChoiceBox<String>(); 
		accountChoiceBox.setPrefWidth(150);
		accountChoiceBox.setPrefHeight(25);
		accountChoiceBox.getItems().addAll("Chequing","Savings");
		
		billChoiceBox = new TextField(); 
		billChoiceBox.setPrefWidth(150);
		billChoiceBox.setPrefHeight(25);
		
		txt = new TextField();
		txt.setPrefWidth(100);
		txt.setPrefHeight(25);

		enter = new Button("CONFIRM");
		pay = new Button("PAY");
		
		// Buttons
		btnMenu = new Button("BACK TO MENU");
		btnLogout = new Button("LOGOUT");
		clear =new Button("RESET");
		newW = new Button("NEW");

		// Set up grid pane
		this.setMinSize(10, 10);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setVgap(15); 
		this.setHgap(15);
		this.setAlignment(Pos.CENTER);

		// Arrange grid
		this.add(withdrawTitle, 0, 0, 4, 1);
		GridPane.setHalignment(withdrawTitle, HPos.CENTER);
		withdrawTitle.setStyle("-fx-font: normal normal 35px 'consolas' ");
		withdrawTitle.setFill(Color.BLACK);
		
		// Account 
		this.add(accntLabl, 0, 1);
		accntLabl.setStyle("-fx-font: normal normal 20px 'consolas' ");
		GridPane.setHalignment(accntLabl, HPos.RIGHT);
		
		this.add(accountChoiceBox, 1, 1);
		accountChoiceBox.setStyle("-fx-font: normal normal 18px 'consolas' ");

		// Withdraw type
		this.add(w, 2, 1);
		w.setStyle("-fx-font: normal normal 16px 'consolas' ");
		w.setShape(new Circle(1));
		
		this.add(pb, 3, 1);
		pb.setStyle("-fx-font: normal normal 16px 'consolas' ");
		pb.setShape(new Circle(1));
		GridPane.setHalignment(pb, HPos.CENTER);

		// Label w/ txtboxes 
		this.add(amntLabel, 0, 3);
		amntLabel.setStyle("-fx-font: normal normal 15px 'consolas' ");
		GridPane.setHalignment(amntLabel, HPos.RIGHT);
		
		this.add(txt, 1, 3);
		
		this.add(billLabel, 2, 3);
		billLabel.setStyle("-fx-font: normal normal 15px 'consolas' ");
		GridPane.setHalignment(billLabel, HPos.RIGHT);

		this.add(billChoiceBox, 3, 3);

		// BUTTONS
		this.add(enter, 0, 4, 2, 1);
		enter.setStyle("-fx-font: normal normal 20px 'consolas' ");
		enter.setShape(new Circle(3));
		GridPane.setHalignment(enter, HPos.CENTER);
		
		this.add(pay, 1, 4, 2, 1);
		pay.setStyle("-fx-font: normal normal 25px 'consolas' ");
		pay.setShape(new Circle(3));
		GridPane.setHalignment(pay, HPos.CENTER);
		
		this.add(newW, 2, 4, 2, 1);
		newW.setStyle("-fx-font: normal normal 15px 'consolas' ");
		GridPane.setHalignment(newW, HPos.CENTER);
		
		this.add(clear, 1, 4, 3, 1);
		clear.setStyle("-fx-font: normal normal 15px 'consolas' ");
		GridPane.setHalignment(clear, HPos.RIGHT);
		
		this.add(btnMenu, 3, 6);
		GridPane.setHalignment(btnMenu, HPos.RIGHT);
		btnMenu.setStyle("-fx-background-color: white; "
				+ "-fx-font: normal normal 15px 'consolas' ");
		btnMenu.setShape(new Rectangle(2, 2));
		btnMenu.setTextFill(Color.DARKBLUE);
		
		this.add(btnLogout, 0, 6);  
		btnLogout.setStyle("-fx-background-color: white; "
				+ "-fx-textfill: red; "
				+ "-fx-font: normal normal 15px 'consolas' ");
		btnLogout.setShape(new Rectangle(2, 2));
		btnLogout.setTextFill(Color.RED);


		//Setting the back ground color 
		this.setStyle("-fx-background-color: Silver;");
	}
	
}