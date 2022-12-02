package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application {

    private AbstractWorldMap map;

    @Override
    public void init() throws Exception{

        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        int xMin = map.getLowerLeftBound().x;
        int yMin = map.getLowerLeftBound().y;
        int xMax = map.getUpperRightBound().x;
        int yMax = map.getUpperRightBound().y;

        int width = 40;
        int height = 40;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.add(new Label("y/x"), 0, 0);



        for (int i = xMin; i <= xMax; i++){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            gridPane.add(label, i-xMin+1, 0);
        }

        for (int i = yMax; i >= yMin; i--){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            gridPane.add(label, 0, yMax -i + 1);
        }


        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMax; y >= yMin; y--) {
                Vector2d currentPosition = new Vector2d(x,y);
                if (map.isOccupied(currentPosition)) {
                    Object object = map.objectAt(currentPosition);
                    GuiElementBox guiElementBox = new GuiElementBox((IMapElement) object);
                    VBox verticalBox = guiElementBox.getVBox();
                    gridPane.add(verticalBox, x - xMin + 1, yMax -y + 1);
                    GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
                }
            }}



        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
