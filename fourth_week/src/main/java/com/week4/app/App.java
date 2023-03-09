package com.week4.app;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.week4.app.Inventory;

public class App {
    public static void main( String[] args ) throws FileNotFoundException{
      Gson gson = new Gson();
    try{
      FileReader reader = new FileReader("./src/main/java/com/week4/app/jsonData.json");
      Inventory inventoryFromJson = gson.fromJson(reader,Inventory.class);
      System.out.println(inventoryFromJson);
      String jsonInventory = gson.toJson(inventoryFromJson);
      System.out.println(jsonInventory);

    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
    }
}
