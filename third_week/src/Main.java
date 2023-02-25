import java.util.Date;
import java.util.ArrayList;
import java.util.Map;
import java.lang.IllegalAccessException;

class Main{
  public static void main(String[] args)  throws IllegalAccessException {
    Date today = new Date();
    Account myAccount = new Account("Adrian", "L'Hospitalet de Llobregat", 432534623l, 132);
    // Transaction myTransaction = new Transaction(4362346234l, 432534623l, 1100, today);
    Transaction myTransaction = new Transaction(4362346234l, myAccount.getAccountNumber(), 1100, today);
    Transaction myOtherTransaction=new  Transaction(4362346234l, 432534623l, 700, today);
    ArrayList<Transaction> myTransactions = new ArrayList<Transaction>();
    myTransactions.add(myTransaction);
    myTransactions.add(myOtherTransaction);
    PaymentList myPayments = new PaymentList(myTransactions);
    Transaction myLastPayment = myPayments.getLastTransaction();
    Map transactionMap =  myLastPayment.toMap();
    System.out.println(transactionMap);
  }
}
