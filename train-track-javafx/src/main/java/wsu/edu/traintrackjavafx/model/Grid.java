package wsu.edu.traintrackjavafx.model;

import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;
import wsu.edu.traintrackjavafx.model.interfaces.GridInterface;
import wsu.edu.traintrackjavafx.model.interfaces.TrackInterface;

import java.util.ArrayList;
import java.util.List;

public class Grid implements GridInterface {
    // start position grid row 28 col 53
    // ratio 16:9 for every 16 cols there are 9 rows
    private final int ROWS = 89;
    private final int COLUMNS = 160;
    private final int START_X = 53;
    private final int START_Y = 28;
    private OrderedPair nextPos;
    private List<Track> tracks;
    ApplicationController controller;

    public Grid(ApplicationController controller){
        this.controller = controller;
        this.tracks = new ArrayList<>();
    }


    // place a track in the grid, make sure it is a valid placement
    public boolean appendTrack(TrackType trackType){
        Track track;
        OrderedPair op;
        if (tracks.size() <= 0){
            track = new Track(START_X, START_Y, trackType, Direction.LEFT);
            op = track.getCurPos();
        } else {
            Track prevTrack = tracks.get(tracks.size()-1);
            op = prevTrack.nextTrackPosition;
            track = new Track(op.getX(), op.getY(), trackType, prevTrack.getOutDirection());
        }
        if (!inBounds(op)){
            return false;
        }
        tracks.add(track);
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
                return true;
            }
        }
        return true;
    }

    // checks if a coordinate is in bounds based on the size of the grid
    private boolean inBounds(OrderedPair op){
        return (op.getX() >= 0 && op.getX() < COLUMNS && op.getY() >= 0 && op.getY() < ROWS);
    }

    public Track getRecentTrack(){
        return tracks.get(tracks.size()-1);
    }

}
