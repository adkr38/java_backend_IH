package com.week4.app;

public class Account{
  protected String name;
  protected String address;
  protected double balance;
  protected String accountNumber;

  public Account(String name, String address, double balance, int i){
    setName(name);
    setAddress(address);
    setBalance(balance);
    setAddress(address);
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }
  public String getAccountNumber() {
    return accountNumber;
  }
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


}
