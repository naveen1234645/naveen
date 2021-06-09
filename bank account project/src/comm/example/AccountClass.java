package comm.example;

public class AccountClass {
	private String id;
	private String name;
	private double balance;
	private AccountType accountType;
	public AccountClass() {
		super();
	}

	public void createAcount(String id, String name, double balance, AccountType accountType)
	{
		this.id=id;
		this.name=name;
		this.balance=balance;
		this.accountType=accountType;
	}

	@Override
	public String toString() {
		return "AccountClass [id=" + id + ", name=" + name + ", balance=" + balance + ", accountType=" + accountType
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}



}