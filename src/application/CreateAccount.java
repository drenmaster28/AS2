package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import node.*;

public class CreateAccount extends GridPane{
	
	Button btnNAccount = new Button();
	Button btnExit = new Button();
	Button btnShowLogin = new Button();
	TextField INPUT_fname;
	TextField INPUT_lname; 
	TextField INPUT_dob;
	TextField INPUT_pwd;
	TextArea txtA;
	
	
	public CreateAccount (int width, int height) {
	
		// Labels
		Text f_name = new Text("First Name:");
		Text l_name = new Text("Last Name: ");
		Text dob = new Text("Date of Birth: (DD/MM/YYYY) ");
		Text pwd = new Text("Enter your password: ");
		
		// Text fields for user name and password
		INPUT_fname = new TextField(); 
		INPUT_lname = new TextField();  
		INPUT_dob = new TextField(); 
		INPUT_pwd = new TextField(); 
		
		txtA = new TextArea();
		
		// Grid pane
		this.setMinSize(width, height);

		this.setPadding(new Insets(10, 10, 10, 10));
		
		this.setVgap(5);
		this.setHgap(5);
		
		this.setAlignment(Pos.CENTER);
		
		// Adding to grid
		this.add(f_name, 0, 0);
		this.add(INPUT_fname, 1, 0);
		
		this.add(l_name, 0, 1);
		this.add(INPUT_lname, 1, 1);
		
		this.add(dob, 0, 2);
		this.add(INPUT_dob, 1, 2);
		
		this.add(pwd, 0, 3);
		this.add(INPUT_pwd, 1, 3);
		
		this.add(txtA, 0, 5);
		
		btnNAccount = new Button("Create Account");
		this.add(btnNAccount, 1, 4);
		
		btnShowLogin = new Button("Login");
		this.add(btnShowLogin, 4, 4);
		
		btnExit = new Button("Exit");
		this.add(btnExit, 1, 8);
	}
}