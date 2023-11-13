package lab1;

import java.util.Scanner;
import java.util.Random;

public class TestBankAccount {

	public static void main(String[] args) {
		//create scanner and random objects
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		//enter name
		System.out.println("Please enter your name: ");
		String name = input.next();
		
		//three attributes for the bank account
		int id = 1 + random.nextInt(1000);
		int option = 0;
		String[] accountType = {"Chequing", "Savings", "TFSA"};
		String type = "";

		//enter accountType
		while(option<1||option>3) {
			System.out.println("Enter Type of account: 1-Chequing, 2-Savings, 3-TFSA");
			option = input.nextInt();
			if(option<1||option>3)
				System.out.println("Invalid input, try again");
			if(option>=1&&option<=3)
				type = accountType[option-1];
		}
		
		BankAccount account = new BankAccount();
		account.setName(name);
		account.setID(id);
		account.setAccountType(type);
		
		//withdraw and deposit money
		account.depositMoney();
		account.withdrawMoney();
		
		//calculate interest
		account.Yearly_Interest();
		
		System.out.println(account.toString());
	}

}
