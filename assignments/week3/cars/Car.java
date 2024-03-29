import java.lang.reflect.Field;
import java.lang.IllegalAccessException;
import java.util.Optional;
import java.util.Arrays;

public abstract class Car{
  protected int vinNumber;
  protected String make;
  protected String model;
  protected int mileage;

  protected Car(int vinNumber, String make, String model, int mileage){
    setVinNumber(vinNumber);
    setMake(make);
    setModel(model);
    setMileage(mileage);
  }

  public String getInfo() throws IllegalAccessException{
    String outputString = "";
    Class<? extends Car> instanceOfClass = this.getClass();
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


  public int getVinNumber() {
    return vinNumber;
  }
  public void setVinNumber(int vinNumber) {
    this.vinNumber = vinNumber;
  }
  public String getMake() {
    return make;
  }
  public void setMake(String make) {
    this.make = make;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getMileage() {
    return mileage;
  }
  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

}
