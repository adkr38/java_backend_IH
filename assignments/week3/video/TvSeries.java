import java.lang.IllegalAccessException;
public class TvSeries extends Video{
  protected int episodes;
  protected TvSeries(String title, int duration, int episodes) throws IllegalAccessException{
    super(title,duration);
    setEpisodes(episodes);
  }
  public int getEpisodes() {
    return episodes;
  }
  public void setEpisodes(int episodes) {
    this.episodes = episodes;
  }
}
