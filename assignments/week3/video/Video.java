import java.lang.IllegalAccessException;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Arrays;

public abstract class Video{
  protected String title;
  protected int duration;

  Video(String title, int duration) {
    setTitle(title);
    setDuration(duration);
  }


    public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public int getDuration() {
    return duration;
  }


  public void setDuration(int duration) {
    this.duration = duration;
  }


public String getInfo() throws IllegalAccessException{
    String outputString = "";
    Class<? extends Video> instanceOfClass = this.getClass();
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
}
