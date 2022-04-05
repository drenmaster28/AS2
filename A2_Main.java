package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class A2_Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
		
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
				
			login.btnShowLogin.setOnAction((event)->{
				primaryStage.setScene(scene2);
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
