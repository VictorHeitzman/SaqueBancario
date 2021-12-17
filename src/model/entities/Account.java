package model.entities;

import model.exeption.DomainException;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
		
	}

	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validedWithdaw(amount);
		balance -= amount;
	}
	
	private void validedWithdaw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
		}
		if(amount > getBalance()) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
			
	}
	
}
