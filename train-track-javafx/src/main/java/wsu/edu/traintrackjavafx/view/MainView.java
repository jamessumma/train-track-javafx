package wsu.edu.traintrackjavafx.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {
    private final Stage stage;
    private final Scene scene;
    private final BorderPane root;
    private final ToolbarView toolbarView;
    private final GridView gridView;

    public MainView() {
        this.toolbarView = new ToolbarView();
        this.gridView = new GridView();

        root = new BorderPane();
        root.setTop(toolbarView.getNode());
        root.setCenter(gridView.getNode());

        scene = new Scene(root, 800, 600);
        stage = new Stage();
        stage.setScene(scene);
    }
    public GridView getGridView(){
        return this.gridView;
    }
    public ToolbarView getToolbarView(){
        return this.toolbarView;
    }
    public void show() {
        stage.show();
    }
}
