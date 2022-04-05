package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Withdraws extends GridPane{

	Button btnLogout;
	Button btnMenu;
	
	public Withdraws() {

		Text withdrawTitle = new Text("WITHDRAW or PAY A BILL");
		
		Text withdrawLabel = new Text("Chose option below: ");
		
		// Toggle buttons
		ToggleButton w = new ToggleButton("Withdraw to Cash"); 
		ToggleButton pb = new ToggleButton("Pay a bill"); 
		ToggleGroup withdrawalToggle = new ToggleGroup(); 
		w.setToggleGroup(withdrawalToggle);   
		pb.setToggleGroup(withdrawalToggle); 

		
		
		// Buttons
		btnMenu = new Button("Back to Menu");
		btnLogout = new Button("LOGOUT");

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

		this.add(btnMenu, 2, 7);
		this.add(btnLogout, 2, 8);
	}
	
}
