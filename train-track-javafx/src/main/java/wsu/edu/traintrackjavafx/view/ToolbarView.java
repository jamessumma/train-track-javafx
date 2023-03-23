package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.controller.GridController;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class ToolbarView {
    private final HBox root;
    private GridController controller;
    private ApplicationController applicationController;
    public ToolbarView(ApplicationController applicationController) {
        this.applicationController = applicationController;
        root = new HBox();
        root.setPadding(new Insets(1, 1, 1, 1));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        Button leftTrackButton = new Button();
        leftTrackButton.setText("Left Curve");
        //rectangleButton.setGraphic(new ImageView(new Image("/images/rectangle.png")));
        leftTrackButton.setOnAction(event -> {
            applicationController.setClickerTrackType(TrackType.CURVELEFT);
            System.out.println("tracktype set to curve left");
        });

        Button straightTrackButton = new Button();
        straightTrackButton.setText("Straight Track");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        straightTrackButton.setOnAction(event -> {
            applicationController.setClickerTrackType(TrackType.STRAIGHT);
            System.out.println("tracktype set to straight");

        });

        Button rightTrackButton = new Button();
        rightTrackButton.setText("Right Track");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        rightTrackButton.setOnAction(event -> {
            applicationController.setClickerTrackType(TrackType.CURVERIGHT);
            System.out.println("tracktype set to curve right");
        });

        Button toggleSnapping = new Button();
        toggleSnapping.setText("Toggle Snapping");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        toggleSnapping.setOnAction(event -> {
            // ask the controller to set the clicker to the track associated with the button
        });

        Button undo = new Button();
        undo.setText("Undo");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        undo.setOnAction(event -> {
            // ask the controller to set the clicker to the track associated with the button
        });

        Button redo = new Button();
        redo.setText("Redo");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        redo.setOnAction(event -> {
            // ask the controller to set the clicker to the track associated with the button
        });


        root.getChildren().addAll(leftTrackButton, straightTrackButton, rightTrackButton, toggleSnapping, undo, redo);
    }

    public Node getNode() {
        return root;
    }
}
