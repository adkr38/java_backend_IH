import java.util.Date;
import java.util.ArrayList;
public interface TransactionList{
  Transaction getLastTransaction();
  void addTransaction(Transaction transaction);
  ArrayList<Transaction> getTransactionByDate(Date date);
  ArrayList<Transaction> getAllTransactions();
}

