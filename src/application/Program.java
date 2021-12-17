package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exeption.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdraw = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdraw);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
		acc.withdraw(amount);
		
		System.out.println();
		
		System.out.println("Saque: " + String.format("%.2f", amount));
		System.out.println("Novo saldo: " +String.format("%.2f", acc.getBalance()));
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

}
