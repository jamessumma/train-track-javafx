package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

import java.util.ArrayList;
import java.util.List;

public class GridView {
    private final GridPane root;
    //private final List<Shape> shapes;

    Shape[][] shapes = new Shape[160][90];
    ApplicationController controller;

    public GridView() {
        root = new GridPane();

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(0);
        root.setVgap(0);
        root.setAlignment(Pos.CENTER);


        // Create a 10x10 grid of rectangles as placeholders for the shapes
        // i is columns, j is rows
        for (int i = 0; i < 159; i++) {
            for (int j = 0; j < 90; j++) {
                Rectangle rectangle = new Rectangle(5, 5, Color.DARKGREY);
                shapes[i][j] = rectangle;
                root.add(rectangle, i, j);
                final int row = j;
                final int col = i;
                rectangle.setOnMouseClicked(event -> {
                    System.out.println("grid " +"row " + row + " col " + col);
                    GenericTrack newTrack = new GenericTrack(TrackType.STRAIGHT, Direction.LEFT, row, col);
                    addTrack(newTrack);
                });
            }
        }
    }

    public void addTrack(GenericTrack track) {
        Rectangle rectangle = new Rectangle(16, 16, Color.BLUE);
        root.add(rectangle, track.getY()-1, track.getX()-1);
        GridPane.setRowSpan(rectangle, 3);
        GridPane.setColumnSpan(rectangle, 3);
        /*
        Node node = shape.getNode();
        int row = (int) shape.getY();
        int col = (int) shape.getX();
        root.add(node, col, row, 3, 3);
        shapes.add(shape);
         */
    }


    public Node getNode() {
        return root;
    }
}
