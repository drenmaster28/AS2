package application;

import javafx.geometry.HPos;

//import java.awt.TextArea;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextArea;

public class Balance extends GridPane{

	Button btnLogout;
	Button btnMenu;
	Button enter;
	Button Chequing;
	Button Saving;
	ChoiceBox<String> balancechoiceBox;
	TextArea txtbx;
	
	public Balance() {
		
		Text balanceTitle = new Text("VIEW YOUR BALANCE");
		
		Text balanceLabel = new Text("ACCOUNT:"); 
	      
		//Choice box for location 
		Chequing = new Button("Chequing");
		Saving = new Button("Saving");
		balancechoiceBox = new ChoiceBox<String>(); 
		balancechoiceBox.getItems().addAll("Chequing", "Savings", "Both");
		
		txtbx = new TextArea();
		txtbx.setEditable(false);
		
		// buttons
		btnMenu = new Button("BACK TO MENU");
		btnLogout = new Button("LOGOUT");
		enter = new Button("ENTER");

		// Set up grid pane
		this.setMinSize(400, 100);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setVgap(20); 
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);

		// 	TITLE
		this.add(balanceTitle, 0, 0, 3, 1);
		GridPane.setHalignment(balanceTitle, HPos.CENTER);
		
		balanceTitle.setStyle("-fx-font: normal normal 40px 'consolas' ");
		balanceTitle.setFill(Color.BLACK);
		
		// ACCOUNT OPTIONS
		this.add(balanceLabel, 0, 1);
		GridPane.setHalignment(balanceLabel, HPos.CENTER);

		this.add(balancechoiceBox, 1, 1);
		balancechoiceBox.setPrefWidth(150);
		balancechoiceBox.setPrefHeight(50);

		// BUTTONS 
		this.add(enter, 2, 1);
		enter.setStyle("-fx-font: normal normal 18px 'consolas' ");
		GridPane.setHalignment(enter, HPos.CENTER);
		
		// Display
		this.add(txtbx, 0, 2, 3, 1);
		txtbx.setStyle("-fx-font: normal normal 18px 'consolas' ");
		txtbx.setPrefWidth(100);
		txtbx.setPrefHeight(50);
		GridPane.setHalignment(txtbx, HPos.CENTER);
		
		// Format labels
		balanceLabel.setStyle("-fx-font: normal normal 20px 'consolas' ");
		balancechoiceBox.setStyle("-fx-font: normal normal 18px 'consolas' ");
		balancechoiceBox.setShape(new Rectangle(5, 5));
		
		// BUTTONS
		this.add(btnMenu, 2, 3);
		this.add(btnLogout, 0, 3);  
		
		// Logout Button
		btnLogout.setStyle("-fx-background-color: white; "
				+ "-fx-textfill: red; "
				+ "-fx-font: normal normal 15px 'consolas' ");
		btnLogout.setShape(new Rectangle(2, 2));
		btnLogout.setTextFill(Color.RED);
		
		// Back to menu Button
		btnMenu.setStyle("-fx-background-color: white; "
				+ "-fx-font: normal normal 15px 'consolas' ");
		btnMenu.setShape(new Rectangle(2, 2));
		btnMenu.setTextFill(Color.DARKBLUE);
		
		//Setting the back ground color 
		this.setStyle("-fx-background-color: Silver;");
	}
}