package application;
	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import node.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class A2_Main extends Application {
	
	private String string;

	public void start(Stage primaryStage) {
		try {
			userData u = new userData();
			String filename = "./src/BANK_MEMBERS.csv";
//			ArrayList <Chequing> cheA  = new ArrayList <Chequing>();
//			ArrayList <Saving> savA  = new ArrayList <Saving>();
			//u.getChequing(filename);
			
			Chequing c = u.getChequing(filename).get(0);
			Saving s = u.getSaving(filename).get(0);
			c.setBalance(0.0);
			s.setBalance(0.0);
			c.setBillName("Phone Bill");
			s.setBillName("Phone Bill");
			c.setBillAmount(200.00);
			s.setBillAmount(200.00);
			
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
				
			createAccount.btnShowLogin.setOnAction((event)->{
				if (login.INPUT_username.getText().equals(c.getUsername()) && 
						login.INPUT_pwd.getText().equals(c.getPassword())) {
					menu.gName.replaceAll(string, c.getfName());
					primaryStage.setScene(scene2);
				}
			});
			
			login.btnNAccount.setOnAction((event)->{
				primaryStage.setScene(scene6);
			});
			
			createAccount.btnNAccount.setOnAction((event) -> {
				Chequing account;
				Saving sAccount;
				//String option = checkOrSav.getText();
				String fname = createAccount.INPUT_fname.getText();
				String lname = createAccount.INPUT_lname.getText();
				String birthday = createAccount.INPUT_dob.getText();
				String password = createAccount.INPUT_pwd.getText();	
				
					account = new Chequing(fname,lname,birthday);
					sAccount = new Saving(fname,lname,birthday);
					
					c.setUsername(account.generateUser());
					c.setPassword(password);
					c.setfName(fname);
					c.setlName(lname);
					c.setDob(birthday);
					
					s.setUsername(account.generateUser());
					s.setPassword(password);
					s.setfName(fname);
					s.setlName(lname);
					s.setDob(birthday);
					
					createAccount.txtA.appendText(c.getUsername()+" "+c.getPassword());
			});
//			
//			createAccount.btnShowLogin.setOnAction((event)->{
//				primaryStage.setScene(scene2);
//			});
			
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
			
			balance.enter.setOnAction((event)->{
			if
			(balance.balancechoiceBox.getValue().equals("Both")) {
				balance.txtbx.clear();
				Double bal = c.getBalance() + s.getBalance();
				String money = bal.toString();
				balance.txtbx.appendText(money);
			}
			else if (balance.balancechoiceBox.getValue().equals("Chequing")) {
				balance.txtbx.clear();
				Double bal = c.getBalance();
				String money = bal.toString();
				balance.txtbx.appendText(money);
			}
			else if (balance.balancechoiceBox.getValue().equals("Saving")) {
				balance.txtbx.clear();
				Double bal = s.getBalance();
				String money = bal.toString();
				balance.txtbx.appendText(money);
			}
			});
			
			deposit.deposit.setOnAction((event)->{
				if (deposit.depositchoiceBox.getValue().equals("Chequing")) {
				Double amount = Double.valueOf(deposit.txt.getText());
				double total = c.getBalance() + amount;
				c.setBalance(total);
				}
				else if (deposit.depositchoiceBox.getValue().equals("Savings")) {
					Double amount = Double.valueOf(deposit.txt.getText());
					double total = s.getBalance() + amount;
					s.setBalance(total);
				}
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
			
			withdraw.enter.setOnAction((event)->{
				if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.w) && 
						withdraw.accountChoiceBox.getValue().equals("Chequing")) {
					Double amount = Double.valueOf(withdraw.txt.getText());
					double total = c.getBalance() - amount;
					c.setBalance(total);
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.w) && 
						withdraw.accountChoiceBox.getValue().equals("Savings")) {
					Double amount = Double.valueOf(withdraw.txt.getText());
					double total = s.getBalance() - amount;
					s.setBalance(total);
				}
			});
			
			withdraw.pay.setOnAction((event)->{
				if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.pb) && 
						withdraw.accountChoiceBox.getValue().equals("Chequing") &&
						withdraw.billChoiceBox.getText().equals(c.getBillName())) {
					
					double total = c.getBalance() - c.getBillAmount();
					c.setBalance(total);
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.pb) && 
						withdraw.accountChoiceBox.getValue().equals("Savings") &&
						withdraw.billChoiceBox.getText().equals(s.getBillName())) {
					
					double total = s.getBalance() - s.getBillAmount();
					s.setBalance(total);
				}
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
