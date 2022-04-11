package node;

public abstract class Account{

	public Account(String fName, String lName, String dob) {
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
	}

	public Account() {
	}

	private String fName;
	private String lName;
	private String dob;
	private String username;
	private String password;
	private double balance;
	private String billName;
	private double billAmount;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String generateUser() {
		int size = getDob().length();
		String gusername = getfName().substring(0,1)+
				getlName()+getDob().substring(size-2);
		return gusername;
	}

	public abstract double getBalance();

	public abstract void setBalance(double balance);

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getTotalBalance() {
		return balance;
	}
}