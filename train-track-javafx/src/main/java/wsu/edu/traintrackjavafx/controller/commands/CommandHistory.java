package wsu.edu.traintrackjavafx.controller.commands;

import wsu.edu.traintrackjavafx.controller.commands.Command;
import wsu.edu.traintrackjavafx.model.Grid;
import wsu.edu.traintrackjavafx.view.MainView;
import wsu.edu.traintrackjavafx.view.StackingGridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandHistory {

    Stack<Command> done;
    Stack<Command> undone;

    public CommandHistory(){
        this.done = new Stack<>();
        this.undone = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        this.done.add(command);
    }

    public void undo() {
        if (done.isEmpty()){
            return;
        }
        if (done.peek() != null){
            Command command = done.pop();
            command.undo();
            this.undone.add(command);
        }
    }

    public void redo() {
        if (undone.isEmpty()){
            return;
        }
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
    public void clearRedo(){
        this.undone = new Stack<>();
    }

}

