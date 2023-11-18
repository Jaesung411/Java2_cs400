import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	    
    private static IPlaceSearcherBackend backend;
    private static IPathOptimizerFrontend frontend;
    private static IPlaceLoader loader = new PlaceLoader();
    private static List<IPlace> places;
    @Override
    public void start(final Stage stage)
    {
	backend = new placeSearcherBackend(places);
	frontend = new PathOptimizerFrontend(backend);
	frontend.menu(stage); //fill the stage up with all the elements defined by the frontend
	
    }
    public static void main(String[] args) throws Exception
    {
	//TODO: replace with actual backend upon integration
    places = loader.loadPlaces("src/places.json");
	Application.launch();
    }
}