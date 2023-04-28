package wsu.edu.traintrackjavafx.controller.commands;

import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.view.MainView;

import java.util.ArrayList;

public class EditConfigurationCommand implements Command{
    String oldConfig;
    String newTrackConfiguration;
    Grid grid;
    MainView mainView;
    public EditConfigurationCommand(String newTrackConfiguration, Grid grid, MainView mainView){
        this.newTrackConfiguration = newTrackConfiguration;
        this.grid = grid;
        this.mainView = mainView;
        this.oldConfig = grid.getCurrentConfiguration();
    }


    @Override
    public void execute() {
        this.grid.editConfiguration(newTrackConfiguration);
        ArrayList<Track> tracks = this.grid.getTracks();
        this.mainView.editConfiguration(tracks);
    }

    @Override
    public void undo() {
        this.grid.editConfiguration(oldConfig);
        ArrayList<Track> tracks = this.grid.getTracks();
        this.mainView.editConfiguration(tracks);
    }
}
