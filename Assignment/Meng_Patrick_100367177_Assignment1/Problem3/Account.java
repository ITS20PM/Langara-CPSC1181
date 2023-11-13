public class Account implements Lockable{
	
	private static int baseNum = 100000000;
	private int number;
	private double balance;
	private boolean isLocked;
	private int key;
	
	public Account() {
		 this.number = baseNum++;
		 this.balance = 0;
		 this.isLocked = false;
		 this.key = 0;
	}
	
	public Account(double balance) {
		this.number = baseNum++;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount>0)
			balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance)
			balance -= amount;
	}
	
	public int getNumber() {
		return number;
	}
	
	public double getbalance() {
		return balance;
	}

	@Override
	public void setKey(int k) {
		this.key = k;
	}

	@Override
	public void lock(int k) {
		if(this.key == k)
			isLocked = true;
	}

	@Override
	public void unlock(int k) {
		if(this.key == k)
			isLocked = false;
	}

	@Override
	public boolean isLocked() {
		return isLocked;
	}
}
