import java.lang.IllegalAccessException;
public class Movie extends Video{
  protected double rating;
  protected Movie(String title, int duration, double rating) throws IllegalAccessException{
    super(title, duration);
    setRating(rating);
  }
  public double getRating() {
    return rating;
  }
  public void setRating(double rating) {
    this.rating = rating;
  }
}
