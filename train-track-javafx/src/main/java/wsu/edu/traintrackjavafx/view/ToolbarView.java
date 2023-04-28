package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.controller.GridController;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class ToolbarView {
    private final HBox root;
    private GridController controller;
    private ApplicationController applicationController;
    TextField editConfiguration;
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
            applicationController.addTrack(TrackType.CURVELEFT);
        });

        Button straightTrackButton = new Button();
        straightTrackButton.setText("Straight Track");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        straightTrackButton.setOnAction(event -> {
            applicationController.setClickerTrackType(TrackType.STRAIGHT);
            System.out.println("tracktype set to straight");
            applicationController.addTrack(TrackType.STRAIGHT);
        });

        Button rightTrackButton = new Button();
        rightTrackButton.setText("Right Track");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        rightTrackButton.setOnAction(event -> {
            applicationController.setClickerTrackType(TrackType.CURVERIGHT);
            System.out.println("tracktype set to curve right");
            applicationController.addTrack(TrackType.CURVERIGHT);
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
            applicationController.undo();
            // ask the controller to set the clicker to the track associated with the button
        });

        Button redo = new Button();
        redo.setText("Redo");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        redo.setOnAction(event -> {
            applicationController.redo();
            // ask the controller to set the clicker to the track associated with the button
        });

        Button clear = new Button();
        clear.setText("Clear");
        //circleButton.setGraphic(new ImageView(new Image("/images/circle.png")));
        clear.setOnAction(event -> {
            applicationController.redo();
            // ask the controller to set the clicker to the track associated with the button
        });


        VBox configArea = new VBox();
        Text text = new Text();
        text.setText("Track Configuration");
        this.editConfiguration = new TextField();
        Button editConfigButton = new Button();
        editConfigButton.setOnAction(event -> {
            String config = editConfiguration.getText();
            applicationController.editConfiguration(config);
            System.out.println(config);
        });
        editConfigButton.setText("Edit Track Configuration");
        configArea.getChildren().addAll(text, editConfiguration, editConfigButton);

        root.getChildren().addAll(leftTrackButton, straightTrackButton, rightTrackButton, toggleSnapping, undo, redo, configArea);
    }

    public void updateConfigText(String s){
        this.editConfiguration.setText(s);
    }

    public Node getNode() {
        return root;
    }
}
