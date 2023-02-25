public class Account{
  protected String name;
  protected String address;
  protected long accountNumber;
  protected int balance;

  Account(String name, String address, long accountNumber, int balance){
    setName(name);
    setAddress(address);
    setAccountNumber(accountNumber);
    setBalance(balance);
  }

  protected String getName() {
    return name;
  }
  protected void setName(String name) {
    this.name = name;
  }
  protected String getAddress() {
    return address;
  }
  protected void setAddress(String address) {
    this.address = address;
  }
  protected long getAccountNumber() {
    return accountNumber;
  }
  protected void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }
  protected int getBalance() {
    return balance;
  }
  protected void setBalance(int balance) {
    this.balance = balance;
  }


  
}
