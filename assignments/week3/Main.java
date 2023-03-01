import java.math.BigDecimal;
import java.lang.IllegalAccessException;
import java.util.Map;


class Main{
  public static void main(String[] args) throws IllegalAccessException {
    //Operaciones BigDecimal
    BigDecimal numero1 = new BigDecimal(4.2545);
    BigDecimal numero2 = new BigDecimal(1.2345);
    BigDecimal numero3 = new BigDecimal(-45.67);
    //Respuestas del ejercicio planteado en el portal
    System.out.println("bigDecimal section answers:");
    System.out.println(bigDecimalMethods.bigDecimalToRoundedDouble(numero1));
    System.out.println(bigDecimalMethods.bigDecimalRoundAndInvert(numero1));
    System.out.println(bigDecimalMethods.bigDecimalRoundAndInvert(numero2));
    System.out.println(bigDecimalMethods.bigDecimalRoundAndInvert(numero3));

    System.out.println("Car section answers");
    Sedan mySedan= new Sedan(1121520, "Honda", "Civic", 13091);
    UtilityVehicle myUtilityVehicle= new UtilityVehicle(22520, "Jeep", "Wrangler", 291,true);
    Truck myTruck = new Truck(111023, "Toyota", "Trucker", 100230,1003.15);
    System.out.println(mySedan.getInfo());
    System.out.println(myUtilityVehicle.getInfo());
    System.out.println(myTruck.getInfo());

    System.out.println("Video section asnwers");
    TvSeries myTvSeries = new TvSeries("Hollywood", 8000, 50);
    Movie myMovie = new Movie("Avatar", 40000, 4);
    System.out.println(myTvSeries.getInfo());
    System.out.println(myMovie.getInfo());

    System.out.println("IntList section answers");
    System.out.println("This is an IntArrayList, I'll get the 10th element after adding some numbers.");
    IntArrayList myInts = new IntArrayList(); 
    for (int i =0; i<40;i++){
      myInts.add(i+1);
    }

    System.out.println(myInts.get(10));
    IntVector myIntsInAVector = new IntVector();
    System.out.println("This is an IntVector, I'll get the 20th element after adding some numbers.");
    for (int i =0; i<40;i++){
      myIntsInAVector.add(i+1);
    }
    System.out.println(myIntsInAVector.get(20));
  }
}
