package lab1;

import java.util.*;

public class EnumEx3 {
	
	enum AccountType {Chequing, Savings, Tfsa}

	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		
		String type = "";
		int id = 1+random.nextInt(1000);
		
		System.out.println("Enter your name:");
		String name = input.next();
		
		int option=0;
		do {
			System.out.println("Enter type of account: 1-Chequing, 2-Savings, 3-TFSA");
			option = input.nextInt();		
			}while(option>3||option<1);
		
		AccountType save = AccountType.Savings; 
		AccountType tfsa = AccountType.Tfsa;
		
		if(option == 2)
			type = save.name();
		if(option == 3)
			type = tfsa.name();
		
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
