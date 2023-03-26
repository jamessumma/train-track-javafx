package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

    // 2D array where the first index is the x coordinate, and the second is the y coordinate
    // each cell in the array will store a list of StackPanes
    ArrayList<StackPane>[][] imageTracker;

    public StackingGridPane() {
        this.scroller = new ScrollPane();
        this.base = new StackPane();
        this.imageContainer = new GridPane();
        this.clickHandler = new GridPane();
        this.imageTracker = new ArrayList[159][90]; // create a 2D array with the same dimensions as the grid

        scroller.setContent(base);
        base.getChildren().add(imageContainer);
        base.getChildren().add(clickHandler);
        initializeGrids();
    }

    private void initializeGrids() {
        // set up the imageContainer and clickHandler GridPanes

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
                    clickGrid.setOpacity(0);
                    StackPane stackPane = new StackPane();
                    stackPane.getChildren().add(new Rectangle(5, 5, Color.BLUE));
                    imageContainer.add(stackPane, col, row);

                    if (imageTracker[col][row] == null) {
                        imageTracker[col][row] = new ArrayList<>();
                    }
                    imageTracker[col][row].add(stackPane);
                });
            }
        }
    }

    public void addTrack(GenericTrack track){

    }

    private void addImageHandler(){

    }

    public Node getNode() {
        return this.scroller;
    }
}