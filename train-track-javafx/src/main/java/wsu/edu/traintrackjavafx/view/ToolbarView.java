package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import wsu.edu.traintrackjavafx.controller.GridController;

public class ToolbarView {
    private final HBox root;
    private GridController controller;

    public ToolbarView() {
        root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);

        Button rectangleButton = new Button();
        rectangleButton.setGraphic(new ImageView(new Image("/images/rectangle.png")));
        rectangleButton.setOnAction(event -> {
            // ask the controller to set the clicker to the track associated with the button
        });

        Button circleButton = new Button();
        circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        circleButton.setOnAction(event -> {
            // ask the controller to set the clicker to the track associated with the button
        });

        root.getChildren().addAll(rectangleButton, circleButton);
    }

    public Node getNode() {
        return root;
    }
}
