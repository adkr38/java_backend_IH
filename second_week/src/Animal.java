import java.util.Arrays;

public class Animal{

  private boolean sex;
  private String terrain;

  /**
   * Animal class constructor.
   * @param sex true if male.
   * @param terrain only air water or earth accepted, throws WrongTerrainException.
   */
  public Animal(boolean sex, String terrain) throws WrongTerrainException{
    setSex(sex);
    setTerrain(terrain);
  }

  public void setSex(boolean sex){
    this.sex = sex;
  }

  public void setTerrain(String terrain) throws WrongTerrainException{
    if (!Arrays.asList("air","water","earth").contains(terrain.strip().toLowerCase())){
      throw new WrongTerrainException("Invalid terrain.");
    }
    this.terrain = terrain;
  }
  
  public boolean getSex(){
    return sex;
  }

  public String getTerrain(){
    return terrain;
  }

  public static void genericBark(){
    System.out.println("BARK!");
  }

  public void bark(){
    System.out.println("YOUR ANIMAL - BARK!");

  }

  public class WrongTerrainException extends Exception{
    WrongTerrainException(String errorMessage){
      super(errorMessage);
    }
  }

}

