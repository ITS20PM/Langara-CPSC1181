public class LockTester {
	
	public static void main(String[] args) {
		Account acc1 = new Account();
		//set the key
		acc1.setKey(1);
		//to lock the account
		acc1.lock(1);
		//to unlock the account
		acc1.unlock(1);
		//withdraw or deposit money
		if(!acc1.isLocked()) {
			acc1.deposit(200);
			acc1.withdraw(50);
			System.out.println("Balance: $"+acc1.getbalance());
		}else {
			System.out.println("The account is locked, you cant withdraw or deposit money");
		}
	}
}
