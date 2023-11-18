import java.util.List;

public class ShowGameSalesTriviaApp {
    public static void main(String[] args) throws Exception {
    	
        IGameLoader loader = new GameLoader();
        
        List<IGame> games = loader.loadShows("src/GamesPractice.xml");
       
        IGameTrivia backend = new GameTrivia(games);
        for(IGame game : games) backend.addGame(game);
       
        IGameTriviaFrontend frontend = new GameTriviaFrontend(backend);
        frontend.runCommandLoop();
    }
}