package application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;

public class Login extends GridPane{

	Button btnShowLogin;
	Button btnNAccount;
	Button btnLogout;
	TextField INPUT_username;  
	TextField INPUT_pwd;  
	
	public Login() {
		
		// Labels
		Text L_username = new Text("Username:");
		Text L_pwd = new Text("Password: ");
		
		
		// Text fields for user name and password
		INPUT_username = new TextField();  
		INPUT_pwd = new TextField();  

		// Grid pane
//		this.setMinSize(width, height);

		this.setPadding(new Insets(10, 10, 10, 10));
		
		this.setVgap(5);
		this.setHgap(5);
		
		this.setAlignment(Pos.CENTER);
		
		// Adding to grid
		this.add(L_username, 0, 0);
		this.add(INPUT_username, 1, 0);
		
		this.add(L_pwd, 0, 1);
		this.add(INPUT_pwd, 1, 1);
	
		
		btnShowLogin = new Button("Login");
		this.add(btnShowLogin, 0, 3);
		
		btnNAccount = new Button("Create Account");
		
		this.add(btnNAccount, 1, 3);
		
		Button btnExit = new Button("Exit");
		this.add(btnExit, 2, 8);
	}
}
	