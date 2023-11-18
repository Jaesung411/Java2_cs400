import java.util.List;

public class ShowSearcherApp {
    public static void main(String[] args) throws Exception {
        IShowLoader loader = new ShowLoader();
        List<IShow> shows = loader.loadShows("src/data/tv_shows.csv");
        IShowSearcherBackend backend = new ShowSeacherBackend();
        for(IShow show : shows) backend.addShow(show);
       
        IShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
        frontend.runCommandLoop();
    }
}