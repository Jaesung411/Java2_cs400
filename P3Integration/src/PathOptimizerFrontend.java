//https://stackoverflow.com/questions/36493990/javafx-combobox-didnt-show-correct-value-from-objects

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import javafx.util.StringConverter;

public class PathOptimizerFrontend implements IPathOptimizerFrontend
{
    private IPlaceSearcherBackend backend;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "UW Madison Campus Route Finder";

    private IPlace place1;
    private IPlace place2;

    public PathOptimizerFrontend(IPlaceSearcherBackend backend)
    {
	this.backend = backend;
    }


    /**
     * Populate stage passed in by app driver with GUI elements and set callbacks
     */
    @Override
    public void menu(Stage stage)
    {
	// root is a VBox (image above grid for input)
	VBox root = new VBox();

	// use a grid pane to layout input elements

	Scene scene = new Scene(root, WIDTH, HEIGHT);
	stage.setTitle(TITLE);
	ImageView refImage = null;
	// reference map, set width to 200
	try
	{
	    refImage = new ImageView(new Image(new FileInputStream("/Users/jason/Eclipse-400/P3Integration/src/img/testRefImage.jpg")));
	}
	catch(FileNotFoundException e)
	{
	    System.out.println("Cannot load reference map!");
	    Platform.exit();
	}
	refImage.setFitWidth(600);
	refImage.setPreserveRatio(true);

	root.getChildren().add(refImage);

	// the two dropdowns, along with the submit button and the result, will
	// be arranged in a GridPane
	GridPane inputPane = new GridPane();
	inputPane.setHgap(10); // 10px between cells
	inputPane.setVgap(10);
	// inputPane.setGridLinesVisible(true);

	root.getChildren().add(inputPane);

	// use HBoxes to couple each label with its respective dropdown
	HBox loc1 = new HBox(10);
	HBox loc2 = new HBox(10);


	Label loc1Label = new Label("First Location");
	Label loc2Label = new Label("Destination");

	loc1Label.setId("loc1Label");
	loc2Label.setId("loc2Label");

	ComboBox<IPlace> loc1Choice = new ComboBox<>();
	ComboBox<IPlace> loc2Choice = new ComboBox<>();

	loc1Choice.setId("loc1Choice");
	loc2Choice.setId("loc2Choice");
	//add string converters to combo box

	StringConverter<IPlace> converter = new StringConverter<>()
	{
	    @Override
	    public String toString(IPlace p)
	    {
		return p.getName();
	    }

	    @Override
	    public IPlace fromString(String s)
	    {
		return loc1Choice.getItems().stream().filter(ap ->
            ap.getName().equals(s)).findFirst().orElse(null);
	    }
	};

//		loc1Choice.setConverter(converter);
//		loc2Choice.setConverter(converter);



	Label resLabel = new Label("Result: ");
	resLabel.setId("resLabel");
	Button calcButton = new Button("Find Route");
	calcButton.setId("calcButton");
	// set up remainder of scene graph

	// loc1 children (label & dropdown)
	loc1.getChildren().add(loc1Label);
	loc1.getChildren().add(loc1Choice);


	loc2.getChildren().add(loc2Label);
	loc2.getChildren().add(loc2Choice);

	// add both location HBoxes to first row of grid
	inputPane.add(loc1, 0, 0);
	inputPane.add(loc2, 1, 0);

	// add the button and result to the 2nd
	inputPane.add(calcButton, 0, 1);
	inputPane.add(resLabel, 1, 1);



	// add the items from backend
	ArrayList<IPlace> allPlaces = backend.returnAllPlaces();
	loc1Choice.getItems().addAll(allPlaces);
	loc2Choice.getItems().addAll(allPlaces);

	// add callbacks for submit button and two dropdowns

	calcButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
	{
	    resLabel.setText("Result: "+backend.returnPath(place1, place2));
	});


	loc1Choice.valueProperty().addListener((obs, oldItem, newItem) ->
	{
	    place1 = newItem;
	 });

	loc2Choice.valueProperty().addListener((obs, oldItem, newItem) ->
	{
	    place2 = newItem;
	});



	// finally, set the active scene and show the stage

	stage.setScene(scene);

	stage.show();
    }

    public void setOrigin(IPlace place)
    {
	this.place1 = place;
    }

    public void setDestination(IPlace place)
    {
	this.place2 = place;
    }

}