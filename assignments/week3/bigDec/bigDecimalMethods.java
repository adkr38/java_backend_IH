import java.math.BigDecimal;
import java.math.RoundingMode;

class bigDecimalMethods{
  public static double bigDecimalToRoundedDouble(BigDecimal number){
    number = number.setScale(2,RoundingMode.HALF_EVEN);
    System.out.println(number);                        
    double outputNumber = number.doubleValue();        
    return outputNumber;                               
  }

  public static BigDecimal bigDecimalRoundAndInvert(BigDecimal number){
    number = number.setScale(1,RoundingMode.HALF_EVEN);
    number = number.negate();
    return number;
  }
}
