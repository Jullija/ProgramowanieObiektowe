package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    final int IMAGE_SIZE=20;
    private Image image;
    private ImageView imageView;
    private Label label;
    private VBox verticalBox;

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {

        try{
            Image image = new Image(new FileInputStream(mapElement.getImagePath()));
            imageView = new ImageView(image);
            imageView.setFitHeight(IMAGE_SIZE);
            imageView.setFitWidth(IMAGE_SIZE);

        } catch(FileNotFoundException e){
            throw new FileNotFoundException(e.getMessage());
        }


        if (mapElement instanceof Animal){
           label = new Label(mapElement.getPosition().toString());
        }
        else{
            label = new Label("FastTravel");
        }

        verticalBox = new VBox(imageView, label);
        verticalBox.getChildren().addAll();
        verticalBox.setAlignment(Pos.CENTER);



    }


    public VBox getVBox() {
        return this.verticalBox;
    }
}
