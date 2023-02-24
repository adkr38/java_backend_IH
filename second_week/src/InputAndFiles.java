import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

class Main{
  public static void main(String[] args) throws IOException{

    // Console input
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please tell me your name:");
    String inputString = scanner.nextLine();
    System.out.println("Please tell me your age:");
    int inputInt = scanner.nextInt();
    while (inputInt < 18){
      System.out.println("You must be older than 17 to continue!");
      inputInt = scanner.nextInt();
    }
    System.out.println("Please tell me your best grade last semester:");
    float inputFloat = scanner.nextFloat();
    System.out.println("Please tell me a large number:");
    scanner.nextLine();
    String inputLongString = scanner.nextLine();
    System.out.println(inputLongString);
    long inputLong = Long.parseLong(inputLongString);
    String inputResults = String.format("Name: %s; Age: %d; Best Grade:%f; Long number:%d;", inputString,inputInt,inputFloat,inputLong);
    System.out.println(inputResults);
    scanner.close();

    //Writing
    FileWriter writer = new FileWriter("output.txt",true);
    writer.write("Hello world! \n");
    writer.write(inputResults);
    writer.close();
    //Reading
    File file = new File("output.txt");
    //A scanner is needed to read the file
    Scanner fileScanner = new Scanner(file);
    String fileText = "";
    while (fileScanner.hasNextLine()){
      String data = fileScanner.nextLine();
      System.out.println(data);
      fileText += data;
    }
    fileScanner.close();
    System.out.println(fileText);

  }
}


// 
