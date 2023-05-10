package wsu.edu.traintrackjavafx.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import wsu.edu.traintrackjavafx.controller.commands.AddObjectCommand;
import wsu.edu.traintrackjavafx.controller.commands.CommandHistory;
import wsu.edu.traintrackjavafx.controller.commands.EditConfigurationCommand;
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
    CommandHistory commandHistory;

    public ApplicationController(Stage stage){
        this.grid = new Grid(this);
        mainView = new MainView(stage, this);
        this.commandHistory = new CommandHistory();
    }
    public void start() throws IOException {
        mainView.show();
    }
    public void addTrack(TrackType trackType){
        AddObjectCommand aoc = new AddObjectCommand(trackType, this.grid, this.mainView);
        commandHistory.clearRedo();
        commandHistory.executeCommand(aoc);
        System.out.println("add track called");
        updateConfigText();
    }

    public void clearAll(){

    }

    public void undo(){
        commandHistory.undo();
        updateConfigText();
    }
    public void redo(){
        commandHistory.redo();
        updateConfigText();
    }

    public void editConfiguration(String s){
        if (s.compareTo(grid.getCurrentConfiguration()) == 0){
            return;
        }
        EditConfigurationCommand ecc = new EditConfigurationCommand(s, this.grid, this.mainView);
        commandHistory.clearRedo();
        commandHistory.executeCommand(ecc);
        updateConfigText();
    }

    public void removeTrack(Track track){

    }

    public void updateConfigText(){
        String text = grid.getCurrentConfiguration();
        mainView.updateConfigText(text);
    }




}
