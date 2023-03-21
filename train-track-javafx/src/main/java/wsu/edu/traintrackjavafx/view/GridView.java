package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Track;

import java.util.ArrayList;
import java.util.List;

public class GridView {
    private final GridPane root;
    private final List<Shape> shapes;

    public GridView() {
        root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(5);
        root.setVgap(5);

        // Create a 10x10 grid of rectangles as placeholders for the shapes
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle rectangle = new Rectangle(50, 50, Color.WHITE);
                root.add(rectangle, i, j);
                final int row = j;
                final int col = i;
                rectangle.setOnMouseClicked(event -> {
                    // give the controller the row and column of the position clicked
                });
            }
        }
        shapes = new ArrayList<>();
    }

    public void addTrack(GenericTrack track) {
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
