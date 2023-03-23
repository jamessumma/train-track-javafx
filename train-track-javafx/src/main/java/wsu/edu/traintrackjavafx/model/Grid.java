package wsu.edu.traintrackjavafx.model;

import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.model.interfaces.GridInterface;
import wsu.edu.traintrackjavafx.model.interfaces.TrackInterface;

import java.util.ArrayList;
import java.util.List;

public class Grid implements GridInterface {
    // ratio 16:9 for every 16 cols there are 9 rows
    private final int ROWS = 90;
    private final int COLUMNS = 160;
    private OrderedPair nextPos;
    private List<TrackInterface> tracks;
    ApplicationController controller;

    public Grid(ApplicationController controller){
        this.controller = controller;
        this.tracks = new ArrayList<>();
    }


    // place a track in the grid, make sure it is a valid placement
    public boolean add(GenericTrack track){
        OrderedPair op = new OrderedPair(track.getX(), track.getY());
        if (!inBounds(op)){
            return false;
        }

        // makes sure we are not placing a track in a spot that is taken
        for (int i = 0; i < tracks.size(); i++) {
            if (op.equals(tracks.get(i).getCurPos())){
                return false;
            }
        }
        tracks.add((TrackInterface) track);
        return true;
    }


    public boolean remove(GenericTrack track){
        OrderedPair op = new OrderedPair(track.getX(), track.getY());
        if (!inBounds(op)){
            return false;
        }
        for (int i = 0; i < tracks.size(); i++) {
            if (op.equals(tracks.get(i).getCurPos())){
                tracks.remove(i);
            }
        }
        return true;
    }

    // checks if a coordinate is in bounds based on the size of the grid
    private boolean inBounds(OrderedPair op){
        return (op.getX() >= 0 && op.getX() < COLUMNS && op.getY() >= 0 && op.getY() < ROWS);
    }

}
