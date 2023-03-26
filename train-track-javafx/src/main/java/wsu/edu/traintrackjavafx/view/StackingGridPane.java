package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

import java.util.ArrayList;
import java.util.HashMap;

public class StackingGridPane {
    ScrollPane scroller;
    StackPane base;
    GridPane imageContainer;
    GridPane clickHandler;

    // hashmap where key is x coordinate, value is a hashmap where key is y coordinate
    // value is the stackpane containing the images
    HashMap<Integer, HashMap<Integer, ArrayList<StackPane>>> imageTracker;
    public StackingGridPane(){
        this.scroller = new ScrollPane();
        this.base = new StackPane();
        this.imageContainer = new GridPane();
        this.clickHandler = new GridPane();
        scroller.setContent(base);
        base.getChildren().add(imageContainer);
        base.getChildren().add(clickHandler);
    }
    private void initializeGrids(){
        imageContainer.setPadding(new Insets(10, 10, 10, 10));
        imageContainer.setHgap(0);
        imageContainer.setVgap(0);
        imageContainer.setAlignment(Pos.CENTER);

        clickHandler.setPadding(new Insets(10, 10, 10, 10));
        clickHandler.setHgap(0);
        clickHandler.setVgap(0);
        clickHandler.setAlignment(Pos.CENTER);


        // Create a 10x10 grid of rectangles as placeholders for the shapes
        // i is columns, j is rows
        for (int i = 0; i < 159; i++) {
            for (int j = 0; j < 90; j++) {
                Rectangle clickGrid = new Rectangle(5, 5, Color.DARKGREY);
                StackPane gridContainer = new StackPane();
                gridContainer.setPrefWidth(5);
                gridContainer.setPrefHeight(5);

                final int row = j;
                final int col = i;
                clickHandler.add(clickGrid, col, row);
                imageContainer.add(gridContainer, col, row);
                clickGrid.setOnMouseClicked(event -> {
                    System.out.println("grid " +"row " + row + " col " + col);
                    gridContainer.getChildren().add(new Rectangle(5, 5, Color.BLUE));
                    //GenericTrack newTrack = new GenericTrack(TrackType.STRAIGHT, Direction.LEFT, row, col);
                    //addTrack(newTrack);
                });
            }
        }
    }

    private void addImageHandler(){

    }
}
