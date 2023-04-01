package wsu.edu.traintrackjavafx.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import wsu.edu.traintrackjavafx.model.Clicker;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.TrackType;
import wsu.edu.traintrackjavafx.view.MainView;

import java.io.IOException;

public class ApplicationController {
    private static final int GRID_COLUMNS = 120;
    private static final int GRID_ROWS = 85;
    MainView mainView;
    Grid grid;
    Clicker clicker;

    public ApplicationController(Stage stage){
        this.grid = new Grid(this);
        this.clicker = new Clicker(this);
        mainView = new MainView(stage, this);
    }
    public void start() throws IOException {
        mainView.show();
    }
    public void addTrack(TrackType trackType){
        System.out.println("add track called");
        if (grid.appendTrack(trackType)){
            mainView.addTrack(grid.getRecentTrack());
        } else {
            System.out.println("unable to add track");
        }
    }

    public void removeTrack(Track track){

    }

    public void setClickerTrackType(TrackType trackType){
        clicker.setTrackType(trackType);
    }


}
