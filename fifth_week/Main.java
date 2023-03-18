import java.util.Map;
import java.util.HashMap;

class Main{
  public static void main(String[] args) {
    Account myAccount = new Account("adrian", "hosp", 1235.2, "A", Hold.NONE);
    Account otherAccount = new Account("david", "hosp", 1235.3, "B", Hold.FRAUD);
    Account[] accounts = new Account[2];
    accounts[0] = myAccount;
    accounts[1] = otherAccount;
    HashMap<String,Account> accMap  = new HashMap<String,Account>();
    for (Account acc:accounts){
      accMap.put(acc.getName(), acc);
    }
    System.out.println(accMap);
    
  }
}
