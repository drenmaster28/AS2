package application;
	
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import node.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class A2_Main extends Application {
	
	public void start(Stage primaryStage) {
		try {

			userData u = new userData();
			String filename = "./src/BANK_MEMBERS.csv";
			ArrayList <Chequing> cheA  = u.getChequing(filename);
			ArrayList <Saving> savA  = u.getSaving(filename);
			int sizeC= cheA.size()-1;
			int sizeS= savA.size()-1;

			Chequing c = u.getChequing(filename).get(sizeC);
			Saving s = u.getSaving(filename).get(sizeS);
			
			FileWriter fw = new FileWriter(filename,true);
			PrintWriter pw = new PrintWriter(fw);
			c.setBalance(0.00);
			s.setBalance(0.00);
			c.setBillName("Phone Bill");
			s.setBillName("Phone Bill");
			c.setBillAmount(200.00);
			s.setBillAmount(200.00);

			Login login = new Login();
			Scene scene1 = new Scene(login);

			Menu menu = new Menu();
			Scene scene2 = new Scene(menu);

			Balance balance = new Balance();
			Scene scene3 = new Scene(balance);

			Deposit deposit= new Deposit();
			Scene scene4 = new Scene(deposit);

			Withdraws withdraw = new Withdraws();
			Scene scene5 = new Scene(withdraw);

			CreateAccount createAccount = new CreateAccount(400,400);
			Scene scene6 = new Scene(createAccount);

			// Login Scene (First Page)
			login.btnShowLogin.setOnAction((event)->{

				for(int i = 0 ; i < cheA.size(); i++) {
					Account w = u.getChequing(filename).get(i);
					if (login.INPUT_username.getText().equals(w.getUsername()) && 
							login.INPUT_pwd.getText().equals(w.getPassword())) {

						//menu.name = w.getfName();
						primaryStage.setScene(scene2);
						login.INPUT_username.clear();
						login.INPUT_pwd.clear();
					}
				}
			});

			login.btnNAccount.setOnAction((event)->{
				primaryStage.setScene(scene6);
			});

			// Create Account Scene 
			createAccount.btnNAccount.setOnAction((event) -> {
				String fname = createAccount.INPUT_fname.getText();
				String lname = createAccount.INPUT_lname.getText();
				LocalDate l = createAccount.cal.getValue();
				String pattern = "dd/MM/yyyy";
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
				String birthday = l.format(dateFormatter);
				String password = createAccount.INPUT_pwd.getText();
				int size = birthday.length();
				String username = fname.substring(0,1)+
						lname+birthday.substring(size-2);
				if(password.length() >= 8) {

					pw.println(fname + "," + lname + "," + birthday + "," + username + "," + password);

					createAccount.txtA.appendText("Your account has been created: ");
					createAccount.txtA.appendText("\n-----------");
					createAccount.txtA.appendText("\nUsername: " + username);
					createAccount.txtA.appendText("\nPassword: " + password);
					createAccount.txtA.appendText("\n-----------");
					createAccount.txtA.appendText("\nTo login in press the 'END SESSION' below & open a new page to login");
					pw.close();
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
					createAccount.INPUT_pwd.clear();
					createAccount.INPUT_pwd.appendText("Invalid Password");	
				}
			});
			
			// Main Menu Buttons
			createAccount.btnExit.setOnAction((event)->{
				Platform.exit();
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
				login.INPUT_username.clear();
				login.INPUT_pwd.clear();
				primaryStage.setScene(scene1);
			});

			// Balance Scene
			balance.btnLogout.setOnAction((event)->{
				login.INPUT_username.clear();
				login.INPUT_pwd.clear();
				primaryStage.setScene(scene1);
			});

			balance.enter.setOnAction((event)->{
				if
				(balance.balancechoiceBox.getValue().equals("Both")) {
					balance.txtbx.clear();
					Double bal = c.getBalance() + s.getBalance();
					Double rbal = (double) (Math.round(bal*100.00)/100.00);
					String money = rbal.toString();
					balance.txtbx.appendText("$" + money);
				}
				else if (balance.balancechoiceBox.getValue().equals("Chequing")) {
					balance.txtbx.clear();
					Double bal = c.getBalance();
					Double rbal = (double) (Math.round(bal*100.00)/100.00);
					String money = rbal.toString();
					balance.txtbx.appendText("$" + money);
				}
				else if (balance.balancechoiceBox.getValue().equals("Savings")) {
					balance.txtbx.clear();
					Double bal = s.getBalance();
					Double rbal = (double) (Math.round(bal*100.00)/100.00);
					String money = rbal.toString();
					balance.txtbx.appendText("$" + money);
				}
			});
			
			// Deposit Scene
			deposit.deposit.setOnAction((event)->{
				if (deposit.depositchoiceBox.getValue().equals("Chequing")) {
					Double amount = Double.valueOf(deposit.txt.getText());
					double total = c.getBalance() + amount;
					c.setBalance(total);
					deposit.txt.clear();
				}
				else if (deposit.depositchoiceBox.getValue().equals("Savings")) {
					Double amount = Double.valueOf(deposit.txt.getText());
					double total = s.getBalance() + amount;
					s.setBalance(total);
					deposit.txt.clear();
				}
			});

			// Withdraws Scene
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
					withdraw.billChoiceBox.clear();
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.pb) && 
						withdraw.accountChoiceBox.getValue().equals("Savings") &&
						withdraw.billChoiceBox.getText().equals(s.getBillName())) {

					double total = s.getBalance() - s.getBillAmount();
					s.setBalance(total);
					withdraw.billChoiceBox.clear();
				}
			});

			withdraw.newW.setOnAction((event)->{
				withdraw.txt.clear();
				withdraw.billChoiceBox.clear();
				primaryStage.setScene(scene5);
			});

			withdraw.clear.setOnAction((event)->{
				if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.w) && 
						withdraw.accountChoiceBox.getValue().equals("Chequing")) {
					Double amount2 = Double.valueOf(withdraw.txt.getText());
					double total2 = c.getBalance() + amount2;
					c.setBalance(total2);
					withdraw.txt.clear();
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.w) && 
						withdraw.accountChoiceBox.getValue().equals("Savings")) {
					Double amount = Double.valueOf(withdraw.txt.getText());
					double total = s.getBalance() + amount;
					s.setBalance(total);
					withdraw.txt.clear();
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.pb) && 
						withdraw.accountChoiceBox.getValue().equals("Chequing") &&
						withdraw.billChoiceBox.getText().equals(c.getBillName())) {

					double total = c.getBalance() + c.getBillAmount();
					c.setBalance(total);
					withdraw.billChoiceBox.clear();
				}
				else if (withdraw.withdrawalToggle.getSelectedToggle().equals(withdraw.pb) && 
						withdraw.accountChoiceBox.getValue().equals("Savings") &&
						withdraw.billChoiceBox.getText().equals(s.getBillName())) {

					double total = s.getBalance() + s.getBillAmount();
					s.setBalance(total);
					withdraw.billChoiceBox.clear();
				}
			});
			
			// Logout & Menu buttons
			deposit.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			deposit.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			

			withdraw.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			withdraw.btnLogout.setOnAction((event)->{
				primaryStage.setScene(scene1);
			});
			
			balance.btnMenu.setOnAction((event)->{
				primaryStage.setScene(scene2);
			});
			
			// Setting Primary Stage
			primaryStage.setScene(scene1);
			primaryStage.setTitle("BANK");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}
}