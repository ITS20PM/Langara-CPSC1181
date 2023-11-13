import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Calculator extends Application {
    
    Interest interest;
    TextField txt1;
    TextField txt2;
    TextField txt3;
    TextArea textArea;
    int n=1;
    
    @Override
    public void start(Stage stage) {                
        //set the root border pane
        BorderPane root = new BorderPane();
        //Set the center layput of the borderpane to be a gridpane
        GridPane centerGrid = new GridPane();
        centerGrid.setAlignment(Pos.CENTER);
        centerGrid.setHgap(10);
        centerGrid.setVgap(10);
        
        //create 3 labels
        Label btn1 = new Label("Invested Amount");
        Label btn2 = new Label("Rate of Interest");
        Label btn3 = new Label("Investment Years");
        //display them to span 2 columns
        centerGrid.add(btn1, 0, 0, 2, 1);
        centerGrid.add(btn2, 0, 1, 2, 1);
        centerGrid.add(btn3, 0, 2, 2, 1);
       
        //create 3 textfields for entering data
        txt1 = new TextField();
        txt2 = new TextField();
        txt3 = new TextField();
        //set them to editable
        txt1.setEditable(true);
        txt2.setEditable(true);
        txt3.setEditable(true);
        //add elements to the nodes
        centerGrid.add(txt1, 4, 0, 2, 1);
        centerGrid.add(txt2, 4, 1, 2, 1);
        centerGrid.add(txt3, 4, 2, 2, 1);
       
        //Create 3 radio buttons
        RadioButton radioBtn1 = new RadioButton("Compounded Yearly");
        RadioButton radioBtn2 = new RadioButton("Compounded Half-Yearly");
        RadioButton radioBtn3 = new RadioButton("Compounded Quarterly");
        //assign to a single toggle group
        ToggleGroup radio = new ToggleGroup();
        radioBtn1.setToggleGroup(radio);
        radioBtn2.setToggleGroup(radio);
        radioBtn3.setToggleGroup(radio);
        
        if(radio.getSelectedToggle().toString().contains("Yearly"))
            n = 1;
        else if(radio.getSelectedToggle().toString().contains("Half-Yearly"))
            n = 2;
        else if(radio.getSelectedToggle().toString().contains("Quarterly"))
            n = 4;
        //Create Hbox
        HBox hbox = new HBox(radioBtn1, radioBtn2, radioBtn3);
        centerGrid.add(hbox, 0, 5, 5, 1);
        
        //crate calculate button
        Button calculate = new Button("Calculate");
        calculate.setOnAction(new ButtonHandler());
        //add textarea
        textArea = new TextArea();
        textArea.setEditable(false);
        
        
        centerGrid.add(calculate, 0, 7, 2, 1);
        //set the gridpane in the center
        root.setCenter(centerGrid);
        //set the textarea at the bottom of the borderpane
        root.setBottom(textArea);
        //add nodes to the scene
        Scene scene = new Scene(root, 800, 400);
        //set scene to the stage
        //set title as compound interest calculatir
        stage.setTitle("Compound Interest Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    class ButtonHandler implements EventHandler<ActionEvent>{
    
        public ButtonHandler(){
        }
        
        @Override
        public void handle(ActionEvent event) {           
            double p = Double.parseDouble(txt1.getText());
            double r = Double.parseDouble(txt2.getText());
            int t = Integer.parseInt(txt3.getText());                        
            interest = new Interest(p, r, n, t);
            textArea.appendText("Invested amount: "+p);
            textArea.appendText("Value at maturity: "+interest.amount());
            textArea.appendText("Interest earned: "+(interest.amount()-p));
            interest.display();
        }
    }
    
   

}