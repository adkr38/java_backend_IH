import java.util.OptionalInt;

class Main{

    public static int x = 35;
    public static int y = 20;

  public static void main(String[] args){
    int[] arrayConEnteros= {12,1005,23,694,4444,13,30};
    int[] arrayVacio = {};

    System.out.println(String.format("Array para tarea 1 y 2: %s;",java.util.Arrays.toString(arrayConEnteros)));

    // Tarea 1 - array con más de 1 elemento
    OptionalInt tarea1Result = tarea1(arrayConEnteros);
    if (tarea1Result.isPresent()){
      int diferenciaMayorMenor = tarea1Result.getAsInt();
      System.out.println(String.format("Tarea 1: Diferencia entre mayor y menor: %d;",diferenciaMayorMenor));
    } 

    // Tarea 1 - array vacío
    OptionalInt tarea1EmptyResult = tarea1(arrayVacio);
    System.out.println(String.format("Tarea 1: Resultado con array vacío: %s;",tarea1EmptyResult));

    // Tarea 2 - array con 2 o más elementos
    tarea2(arrayConEnteros);
    // Tarea 2 - array con menos de 2 elementos 
    tarea2(arrayVacio);


    // Tarea 3 - Se pide referenciar x e y como variables ya establecidas, se encuentran en
    // el constructor de la clase Main
    double result = tarea3();
    System.out.println(String.format("Tarea 3: (Con atributos de clase x:%d e y:%d ): %f;",x,y,result));

  }

  private static OptionalInt tarea1(int[] myArray){

    // No conozco la convención para manejar excepciones / retornos nulos en java.
    // Para ello añado un return type OpcionalInt para poder retornar
    // un valor nulo en caso de que el array sea menor a 1.

    if (myArray.length < 1) {
      return  OptionalInt.empty();
    }

    int smallest = 0;
    int largest = 0;
    for (int i = 0;i < myArray.length;i++){
      if (i==0){
        smallest = myArray[i];
        largest = myArray[i];
        continue;
      }

      smallest = smallest > myArray[i] ? myArray[i]:smallest;
      largest = largest < myArray[i] ? myArray[i]: largest;

    }
    return OptionalInt.of(largest - smallest);
    }


  private static void tarea2(int[] integerArray){

    if (integerArray.length <2){
      System.out.println("Tarea 2: Array length is lesser than 2. This function demands 2 or more integers inside of input array;");
      return;
    }

    int smallest= Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
    for (int el : integerArray){
      if (el<smallest){
        smallest = el;
        continue;
      }
      if (el < secondSmallest){
        secondSmallest = el;
      }
    }
    System.out.println(String.format("Tarea 2: Smallest: %d ; Second smallest: %d;", smallest,secondSmallest));

  }

  private static double tarea3(){

    return Math.pow(Math.pow(x,2)+ ( ((4*y)/5) - x),2);
  }
  }

