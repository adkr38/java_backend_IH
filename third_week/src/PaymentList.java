import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
public class PaymentList implements TransactionList{

  private ArrayList<Transaction> transactions;

  PaymentList(ArrayList<Transaction> transactions){
    setTransactions(transactions);
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(ArrayList<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Transaction getLastTransaction(){
    return transactions.get(transactions.size() - 1);

  }

  public void addTransaction(Transaction transaction){
    transactions.add(transaction);
  }

  public ArrayList<Transaction> getTransactionByDate(Date date){
    Calendar dateCalendar = Calendar.getInstance();
    dateCalendar.setTime(date);
    int argDayOfMonth = dateCalendar.get(Calendar.DAY_OF_MONTH);
    ArrayList<Transaction> outputArray = new ArrayList<Transaction>();
    transactions.forEach((Transaction t) ->{
      Calendar tCalendar = Calendar.getInstance();
      tCalendar.setTime(t.getDate());
      int tDayOfMonth = tCalendar.get(Calendar.DAY_OF_MONTH);
      if (argDayOfMonth == tDayOfMonth){
        outputArray.add(t);
      }
    });
    return outputArray;
  }

  public ArrayList<Transaction> getAllTransactions(){
    return transactions;
  }


}
