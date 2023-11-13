/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author xiaod
 */
public class Test extends Application {
    
    Pane layout;
    BorderPane root;
    Text words;
    RadioButton rotate1;
    RadioButton rotate2;
    RadioButton rotate3;
    RadioButton rotate4;
    Rectangle trunk;
    Ellipse leaves;
    CheckBox rainbow;
    CheckBox smile;
    Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, 
                    Color.BLUE, Color.INDIGO, Color.PURPLE};
    rainbow[] list = new rainbow[color.length];
       
    //create rainbow
    class rainbow{
        Arc color;            
        rainbow(double x, double y){
            color = new Arc(400, 120, x, y, 0, 180);
            color.setFill(Color.TRANSPARENT);
            color.setStroke(Color.TRANSPARENT);
            color.setStrokeWidth(8);                    
            layout.getChildren().add(color);
        }            
        public void setColor(Color c){
            color.setStroke(c);
        }    
    }
    
    class emotes{
        Ellipse face;
        Ellipse eye1;
        Ellipse eye2;
        Arc mouth;
        emotes(){
            face = new Ellipse(400, 225, 76, 76);
            face.setFill(Color.YELLOW);
            eye1 = new Ellipse(370, 190, 8, 20);
            eye2 = new Ellipse(430, 190, 8, 20);
            eye1.setFill(Color.BLACK);
            eye2.setFill(Color.BLACK);
            mouth = new Arc(400, 225, 60, 60, 180, 180);
            mouth.setFill(Color.BLACK);  
            layout.getChildren().addAll(face, eye1, eye2, mouth);
        }
        public void removeEmotes(){
            layout.getChildren().remove(face);
            layout.getChildren().remove(eye1);
            layout.getChildren().remove(eye2);
            layout.getChildren().remove(mouth);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        layout = new Pane();
        root = new BorderPane();
        
        //draw sky
        Rectangle sky = new Rectangle(250, 0, 300, 400);
        sky.setFill(Color.SKYBLUE);
        //draw ground
        Rectangle ground = new Rectangle(250, 300, 300, 100);
        ground.setFill(Color.DARKGREEN);
        //draw tree trunk
        trunk = new Rectangle(300, 220, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);
        //draw leaves
        leaves =  new Ellipse(310, 220, 40, 50);
        leaves.setFill(Color.DARKCYAN);
        layout.getChildren().addAll(sky, ground, trunk, leaves);       
        
        Rectangle left = new Rectangle(0, 0, 250, 450);
        left.setFill(Color.SNOW);
        
        layout.getChildren().addAll(left);         
        
        //create hbox
        HBox hbox1 = new HBox(20);
        HBox hbox2 = new HBox(35); 
        HBox hbox3 = new HBox(20);
        
        Text background = new Text("Background");
        background.setLayoutX(60);
        background.setLayoutY(80);
        
        rainbow = new CheckBox("Rainbow");
        smile = new CheckBox("Smile");
        
        double x = 210;
        double y = 100;
        for(int index = 0; index < list.length; index++){
            list[index] = new rainbow(x, y);
            x-=8;
            y-=8;
        }
        
        rainbow.setOnAction(handler2);
        smile.setOnAction(handler2);
        
        hbox3.getChildren().addAll(rainbow, smile);
        hbox3.setLayoutX(20);
        hbox3.setLayoutY(90);
        
        //create radiobuttons to control rotation
        Text rotate = new Text("Rotation");
        rotate.setLayoutX(70);
        rotate.setLayoutY(190);
        rotate1 = new RadioButton("0");
        rotate2 = new RadioButton("90");
        rotate3 = new RadioButton("180");
        rotate4 = new RadioButton("270");
        //rotation
        rotate2.setOnAction(handler);
        rotate3.setOnAction(handler);
        rotate4.setOnAction(handler); 
        
        hbox1.getChildren().addAll(rotate1, rotate2);
        hbox1.setLayoutX(45);
        hbox1.setLayoutY(200);
        
        hbox2.getChildren().addAll(rotate3, rotate4);
        hbox2.setLayoutX(30);
        hbox2.setLayoutY(230);
        
        layout.getChildren().addAll(background, rotate, hbox1, hbox2, hbox3);
 
        //create a textbox and buttons to display rotation
        Text caption = new Text("Caption");
        caption.setLayoutX(70);
        caption.setLayoutY(300);
        
        TextField messages = new TextField();
        messages.setEditable(true);
        messages.setLayoutX(30);
        messages.setLayoutY(310);
        
        Button changeText = new Button("Change text");
        changeText.setLayoutX(60);
        changeText.setLayoutY(350);
        //action event after clicking change text button
        changeText.setOnAction((ActionEvent event) -> {
            layout.getChildren().remove(words);
            words = new Text(messages.getText());
            Font font = Font.font("Verdana", FontWeight.BOLD, 28);
            words.setFont(font);
            words.setFill(Color.WHITE);
            words.setX(256);
            words.setY(350);
            layout.getChildren().add(words);
        });
        
        Button close = new Button("Close");
        close.setLayoutX(470);
        close.setLayoutY(410);
        //action event after clicking the close button
        close.setOnAction(e -> primaryStage.close());
        
        layout.getChildren().addAll(caption, messages, changeText, close);
        
        root.setCenter(layout);
        
        Scene scene = new Scene(root, 550, 450);
        primaryStage.setTitle("JavaFx Tree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //action event for tree rotation
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){
        int i = 1;
        int j = 1;        
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==rotate2){
                trunk.getTransforms().add(new Rotate(90, 310, 290));
                leaves.getTransforms().add(new Rotate(90, 310, 290));
                if(i%2==0){
                    trunk.getTransforms().add(new Rotate(180, 310, 290));
                    leaves.getTransforms().add(new Rotate(180, 310, 290));
                }    
                i+=1;
            }
            else if(event.getSource()==rotate3){
                trunk.getTransforms().add(new Rotate(180, 310, 290));
                leaves.getTransforms().add(new Rotate(180, 310, 290));
            }
            else if(event.getSource()==rotate4){
                trunk.getTransforms().add(new Rotate(270, 310, 290));
                leaves.getTransforms().add(new Rotate(270, 310, 290));
                if(j%2==0){
                    trunk.getTransforms().add(new Rotate(180, 310, 290));
                    leaves.getTransforms().add(new Rotate(180, 310, 290));
                }
                j+=1;
            }
        }    
    };
    
    //action for background actions
    EventHandler<ActionEvent> handler2 = new EventHandler<ActionEvent>(){
        int check = 1;
        int check2 = 1;  
        emotes face;
        @Override
        public void handle(ActionEvent event) {
            
            if(event.getSource()==rainbow){
                for(int index = 0; index < list.length; index++){           
                    list[index].setColor(color[index]); }
                if(check%2==0){
                    for (rainbow list1 : list) {
                        list1.setColor(Color.TRANSPARENT);}}
                check+=1; }
            if(event.getSource()==smile){
                if(check2%2==1){
                    face = new emotes();
                }
                else{
                    face.removeEmotes();
                }
                check2+=1;
            }
            
        }; 
    };
}        
