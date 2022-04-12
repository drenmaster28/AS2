package node;

public class Chequing extends Account {

	public Chequing(String fName, String lName, String dob) {
		super(fName, lName, dob);

	}

	private double cBalance;

	public double getBalance() {
		return cBalance;
	}

	public void setBalance(double balance) {
		if (balance < 0) {
			cBalance = 0.0;
		} else {
			cBalance = balance;
		}
	}

}
