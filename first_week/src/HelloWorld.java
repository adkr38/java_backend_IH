public class Main{
  public static void main(String[] args){

    System.out.println("Datos primitivos");
    byte myByte = 23; // bytes: Entre -128 y 127
    short myShort = 1002; // shorts: Entre -32,768 y 32,767
    int myInt = 35002; // entre -2,147,483,648 y 2,147,483
    long myLong = 2222222222l; // ...
    float myFloat = 23.50f; // 4 bytes, hasta 7 decimales
    double myDouble = 25.1111111; // Para decimales, hasta 15 
    char myChar = 'a'; // Caracteres
    boolean myBool = true; // boolean
    System.out.println(String.format("My Byte: %d, My Long: %d", myByte,myLong));
    String[] myStrings = {"Adrian","James","Sara","Elena"};
    System.out.println(java.util.Arrays.toString(myStrings));

    for (int i = 0 ; i<myStrings.length; i++){
      System.out.println(String.format("%d - %s",i, myStrings[i]));
    }

    for(String name: myStrings){
      System.out.println(name);
    }


  } 
}
