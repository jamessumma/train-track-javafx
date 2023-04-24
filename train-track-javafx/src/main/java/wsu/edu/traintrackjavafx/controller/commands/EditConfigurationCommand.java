package wsu.edu.traintrackjavafx.controller.commands;

import org.testng.reporters.jq.Main;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.view.MainView;

public class EditConfigurationCommand implements Command{
    String oldConfig;
    String newConfig;
    Grid grid;
    MainView mainView;
    public EditConfigurationCommand(String newTrackConfiguration, Grid grid, MainView mainView){
        this.newConfig = newTrackConfiguration;
        this.grid = grid;
        this.mainView = mainView;
        this.oldConfig = grid.getCurrentConfiguration();
    }


    @Override
    public void execute() {
        this.grid.editConfiguration(newConfig);

    }

    @Override
    public void undo() {
        this.grid.editConfiguration(oldConfig);
    }
}
