package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
		
		Text withdrawLabel = new Text("Chose option below: ");
		
		Text billLabel = new Text("Bill Name: ");
		
		// Toggle buttons
		w = new ToggleButton("Withdraw"); 
		pb = new ToggleButton("Pay a bill"); 
		withdrawalToggle = new ToggleGroup(); 
		w.setToggleGroup(withdrawalToggle);   
		pb.setToggleGroup(withdrawalToggle); 
		accountChoiceBox = new ChoiceBox<String>(); 
		accountChoiceBox.getItems().addAll("Chequing","Savings");
		billChoiceBox = new TextField(); 
		
		txt = new TextField();
		enter = new Button("Enter");
		pay = new Button("Pay");
		
		// Buttons
		btnMenu = new Button("Back to Menu");
		btnLogout = new Button("LOGOUT");
		clear =new Button("Clear");
		newW = new Button("New Withdraw");

		// Set up grid pane
		this.setMinSize(400, 200);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setVgap(5); 
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);

		// Arrange grid
		this.add(withdrawTitle, 1, 0);

		this.add(withdrawLabel, 1, 2);
		this.add(w, 1, 4);
		this.add(pb, 2, 4);
		this.add(billLabel, 3, 4);
		this.add(billChoiceBox, 3, 5);
		this.add(pay, 3, 6);
		this.add(accountChoiceBox,1,5);
		this.add(txt,1,6);
		this.add(enter,1,7);
		this.add(btnMenu, 2, 8);
		this.add(btnLogout, 2, 9);
		this.add(clear,1,10);
		this.add(newW,1,11);
	}
	
}