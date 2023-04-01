package wsu.edu.traintrackjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class MainView {
    private final Stage stage;
    private final Scene scene;
    private final BorderPane root;
    private final ToolbarView toolbarView;
    private final GridView gridView;
    private final StackingGridPane stackingGridPane;

    private final ApplicationController applicationController;

    public MainView(Stage stage, ApplicationController applicationController) {
        this.applicationController = applicationController;
        this.toolbarView = new ToolbarView(applicationController);
        this.gridView = new GridView();
        this.stackingGridPane = new StackingGridPane();

        root = new BorderPane();
        root.setTop(titleBuilder());
        root.setBottom(toolbarView.getNode());
        root.setCenter(stackingGridPane.getNode());

        scene = new Scene(root, 880, 600);
        this.stage = stage;
        stage.setScene(scene);
    }
    public GridView getGridView(){
        return this.gridView;
    }
    public ToolbarView getToolbarView(){
        return this.toolbarView;
    }
    private HBox titleBuilder(){
        HBox titleSpace = new HBox();
        Text title = new Text();
        title.setText("Train Tracks & Tangles");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        titleSpace.getChildren().add(title);
        titleSpace.setAlignment(Pos.CENTER);
        titleSpace.setPadding(new Insets(20, 10, 10, 10));
        return titleSpace;
    }
    public boolean addTrack(Track track){
        stackingGridPane.addTrack(track);
        return true;
    }

    public boolean removeTrack(GenericTrack genericTrack){

        return true;
    }
    public void show() {
        stage.show();
    }
}
