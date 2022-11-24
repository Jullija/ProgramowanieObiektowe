package agh.ics.oop.gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;



public class App extends Application {

    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
//        gridPane.add(new Label("1"), 0, 0);
//        gridPane.add(new Label("1"), 1, 1);

        gridPane.setGridLinesVisible(true);

        for (int i=0; i< 5; i++){
            for (int j=0; j<3; j++){
                    gridPane.add(new Label(Integer.toString(5*i + j)), i, j);
        }}

        for (int i=0; i< 5; i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for (int j=0; j< 3; j++){
            gridPane.getRowConstraints().add(new RowConstraints(40));
        }


        primaryStage.show();
        Scene scene = new Scene(gridPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();





    }


}
