/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author zhiru
 */
public class Alphabet extends Application {
    //create arrays of buttons instance(object)
    Button[] letters = new Button[26];
    Label label;
    double x = 0;
    double y = 10;
    
    @Override
    public void start(Stage primaryStage) {
        //create an empty layout
        Pane root = new Pane();
        //create a text message
        label = new Label("Press a letter");
        label.setLayoutX(0);
        label.setLayoutY(130);
        root.getChildren().add(label);
        //create 26 buttons using loop and class, and store them in an array
        for(int i = 0; i < letters.length; i++){
            letters[i] = new Button(""+(char)(i+65));
            letters[i].setLayoutX(x);
            letters[i].setLayoutY(y);
            x+=30;
            
            if((i+1)%10==0&&i>0){
                x = 0;
                y+=30;
            }
            
            root.getChildren().add(letters[i]);
        }
        
        
        //traverse through the array to activate the button click event
        for(int j = 0; j < letters.length; j++){
            String s = ""+(char)(65+j);
         
            if(j==0||j==4||j==8||j==14||j==20){
                letters[j].setOnAction(new EventHandler<ActionEvent>() {
             
                @Override
                public void handle(ActionEvent event) {
                    label.setText(s+" is a vowel");
                }
                });
            }
            else{
                letters[j].setOnAction(new EventHandler<ActionEvent>() {
             
                @Override
                public void handle(ActionEvent event) {
                    label.setText(s+" is a consonant");
                }
                });
            }
            
        }
        
        Scene scene = new Scene(root, 450, 200);
        
        primaryStage.setTitle("Your name: Patrick Meng");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
