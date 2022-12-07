package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;



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
    public void start(Stage primaryStage){

        int xMin = map.getLowerLeftBound().x;
        int yMin = map.getLowerLeftBound().y;
        int xMax = map.getUpperRightBound().x;
        int yMax = map.getUpperRightBound().y;

        int width = 40;
        int height = 40;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        GridPane.setHalignment(new Label("y/x"), HPos.CENTER); //wyśrodkowanie etykiet
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.add(new Label("y/x"), 0, 0);



        //xMin, xMax to miejsca, gdzie znajdują się najbardziej wysunięte elementy -> czyli nasza mapa może zaczynać się od 2, kończyć na 6 (tak jak w przykładzie).
        //Zatem chcemy, aby mapa miała 2 3 4 5 6 -> długość 5, czyli xMax - xMin + 1
        //Na indeksie 1 chcemy mieć liczbę 2 -> 2 + 1 - 1 (xMin + i - 1); na indeksie 2 liczbę 3 -> 2 + 2 -1 itp.
        for (int i = xMin; i <= xMax; i++){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.add(label, i-xMin+1, 0);
        }

        for (int i = yMax; i >= yMin; i--){
            Label label = new Label(Integer.toString(i)); //tutaj yMax, bo współrzędne y rosną w kierunku "do góry"
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.add(label, 0, yMax -i + 1);
        }


        for (int y = yMax; y >= yMin; y--) {
            gridPane.getRowConstraints().add(new RowConstraints(height));

            for (int x = xMin; x <= xMax; x++) {
                if (y==yMax)
                    gridPane.getColumnConstraints().add(new ColumnConstraints(width));
                String result = null;
                Vector2d currentPosition = new Vector2d(x,y);
                if (this.map.isOccupied(currentPosition)) {
                    Object object = this.map.objectAt(currentPosition);
                    if (object != null) {
                        result = object.toString();
                    } else {
                        result = " ";
                    }
                } else {
                    result = " ";
                }
                Label label = new Label(result);

                gridPane.add(label, x-xMin+1,yMax - y+1);
                gridPane.setHalignment(label, HPos.CENTER);
            }}



        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
