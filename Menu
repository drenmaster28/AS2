package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Menu extends GridPane {

	Button btnShowBalance;
	Button btnDeposit;
	Button btnWithdraw;
	Button btnLogout;
	
	public Menu() {
		
		Text title = new Text("SELECT FROM OPTION BELOW: ");
		
		Text balance = new Text("View your current balance: ");
		btnShowBalance = new Button(" > ");

		Text deposit = new Text("Make a deposit: ");
		btnDeposit = new Button(" > ");
		
		Text withdraw = new Text("Withdraw or Pay a bill ");
		btnWithdraw = new Button(" > ");

		btnLogout = new Button("LOGOUT");
		
		// Set up grid pane
		this.setMinSize(400, 200);
		this.setPadding(new Insets(10, 10, 10, 10)); 
		this.setVgap(5); 
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);
		
		// Arrange grid
		this.add(title, 1, 0);
		
		// Balance option
		this.add(balance, 0, 1);
		this.add(btnShowBalance, 1, 1);
		
		// Deposit option
		this.add(deposit, 0, 2);
		this.add(btnDeposit, 1, 2);
		
		// Withdraw option
		this.add(withdraw, 0, 3);
		this.add(btnWithdraw, 1, 3);
		
		// Buttons
		this.add(btnLogout, 3, 4);
		
		// Format labels
		title.setStyle("-fx-font: normal bolder 30px 'fantasy' ");
		balance.setStyle("-fx-font: normal lighter 15px 'sans-serif' ");
		deposit.setStyle("-fx-font: normal lighter 15px 'sans-serif' ");
		withdraw.setStyle("-fx-font: normal lighter 15px 'sans-serif' ");
		
	}
}
