import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static String rps(String p1, String p2) {
      // your code
      // Player 1 won! 
      // Player 2 won! 
      // Draw! 
      p1 = p1.toLowerCase();
      p2 = p2.toLowerCase();
      if (p1.equals(p2)){
      return "Draw!";
    }
      String[] outcome = new String[]{p1,p2};
      Map<String[],String> results = new HashMap<>();
      results.put(new String[]{"rock", "scissors"}, "Player 1 won!");
      results.put(new String[]{"paper", "rock"}, "Player 1 won!");
      results.put(new String[]{"scissors", "paper"}, "Player 1 won!");
      for (String[]arr:results.keySet()){
      if (arr.equals(outcome)){
        return results.get(arr);
      }
    }

      return "Player 2 won!";
      
    }
}
