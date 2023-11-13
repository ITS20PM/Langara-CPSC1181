package lab1;

import java.util.Scanner;

public class BankAccount {
	
	Scanner input = new Scanner(System.in);
	
	//2 constant values
	private final double INTEREST_SAVINGS_YEARLY = 0.021;
	private final double INTEREST_TFSA_YEARLY = 0.023;
	//attributes for the BankAccount class
	private String name;
	private double amount;
	private int id;
	private String accountType;
	private double balance;
	private double interest;
	
	//default java constructor
	public BankAccount() {
		
	}
	//overloaded constructor with 2 parameters
	public BankAccount(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	//getter and setter methods
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountType() {
		return accountType;
	}
	
	//method to deposit money
	public void depositMoney() {
		System.out.println("How much do you want to deposit:");
		amount = input.nextDouble();
		if(amount>0)
			balance+=amount;
	}
	
	//method to withdraw money
	public void withdrawMoney() {
		System.out.println("How much do you want to withdraw:");
		amount = input.nextDouble();
		if(amount<=balance)
			balance-=amount;
	}
	
	//interests rate method
	public void Yearly_Interest() {
		if(accountType.equalsIgnoreCase("Savings")) 
			interest = INTEREST_SAVINGS_YEARLY*balance;
		else if(accountType.equalsIgnoreCase("TFSA")) 
			interest = INTEREST_TFSA_YEARLY*balance;
	}
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", ID=" + id + 
				", accountType=" + accountType + ", amount=" + 
				balance + ", interest=" + interest +"]";
	}
	
}


