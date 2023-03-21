package wsu.edu.traintrackjavafx.controller;

import javafx.scene.layout.GridPane;
import wsu.edu.traintrackjavafx.controller.commands.AddObjectCommand;
import wsu.edu.traintrackjavafx.controller.commands.CommandHistory;
import wsu.edu.traintrackjavafx.model.Track;

public class GridController {
    private CommandHistory history = new CommandHistory();
    private GridPane grid;
    private Track track;

    public GridController(){

    }

    public void handleAddObject(int row, int col) {
        AddObjectCommand command = new AddObjectCommand(row, col, track);
        history.executeCommand(command);
    }

    public void handleUndo() {
        history.undo();
    }

    public void handleRedo() {
        history.redo();
    }
}

