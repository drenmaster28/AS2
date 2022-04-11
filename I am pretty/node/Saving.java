package node;

public class Saving extends Account{

	private double sBalance;

	public Saving(String fName, String lName, String dob) {
		super(fName, lName, dob);
	}

	public double getBalance() {
		return sBalance;
	}

	public void setBalance(double balance) {
		sBalance = balance;
	}
}