package wsu.edu.traintrackjavafx.controller.commands;

import wsu.edu.traintrackjavafx.controller.commands.Command;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.view.MainView;
import wsu.edu.traintrackjavafx.view.StackingGridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandHistory {
    private List<Command> commands = new ArrayList<>();

    Stack<Command> done;
    Stack<Command> undone;
    Grid grid;
    StackingGridPane pane;

    public CommandHistory(){
        this.done = new Stack<>();
        this.undone = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        this.done.add(command);
    }

    public void undo() {
        if (done.peek() != null){
            Command command = done.pop();
            command.undo();
            this.undone.add(command);
        }
    }

    public void redo() {
        if (undone.peek() != null){
            Command command = undone.pop();
            command.execute();
            done.add(command);
        }
    }

    public void undoAll(){
        while (!done.isEmpty()){
            Command command = done.pop();
            command.undo();
            undone.push(command);
        }
    }

    public void clearHistory(){
        undoAll();
        undone = new Stack<>();
    }
}

