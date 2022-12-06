package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IPositionChangeObserver{

    private AbstractWorldMap map;
    private GridPane gridPane = new GridPane();
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private SimulationEngine simulationEngine;


    @Override
    public void init() throws IllegalArgumentException{

        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            simulationEngine = new SimulationEngine(directions, map, positions, 1000, this);

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }



    public void updateBounds(){

        xMin = map.getLowerLeftBound().x;
        yMin = map.getLowerLeftBound().y;
        xMax = map.getUpperRightBound().x;
        yMax = map.getUpperRightBound().y;
    }


    public void xyLabel(){

        GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(WIDTH));
        gridPane.getRowConstraints().add(new RowConstraints(HEIGHT));
        gridPane.add(new Label("y/x"), 0, 0);
    }

    public void columnsFunction(){

        for (int i = xMin; i <= xMax; i++){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(WIDTH));
            gridPane.add(label, i-xMin+1, 0);
        }
    }

    public void rowsFunction(){

        for (int i = yMax; i >= yMin; i--){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(HEIGHT));
            gridPane.add(label, 0, yMax -i + 1);
        }
    }

    public void addElements() throws FileNotFoundException {

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMax; y >= yMin; y--) {
                Vector2d currentPosition = new Vector2d(x,y);
                if (map.isOccupied(currentPosition)) {
                    Object object = map.objectAt(currentPosition);
                    GuiElementBox guiElementBox = new GuiElementBox((IMapElement) object);
                    VBox verticalBox = guiElementBox.getVBox();
                    gridPane.add(verticalBox, x - xMin + 1, yMax -y + 1);
                    GridPane.setHalignment(verticalBox, HPos.CENTER);
                }
            }}

    }

    public void prepareScene() throws FileNotFoundException {
        this.updateBounds();
        this.xyLabel();
        this.columnsFunction();
        this.rowsFunction();
        this.addElements();
        gridPane.setGridLinesVisible(true);
    }


    public void refreshMap(){
        Platform.runLater(() ->{
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();

            try {
                prepareScene();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    };

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Button button = new Button("Graj muzyko");
        TextField textField = new TextField();
        HBox hbox = new HBox(textField, button); //pojemnik na buttony

        button.setOnAction(event -> {
            String[] args = textField.getText().split(" ");
            MoveDirection[] directions = new OptionsParser().parse(args);
            simulationEngine.setMoveDirections(directions);
            Thread thread = new Thread(this.simulationEngine);
            thread.start();
        });





        prepareScene();
        VBox mapAndButtons = new VBox(hbox, gridPane);

        Scene scene = new Scene(mapAndButtons, WIDTH * ((xMax - xMin) + 2 ), HEIGHT * ((yMax - yMin) + 3));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() ->{
            refreshMap();
        });
    }
}
