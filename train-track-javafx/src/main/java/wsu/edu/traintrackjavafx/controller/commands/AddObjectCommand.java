package wsu.edu.traintrackjavafx.controller.commands;

import javafx.scene.layout.GridPane;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.TrackType;
import wsu.edu.traintrackjavafx.view.MainView;
import wsu.edu.traintrackjavafx.view.StackingGridPane;

import java.util.Stack;

public class AddObjectCommand implements Command {
    private int row;
    private int col;
    private Track track;
    private Grid grid;

    private StackingGridPane pane;
    MainView mainView;
    TrackType trackType;

    public AddObjectCommand(TrackType trackType, Grid grid, MainView mainView){
        this.grid = grid;
        this.mainView = mainView;
        this.trackType = trackType;
    }

    @Override
    public void execute() {
        grid.appendTrack(this.trackType);
        this.track = grid.getRecentTrack();
        mainView.addTrack(this.track);
        //pane.addTrack(this.track);
        //grid.appendTrack(track.getTrackType());
        // Add the object of the specified track to the grid at the specified cell
        // ...
    }

    @Override
    public void undo() {
        if (this.track != null){
            mainView.removeTrack(this.track);
            grid.removeRecent();
        }
        // Remove the object from the grid at the specified cell
        // ...
    }
}

