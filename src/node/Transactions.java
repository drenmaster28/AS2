package node;

public class Transactions extends Account{

	private double balance;
	
	public Transactions(double balance) {
		this.balance = balance;
	}
	
	public void deposit (double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("Balance after withdraw: " + balance);
		} else {
			System.out.println("Insuffient Funds");
		}
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		
	}
}
