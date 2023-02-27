import java.math.BigDecimal;
import java.math.MathContext;

class Main{
  public static void main(String[] args) {
    BigDecimal a = new BigDecimal("2.3");
    BigDecimal b = new BigDecimal("1.5");
    BigDecimal c = new BigDecimal("0.8");
    BigDecimal x = new BigDecimal(".5");
    System.out.println((a.multiply(x,MathContext.DECIMAL128).add(b)).divide(x.subtract(c),MathContext.DECIMAL128));
  }
}

