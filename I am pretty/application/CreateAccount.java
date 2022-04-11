package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.collections.FXCollections;
import node.*;

public class CreateAccount extends GridPane{
	
	Button btnNAccount = new Button();
	Button btnExit = new Button();
	TextField INPUT_fname;
	TextField INPUT_lname; 
	TextField INPUT_dob;
	TextField INPUT_pwd;
	TextArea txtA;
	DatePicker cal;
	LocalDate date;
	
public CreateAccount (int width, int height) {
	
		// Labels
		Text pTitle = new Text("CREATE NEW ACCOUNT:");
		
		Text f_name = new Text("First Name:");
		Text l_name = new Text("Last Name: ");
		Text dob = new Text("Date of Birth: ");
		Text pwd = new Text("Enter your password: ");
		
		// Text fields for user name and password
		INPUT_fname = new TextField(); 
		INPUT_lname = new TextField();  
		
		cal = new DatePicker(date);
		cal.getEditor().setDisable(true);

		INPUT_pwd = new TextField(); 
		txtA = new TextArea();

		btnNAccount = new Button("Create Account");
		btnExit = new Button("End Session");
		
		// Grid pane
		this.setMinSize(10, 10);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(15);
		this.setHgap(15);
		this.setAlignment(Pos.CENTER);
		
		// Adding to grid
		this.add(pTitle, 0, 0, 4, 1);
		pTitle.setStyle("-fx-font: normal normal 35px 'consolas' ");
		pTitle.setFill(Color.BLACK);
		GridPane.setHalignment(pTitle, HPos.CENTER);

		this.add(f_name, 0, 1);
		this.add(INPUT_fname, 1, 1);
		
		this.add(l_name, 0, 2);
		this.add(INPUT_lname, 1, 2);
		
		this.add(dob, 0, 3);
		this.add(cal, 1, 3);
		
		this.add(pwd, 0, 4);
		this.add(INPUT_pwd, 1, 4);
		
		this.add(txtA, 0, 6, 3, 2);
		txtA.setWrapText(true);
		txtA.setEditable(false);
		
		this.add(btnNAccount, 1, 5, 2, 1);
		GridPane.setHalignment(btnNAccount, HPos.RIGHT);
		this.add(btnExit, 1, 8);

		f_name.setStyle("-fx-font: normal normal 15px 'consolas' ");
		l_name.setStyle("-fx-font: normal normal 15px 'consolas' ");
		dob.setStyle("-fx-font: normal normal 15px 'consolas' ");
		pwd.setStyle("-fx-font: normal normal 15px 'consolas' ");
		btnNAccount.setStyle("-fx-background-color: green; "
					+ "-fx-font: normal normal 10px 'consolas' ");
		btnNAccount.setTextFill(Color.WHITE);
		btnExit.setStyle("-fx-font: normal normal 15px 'consolas' ");
		txtA.setStyle("-fx-font: normal normal 15px 'consolas' ");
		
		//Setting the back ground color 
		this.setStyle("-fx-background-color: lightsteelblue ;");
	}
}
