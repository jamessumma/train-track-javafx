package wsu.edu.traintrackjavafx.controller.commands;

import wsu.edu.traintrackjavafx.model.TrackImpl;

public class RemoveObjectCommand implements Command {
    private int row;
    private int col;
    private TrackImpl track;

    public RemoveObjectCommand(int row, int col, TrackImpl track) {
        this.row = row;
        this.col = col;
        this.track = track;
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
