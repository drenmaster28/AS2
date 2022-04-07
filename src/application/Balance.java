package application;

//import java.awt.TextArea;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

public class Balance extends GridPane{

	Button btnLogout;
	Button btnMenu;
	Button enter;
	Button Chequing;
	Button Saving;
	ChoiceBox<String> balancechoiceBox;
	TextArea txtbx;
	
	public Balance(int width, int height) {
		
		Text balanceTitle = new Text("BALANCE");
		
		Text balanceLabel = new Text("Choose account: "); 
	      
		//Choice box for location 
		Chequing = new Button("Chequing");
		Saving = new Button("Saving");
		balancechoiceBox = new ChoiceBox<String>(); 
		balancechoiceBox.getItems().addAll("Chequing", "Saving", "Both");
		txtbx = new TextArea();

		// Menu button
		
		btnMenu = new Button("Back to Menu");
		btnLogout = new Button("LOGOUT");
		enter = new Button("Enter");
		

		// Set up grid pane
		this.setMinSize(400, 200);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setVgap(5); 
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);

		// Arrange grid
		this.add(balanceTitle, 1, 0);
		
		this.add(balanceLabel, 1, 2);
		this.add(balancechoiceBox, 1, 4);
//		this.add(Chequing,1,5);
//		this.add(Saving, 1, 6);
		this.add(enter, 2, 4);
		this.add(txtbx, 2, 7);
		
		this.add(btnMenu, 2, 8);
		this.add(btnLogout, 2, 9);  
		
		
		// Format labels
		balanceTitle.setStyle("-fx-font: normal bold 30px 'serif' ");
		balanceLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
		balancechoiceBox.setStyle("-fx-font: normal bold 15px 'serif' ");

	}

}