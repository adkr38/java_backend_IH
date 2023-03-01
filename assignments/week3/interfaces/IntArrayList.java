import java.lang.Override;
import java.util.Arrays;

public class IntArrayList implements IntList{
  protected int[] ints;
  protected static int assignedValues = 0;

  protected IntArrayList(){
    this.ints = new int[10];
  }

  @Override
  public void add(int number){
      if(assignedValues >= ints.length){
        createNewArray();
      }

      setInt(number);
    }

   @Override
   public int get(int id){
      if (id >= assignedValues){
        return 0;
      }
    return this.ints[id];
  }

  protected void setInts(int[] ints){
    this.ints = ints;
  }

  protected void createNewArray(){
    int newLength = (int) (ints.length * 1.5);
    int[] arrCopy= Arrays.copyOf(ints,newLength);
    setInts(arrCopy);
    System.out.println(String.format("Created new array with length %d." ,newLength));
  }
  protected void setInt(int number){
      ints[assignedValues] = number;
      assignedValues++;

  }





}
