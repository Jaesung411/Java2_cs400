import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

	//step9
	private int score = 0;
	
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        //step 7
        Button button1 = new Button("Dessert");
        Button button2 = new Button("Desert");
        Button button3 = new Button("Desert");
        Button button4 = new Button("Desert");
        Button button5 = new Button("Desert");
        Button button6 = new Button("Desert");
        Button button7 = new Button("Desert");
        Button button8 = new Button("Desert");
        
        Button[] buttons = {button1,button2,button3,button4,button5,button6,button7,button8};
        
        Random random = new Random();
        randomizeButtonPosistions(random,buttons);
       
        Pane pane1 = new Pane(button1,button2,button3,button4,button5,button6,button7,button8);
        borderPane.setCenter(pane1);
        BorderPane.setAlignment(pane1, Pos.CENTER);
        
        //step10
        exitButton.requestFocus();
        
        //step9
        buttons[0].setOnAction(event -> {
        	
        	score += 1;
        	randomizeButtonPosistions(random,buttons); 
        	
        	Label scoreLabel1 = new Label("Score: " + score);
        	borderPane.setTop(scoreLabel1);
        	
        	//step10
        	exitButton.requestFocus();
        });
        
        for(int i = 1; i < buttons.length; i++) {
        	buttons[i].setOnAction(event -> {
        		
            	score -= 1;
            	randomizeButtonPosistions(random,buttons);  
            	
            	Label scoreLabel1 = new Label("Score: " + score);
            	borderPane.setTop(scoreLabel1);
            	
            	//step10
            	exitButton.requestFocus();
            });
        }
        
        stage.setScene(scene);
        stage.show();
    }

    //step8
    private void randomizeButtonPosistions(Random random, Button[] buttons) {
    	
    	for(int i = 0; i<buttons.length;i ++) {
    		
    		random = new Random();
    		
    		//for the X position    	
        	buttons[i].setLayoutX(random.nextInt(600));
        	
        	//for the Y position    	
        	buttons[i].setLayoutY(random.nextInt(400));
    	}
    	
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}