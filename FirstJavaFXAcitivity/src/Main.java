import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
  
  @Override
  @SuppressWarnings("unchecked")
  public void start(Stage stage) {
      Label label = new Label("label");
      // HBox hbox = new HBox(label);
      // hbox.setSpacing(8);
      GridPane gridPane = new GridPane();
      String[] buttonLabels = new String[] {"label", "reset", "quit"};
      EventHandler<ActionEvent>[] buttonActions = new EventHandler[] {
        e -> label.setText("stop clicking that button, please..."),
        e -> label.setText("label"),
        e -> Platform.exit()
      };
      Button[] buttons = new Button[3];
      for(int i=0;i<buttons.length;i++) {
        buttons[i] = new Button(buttonLabels[i]);
        buttons[i].setOnAction(buttonActions[i]);
        gridPane.getChildren().add(buttons[i]);
        GridPane.setColumnIndex(buttons[i], i%2);
        GridPane.setRowIndex(buttons[i], i/2);
      }
      BorderPane borderPane = new BorderPane();
      borderPane.setTop(label);
      borderPane.setBottom(gridPane);
      EventType<ActionEvent> eventType = ActionEvent.ACTION;
      borderPane.addEventFilter(eventType,
        e -> System.out.println("1. borderPane was clicked (filtering)"));
      gridPane.addEventFilter(eventType,
        e -> System.out.println("2. gridPane was clicked (filtering)"));
      // temporarily consume event to prevent further filtering or handling
      // gridPane.addEventFilter(eventType,
      //   e -> e.consume());      
      buttons[0].addEventFilter(eventType,
        e -> System.out.println("3. buttons[0] was clicked (filtering)"));
      buttons[0].addEventHandler(eventType,
        e -> System.out.println("4. buttons[0] was clicked (handling)"));
      // The next two were not included in Lecture1 
      // and were a bit surprising to me at first in Lecture2:
      // we'll discuss them further in lecture on Thursday.
       gridPane.addEventHandler(eventType,
         e -> System.out.println("5. gridPane was clicked (handling)"));
       borderPane.addEventHandler(eventType,
         e -> System.out.println("6. borderPane was clicked (handling)"));
      Scene scene = new Scene(borderPane, 800, 600);
      stage.setScene(scene);
      stage.show();
      
      scene.addEventHandler(KeyEvent.KEY_PRESSED, 
    		  event -> {
    			  if(event.getCode() == KeyCode.L)
    				  buttons[0].fireEvent(new ActionEvent());
    		  });
  }
  public static void main(String[] args) { 
    System.out.println("Hello World");
    Application.launch();
  }
}