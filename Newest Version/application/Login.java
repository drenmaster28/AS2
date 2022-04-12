package application;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Login extends GridPane {

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

		btnShowLogin = new Button("Login");
		btnNAccount = new Button("Create Account");
		Button btnExit = new Button("Exit");
		// Grid pane

		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(5);
		this.setHgap(10);
		this.setAlignment(Pos.CENTER);

		// Adding to grid
		this.add(L_username, 0, 0);
		this.add(INPUT_username, 1, 0);

		this.add(L_pwd, 0, 1);
		this.add(INPUT_pwd, 1, 1);

		this.add(btnShowLogin, 0, 3, 1, 1);
		this.add(btnNAccount, 0, 3, 2, 1);
		this.add(btnExit, 2, 8);

		L_username.setStyle("-fx-font: normal normal 18px 'consolas' ");
		L_pwd.setStyle("-fx-font: normal normal 18px 'consolas' ");
		btnShowLogin.setStyle("-fx-font: normal normal 13px 'consolas' ");
		GridPane.setHalignment(btnShowLogin, HPos.RIGHT);
		btnNAccount.setStyle("-fx-font: normal normal 13px 'consolas' ");
		GridPane.setHalignment(btnNAccount, HPos.RIGHT);

		// Setting the back ground color
		this.setStyle("-fx-background-color: darkGray;");

		btnExit.setOnAction((event) -> {
			Platform.exit();
		});
	}
}