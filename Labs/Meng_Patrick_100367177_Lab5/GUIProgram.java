import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class GUIProgram extends Application {

    ToggleGroup radio;
    Text title;
    
    @Override
    public void start(Stage stage) {
        //set the root/nodes
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        
        //add radiobuttons
        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton black = new RadioButton("Black");
        RadioButton orange = new RadioButton("Orange");
        RadioButton green = new RadioButton("Green");
        HBox hbox = new HBox(red, yellow, black, orange, green);
        hbox.setAlignment(Pos.TOP_CENTER);
        red.setOnAction(e -> title.setFill(Color.RED));
        yellow.setOnAction(e -> title.setFill(Color.YELLOW));
        black.setOnAction(e -> title.setFill(Color.BLACK));
        orange.setOnAction(e -> title.setFill(Color.ORANGE));
        green.setOnAction(e -> title.setFill(Color.GREEN));
        
        //assign to a single toggle group
        radio = new ToggleGroup();
        red.setToggleGroup(radio);
        yellow.setToggleGroup(radio);
        black.setToggleGroup(radio);
        orange.setToggleGroup(radio);
        green.setToggleGroup(radio);
        
        //create buttons
        HBox hbox2 = new HBox();
        Button left = new Button("<=");
        Button right = new Button("=>");
       
        
        //define the fonts to be used for your node element
        Font myFont = Font.font("Arial", FontWeight.BOLD , FontPosture.ITALIC, 20);
        //set title
        title = new Text(100, 65, "Programming is fun");
        title.setFont(myFont);
        left.setOnAction(e -> title.setX(title.getX()-1));
        right.setOnAction(e -> title.setX(title.getX()+1));
        
        pane.getChildren().add(title);
        hbox2.getChildren().addAll(left, right);
        hbox2.setAlignment(Pos.BOTTOM_CENTER);
        root.setTop(hbox);
        root.setBottom(hbox2);
        root.setCenter(pane);
        BorderPane.setAlignment(hbox2, Pos.CENTER);
         
        //set the scene
        Scene scene = new Scene(root, 500, 150);
        stage.setScene(scene);
        stage.setTitle("GUI Program");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           
        }
    
    }

}