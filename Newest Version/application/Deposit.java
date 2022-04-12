package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Deposit extends GridPane {

	Button btnLogout;
	Button btnMenu;
	Button deposit;
	Button clear;
	TextField txt;
	ChoiceBox<String> depositchoiceBox;

	public Deposit() {

		Text depositTitle = new Text("DEPOSIT");
		Text depositLabel = new Text("ACCOUNT:");
		Text amountLabel = new Text("AMOUNT: ");

		// Choice box for account
		depositchoiceBox = new ChoiceBox<String>();
		depositchoiceBox.getItems().addAll("Chequing", "Savings");
		txt = new TextField();

		// Buttons
		btnMenu = new Button("BACK TO MENU");
		btnLogout = new Button("LOGOUT");
		deposit = new Button("DEPOSIT");
		clear = new Button("CLEAR");
		
		// Set up grid pane
		this.setMinSize(200, 400);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(20);
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);

		// Arrange grid

		// Title
		this.add(depositTitle, 0, 0, 3, 1);
		GridPane.setHalignment(depositTitle, HPos.CENTER);

		depositTitle.setStyle("-fx-font: normal normal 40px 'consolas' ");
		depositTitle.setFill(Color.BLACK);

		// ACCOUNT OPTIONS
		this.add(depositLabel, 0, 1);
		GridPane.setHalignment(depositLabel, HPos.CENTER);
		depositLabel.setStyle("-fx-font: normal normal 20px 'consolas' ");

		this.add(depositchoiceBox, 2, 1);
		depositchoiceBox.setStyle("-fx-font: normal normal 18px 'consolas' ");

		// AMOUNT
		this.add(amountLabel, 0, 2);
		GridPane.setHalignment(amountLabel, HPos.CENTER);
		amountLabel.setStyle("-fx-font: normal normal 20px 'consolas' ");

		// BUTTONS
		this.add(txt, 2, 2);
		this.add(deposit, 2, 3);
		this.add(clear,2,4);

		// BUTTON FORMATS
		deposit.setStyle("-fx-font: normal normal 15px 'consolas' ");
		deposit.setShape(new Circle(1.5));
		clear.setStyle("-fx-font: normal normal 15px 'consolas' ");
		clear.setShape(new Circle(1.5));

		// BUTTONS
		this.add(btnMenu, 2, 5);
		this.add(btnLogout, 0, 5);

		// Logout Button
		btnLogout.setStyle(
				"-fx-background-color: white; " + "-fx-textfill: red; " + "-fx-font: normal normal 15px 'consolas' ");
		btnLogout.setShape(new Rectangle(2, 2));
		btnLogout.setTextFill(Color.RED);

		// Back to menu Button
		btnMenu.setStyle("-fx-background-color: white; " + "-fx-font: normal normal 15px 'consolas' ");
		btnMenu.setShape(new Rectangle(2, 2));
		btnMenu.setTextFill(Color.DARKBLUE);

		// Setting the back ground color
		this.setStyle("-fx-background-color: Silver;");

	}

}