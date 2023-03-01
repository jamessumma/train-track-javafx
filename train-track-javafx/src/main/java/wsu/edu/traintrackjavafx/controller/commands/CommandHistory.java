package wsu.edu.traintrackjavafx.controller.commands;

import wsu.edu.traintrackjavafx.controller.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<Command> commands = new ArrayList<>();
    private int position = -1;

    public void executeCommand(Command command) {
        command.execute();
        commands.subList(position + 1, commands.size()).clear();
        commands.add(command);
        position++;
    }

    public boolean canUndo() {
        return position >= 0;
    }

    public void undo() {
        if (canUndo()) {
            commands.get(position).undo();
            position--;
        }
    }

    public boolean canRedo() {
        return position < commands.size() - 1;
    }

    public void redo() {
        if (canRedo()) {
            commands.get(position + 1).execute();
            position++;
        }
    }
}

