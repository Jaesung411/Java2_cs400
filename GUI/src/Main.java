import javax.management.RuntimeErrorException;

import com.sun.glass.events.MouseEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override 
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		Label label = new Label("label");
		Label label1 = new Label("right");
		Label label2 = new Label("left");
		Label label3 = new Label("center");
		HBox hbox = new HBox(label1);
		HBox hbox2 = new HBox(label2);
		HBox hbox3 = new HBox(label3);
//		hbox.setSpacing(8);
		GridPane gridPane = new GridPane();
		
		String[] buttonLabels = new String[] {"label","reset","quit"};
		EventHandler<ActionEvent>[] buttonActions = new EventHandler[] {
				e -> label.setText("stop clicking that button, please..."),
				e -> label.setText("label"),
				e -> Platform.exit()
		};
		Button[] buttons = new Button[3];
		
		for(int i =0; i<buttons.length;i++) {
			buttons[i] = new Button(buttonLabels[i]);
			buttons[i].setOnAction(buttonActions[i]);
			gridPane.getChildren().add(buttons[i]);
			GridPane.setColumnIndex(buttons[i], i%2);
			GridPane.setRowIndex(buttons[i], i/2);
		}
		
		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(label);
		borderPane.setBottom(gridPane);
		borderPane.setRight(hbox);
		borderPane.setLeft(hbox2);
		borderPane.setCenter(hbox3);
//		GridPane gridPane = new GridPane();
//		
//		String[] buttonLabels = new String[] {"label","reset","quit"};
//		EventHandler<ActionEvent>[] buttonActions = new EventHandler[] {
//				e -> label.setText("stop clicking that button, please..."),
//				e -> label.setText("label"),
//				e -> Platform.exit()
//		};
//		Button[] buttons = new Button[3];
//		for(int i =0; i<buttons.length;i++) {
//			buttons[i] = new Button(buttonLabels[i]);
//			buttons[i].setOnAction(buttonActions[i]);
//			gridPane.getChildren().add(buttons[i]);
//			GridPane.setColumnIndex(buttons[i], i%2);
//			GridPane.setRowIndex(buttons[i], i/2);
//		}
////		button.setLayoutX(200);
//		final Label labelConst = label;
//		button.setOnAction(event -> {
//			System.out.println("click");
////			labelConst.setText("stopclicking that button!");
////			throw new RuntimeException();
//		});
//		
//		label = new Label("something else"); 
////		Group group = new Group(label,button);
//		HBox hbox = new HBox(label,button,labelConst);
//		hbox.setSpacing(8);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(label);
		borderPane.setBottom(gridPane );
		EventType<MouseEvent> evenyType = MouseEvent.
		borderPane.addEventFilter(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("1. borderPane was clicked (filtering)"));
		gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("2. gridPane was clicked (filtering)"));
		buttons[0].addEventFilter(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("3. buttons[0] was clicked (filtering)"));
		buttons[0].addEventHandler(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("4. buttons[0] was clicked (handling)"));
		gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("5. gridPane was clicked (handling)"));
		borderPane.addEventHandler(MouseEvent.MOUSE_CLICKED,
				e -> System.out.println("6. borderPane was clicked (handling)"));
		
		Scene scene = new Scene(borderPane, 800, 600);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		Application.launch();
	}

}
