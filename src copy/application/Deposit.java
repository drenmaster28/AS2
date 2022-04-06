package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Deposit extends GridPane{

	Button btnLogout;
	Button btnMenu;
	
	public Deposit() {
		
		Text depositTitle = new Text("DEPOSIT");
		
		Text depositLabel = new Text("Chose account: ");
	
		//Choice box for account 
		ChoiceBox<String> depositchoiceBox = new ChoiceBox<String>(); 
		depositchoiceBox.getItems().addAll("Chequing","Savings");
		
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
		this.add(depositTitle, 1, 0);

		this.add(depositLabel, 1, 2);
		this.add(depositchoiceBox, 1, 4);

		this.add(btnMenu, 2, 7);
		this.add(btnLogout, 2, 8); 

	}
	
}