package wsu.edu.traintrackjavafx.controller.commands;

import javafx.scene.layout.GridPane;
import wsu.edu.traintrackjavafx.model.Track;

public class AddObjectCommand implements Command {
    private int row;
    private int col;
    private Track track;
    GridPane gridPane;

    public AddObjectCommand(int row, int col, Track track, GridPane gridPane) {
        this.row = row;
        this.col = col;
        this.track = track;
        this.gridPane = gridPane;
    }

    @Override
    public void execute() {
        // Add the object of the specified track to the grid at the specified cell
        // ...
    }

    @Override
    public void undo() {
        // Remove the object from the grid at the specified cell
        // ...
    }
}

