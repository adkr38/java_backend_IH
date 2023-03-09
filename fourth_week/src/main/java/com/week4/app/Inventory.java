package com.week4.app;
import java.lang.reflect.Field; 
import java.util.Arrays;
import java.util.Optional; 

public class Inventory{
  protected String id;
  protected boolean isPaid;
  protected Item[] invoiceItems;

  public Inventory(String id, boolean isPaid, Item[] invoiceItems){
    setId(id);
    setPaid(isPaid);
    setInvoiceItems(invoiceItems);
  }

  public String getFieldsAsString() throws IllegalAccessException{
    String outputString = "";
    Class<? extends Inventory> instanceOfClass = this.getClass();
    Field[]superClassFields= instanceOfClass.getSuperclass().getDeclaredFields();
    Field[]ownClassFields= instanceOfClass.getDeclaredFields();
    Field[]instanceFields = Arrays.copyOf(superClassFields,superClassFields.length+ownClassFields.length);
    System.arraycopy(ownClassFields,0,instanceFields,superClassFields.length,ownClassFields.length);

    for (Field f:instanceFields){
      try{
        f.setAccessible(false);
        String fieldName = f.getName();
        Optional<Object> fieldObject = Optional.ofNullable(f.get(this));
        if (fieldObject.isPresent()){
          outputString += fieldName + ":" + fieldObject.get().toString() + ";";
        }
      }catch(IllegalAccessException e){
        e.printStackTrace();
      }
    }
    return outputString;
  }

  public static Inventory getSampleInventory(){
    Inventory myInv = new Inventory("A1",false,new Item[2]);
    Item item1 = myInv.new Item("yogurt", 0.22);
    myInv.invoiceItems[0] = item1;
    Item item2 = myInv.new Item("tirita", 0.05);
    myInv.invoiceItems[1] = item2;
    return myInv;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isPaid() {
    return isPaid;
  }

  public void setPaid(boolean isPaid) {
    this.isPaid = isPaid;
  }

  public Item[] getInvoiceItems() {
    return invoiceItems;
  }

  public void setInvoiceItems(Item[] invoiceItems) {
    this.invoiceItems = invoiceItems;
  }

  protected class Item{
    protected String name;
    private double price;


    Item(String name, double price){
        setName(name);
        setPrice(price);
      }

    public String getName() {
		return name;
	}

    public void setName(String name) {
      this.name = name;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }


    }

}

