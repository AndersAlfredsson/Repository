package com.Skräp;

 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.layout.GridPane;
 import javafx.stage.Stage;
 import javafx.geometry.Insets;

public class BaseGUI extends Application {


     @Override
     public void start(Stage primaryStage) {
         //Create a GridPane for the Text Controls
         GridPane grid = new GridPane();
         grid.setHgap(10);
         grid.setVgap(10);
         grid.setPadding(new Insets(0, 1, 0, 1));

         Button b1 = new Button("b1");
         grid.add(b1, 1, 1);

         for (int i = 0; i < 10; i++)
             for (int j = 0; j < 10; j++) {
                 Button b = new Button();
                 b.setMaxSize(50, 50);
                 b.setMinSize(50, 50);
                 grid.add(b, i, j);
             }

         Button button = (Button) grid.getChildren().get(11);

         button.setText("hej");

         grid.setGridLinesVisible(true);
         Scene scene = new Scene(grid, 1000, 1000);
         primaryStage.setTitle("Goal Scorers!");
         primaryStage.setScene(scene);
         primaryStage.show();
     }


     public static void main(String[] args) {
         launch(args);
     }
 }