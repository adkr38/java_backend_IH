public class CreditCard{

  private String cardOwner;
  private final double BALANCE_LIMIT;
  private final String ENTITY;
  protected double balance;
  private int id;
  private static int counter= 0;

  public CreditCard(String cardOwner, double balance) throws BalanceLimitedException{
    this.BALANCE_LIMIT = 1000;
    this.ENTITY = "bankName";
    setBalance(balance);
    setCardOwner(cardOwner);
    this.id = counter ++;
  }

  public void setCardOwner(String cardOwner){
    this.cardOwner = cardOwner;
  }

  public void setBalance(double balance) throws BalanceLimitedException{
    if (balance >= BALANCE_LIMIT){
      throw new BalanceLimitedException(String.format("Balance limit surpassed, current limit is %d",BALANCE_LIMIT));
    }
    this.balance = balance;
  }

  public String getEntity(){
    return ENTITY;
  }

  public double getBalance(){
    return balance;
  }

  public double getBALANCE_LIMIT(){
    return BALANCE_LIMIT;

  }

  public String getCardOwner(){
    return cardOwner;
  }

  public int getId(){
    return id;
  }

  public static int getCounter(){
    return counter;
  }

 public class BalanceLimitedException extends Exception{
    BalanceLimitedException(String errorMessage){
      super(errorMessage);
    }

  }

}
