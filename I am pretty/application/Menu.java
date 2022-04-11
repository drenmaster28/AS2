package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Menu extends GridPane {

	Button btnShowBalance;
	Button btnDeposit;
	Button btnWithdraw;
	Button btnLogout;
	Text title;
	Text title2;
	
	public Menu() {
				
		title = new Text("Welcome!");
		
		Text balance = new Text("View your current balance: ");
		btnShowBalance = new Button(" > ");

		Text deposit = new Text("Make a deposit: ");
		btnDeposit = new Button(" > ");
		
		Text withdraw = new Text("Withdraw or Pay a bill: ");
		btnWithdraw = new Button(" > ");

		btnLogout = new Button("LOGOUT");
		
		// Set up grid pane
		this.setMinSize(300, 200);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setHgap(15);
		this.setVgap(10); 
		
		// Arrange grid
		this.add(title, 0, 0, 3, 1);
		GridPane.setHalignment(title, HPos.CENTER);

		// Balance option
		this.add(balance, 1, 2);
		this.add(btnShowBalance, 2, 2);
		GridPane.setHalignment(balance, HPos.RIGHT);
		
		// Deposit option
		this.add(deposit, 1, 3);
		this.add(btnDeposit, 2, 3);
		GridPane.setHalignment(deposit, HPos.RIGHT);
		
		// Withdraw option
		this.add(withdraw, 1, 4);
		this.add(btnWithdraw, 2, 4);
		GridPane.setHalignment(withdraw, HPos.RIGHT);
		
		// Logout
		this.add(btnLogout, 0, 5);
		
		// Format labels & buttons
		title.setStyle("-fx-font: normal bolder 50px 'franklin gothic' ");
		title.setFill(Color.DARKGREEN);
		
		balance.setStyle("-fx-font: italic lighter 17px 'bahnschrift' ");
		deposit.setStyle("-fx-font: italic lighter 17px 'bahnschrift' ");
		withdraw.setStyle("-fx-font: italic lighter 17px 'bahnschrift' ");
		
		btnShowBalance.setStyle("-fx-background-color: white; -fx-textfill: green;");
		btnShowBalance.setShape(new Circle(1.5));
		
		btnDeposit.setStyle("-fx-background-color: white; -fx-textfill: green;");
		btnDeposit.setShape(new Circle(1.5));
		
		btnWithdraw.setStyle("-fx-background-color: white; -fx-textfill: green;");
		btnWithdraw.setShape(new Circle(1.5));

		btnLogout.setStyle("-fx-background-color: white; -fx-textfill: red;");
		btnLogout.setShape(new Circle(1.5));

		//Setting the back ground color 
		this.setStyle("-fx-background-color: Silver;"); 
	}
}