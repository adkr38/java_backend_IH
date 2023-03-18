public class Account{
  protected String name;
  protected String address;
  protected double balance;
  protected String accountNumber;
  protected Hold hold;

  public Account(String name, String address,double balance, String accountNumber, Hold hold){
    setName(name);
    setAddress(address);
    setBalance(balance);
    setAccountNumber(accountNumber);
    setHold(hold);
  }

  public void setName(String name){
    this.name = name;
  }

  public void setAddress(String address){
    this.address= address;
  }

  public void setBalance(double balance){
    this.balance= balance;
  }

  public void setAccountNumber(String accountNumber){
    this.accountNumber= accountNumber;
  }

  public void setHold(Hold hold){
    this.hold= hold;
  }

  public Hold getHold(){
    return this.hold;
  }

  public String getName(){
    return this.name;
  }

}
