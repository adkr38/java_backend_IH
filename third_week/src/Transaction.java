import java.util.Date;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.lang.IllegalAccessException;

public class Transaction{
  protected long sellerAccountNumber;
  protected long buyerAccountNumber;
  private int amount;
  private Date date;

  Transaction(long sellerAccountNumber, long buyerAccountNumber, int amount, Date date){
    setSellerAccountNumber(sellerAccountNumber);
    setBuyerAccountNumber(buyerAccountNumber);
    setAmount(amount);
    setDate(date);
  }

  public long getSellerAccountNumber() {
    return sellerAccountNumber;
  }

  public void setSellerAccountNumber(long sellerAccountNumber) {
    this.sellerAccountNumber = sellerAccountNumber;
  }

  public long getBuyerAccountNumber() {
    return buyerAccountNumber;
  }

  public void setBuyerAccountNumber(long buyerAccountNumber) {
    this.buyerAccountNumber = buyerAccountNumber;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String toString(){
    return String.format("Buyer: %d; Seller: %d; Amount: %d; Date: %s;", buyerAccountNumber,sellerAccountNumber,amount,date.toString());
  }

  //Private fields won't bge able to be accessed by other packages (setAccessible);
  public Map<String,Object> toMap() throws IllegalAccessException{
    Class<? extends Transaction> instanceClass = this.getClass();
    Map<String,Object> outputMap = new HashMap<>();
    for (Field field:instanceClass.getDeclaredFields()){
      try{
        field.setAccessible(false);
        outputMap.put(field.getName(),field.get(this));
      }catch (IllegalAccessException e){
        e.printStackTrace();
      }

    }
    return outputMap;
  }

}
