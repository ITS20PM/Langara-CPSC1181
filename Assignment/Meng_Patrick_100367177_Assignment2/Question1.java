/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author zhiru
 */
public class TextAnimation extends Application {
    private BallAnimation animation;
    private double xVelocity = 3;
    Text text;
    
    @Override
    public void start(Stage primaryStage) {
       //create an empty layout
        Pane layout = new Pane();
        
        //create textbox
        text = new Text("Programming is fun");
        text.setLayoutX(0);
        text.setLayoutY(50);
        text.setFont(Font.font(STYLESHEET_CASPIAN, 15));
        
        //the event of text when pressing or relasing the text
        text.setOnMousePressed(new PressedEventHandler());
        text.setOnMouseReleased(new ReleaseEventHandler());
        
        //add the text to the layout
        layout.getChildren().addAll(text);
        
        //create the animation object to start the animation
        animation = new BallAnimation();
        animation.start();
        
        Scene scene = new Scene(layout, 350, 100);
        primaryStage.setTitle("Moving texts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class PressedEventHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            animation.stop();
            text.setLayoutX(text.getLayoutX());
        }
    }
    
    private class ReleaseEventHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
            animation.start();
        }
        
    }

    private class BallAnimation extends AnimationTimer{

        public BallAnimation() {
        }

        @Override
        public void handle(long now) {
            double x = text.getLayoutX();
            
            if(x+xVelocity >= 350){
                text.setLayoutX(0);
                x = text.getX();
            }
            
            x+=xVelocity;
            
            text.setLayoutX(x);     
        }
    }
    
}
