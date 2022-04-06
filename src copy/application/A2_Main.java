package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import node.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class A2_Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			userData u = new userData();
			String filename = "./src/BANK_MEMBERS.csv";
			u.getChequing(filename);
			
			Chequing c = u.getChequing(filename).get(0);
			Saving s = u.getSaving(filename).get(0);
			
			Login login = new Login();
			Scene scene1 = new Scene(login);
			
			Menu menu = new Menu();
			Scene scene2 = new Scene(menu);
			
			Balance balance = new Balance(500, 500);
			Scene scene3 = new Scene(balance);

			Deposit deposit= new Deposit();
			Scene scene4 = new Scene(deposit, 400, 400);
			
			Withdraws withdraw = new Withdraws();
			Scene scene5 = new Scene(withdraw);
			
			CreateAccount createAccount = new CreateAccount(400,400);
			Scene scene6 = new Scene(createAccount);
				
			login.btnShowLogin.setOnAction((event)->{
				c.setUsername(c.generateUser());
				c.setPassword("12345678");
				if (login.INPUT_username.getText().equals(c.getUsername()) && 
						login.INPUT_pwd.getText().equals(c.getPassword())) {
					primaryStage.setScene(scene2);
				}
				
			});
			
			login.btnNAccount.setOnAction((event)->{
				primaryStage.setScene(scene6);
			});
			
			createAccount.btnExit.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			menu.btnShowBalance.setOnAction((event)->{
				primaryStage.setScene(scene3);
			});
			
			menu.btnDeposit.setOnAction((event)->{
				primaryStage.setScene(scene4);
			});
			
			menu.btnWithdraw.setOnAction((event)->{
				primaryStage.setScene(scene5);
			});

			// Logout button
			menu.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			balance.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			deposit.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			withdraw.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			// Back to Menu buttons
			balance.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			
			deposit.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			
			withdraw.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Login");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}