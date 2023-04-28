package wsu.edu.traintrackjavafx.controller.commands;

import org.testng.reporters.jq.Main;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.view.MainView;
import wsu.edu.traintrackjavafx.view.StackingGridPane;

public class RemoveAllCommand implements Command{
    Grid grid;
    MainView mainView;
    public RemoveAllCommand(Grid grid, MainView mainView){
        this.grid = grid;
        this.mainView = mainView;
    }
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
