package wsu.edu.traintrackjavafx.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import wsu.edu.traintrackjavafx.model.Clicker;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Grid;
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

    public void addViewTrack(GenericTrack genericTrack){
        mainView.addTrack(genericTrack);
    }

    public void removeViewTrack(GenericTrack genericTrack){
        mainView.removeTrack(genericTrack);
    }

    public void addModelTrack(GenericTrack genericTrack){
        grid.add(genericTrack);
    }

    public void removeModelTrack(GenericTrack genericTrack){
        grid.remove(genericTrack);
    }

    public void setClickerTrackType(TrackType trackType){

    }


}
