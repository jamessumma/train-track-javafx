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
    private OrderedPair startPos;
    private List<Track> tracks;
    ApplicationController controller;
    String currentConfiguration;

    public Grid(ApplicationController controller){
        this.controller = controller;
        this.tracks = new ArrayList<>();
        this.currentConfiguration = "";
        this.startPos = new OrderedPair(START_X, START_Y);
    }

    public OrderedPair getNextPos() {
        if (tracks.size() <= 0){
            return new OrderedPair(START_X, START_Y);
        } else {
            nextPos = tracks.get(tracks.size() - 1).getNextPos();
        }
        return nextPos;
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
        if (trackType == TrackType.STRAIGHT){
            this.currentConfiguration += "S";
        } else if (trackType == TrackType.CURVELEFT){
            this.currentConfiguration += "L";
        } else {
            this.currentConfiguration += "R";
        }
        System.out.println(currentConfiguration);
        return true;
    }

    public void removeRecent(){
        if (tracks.size() >= 1){
            String newConfig = "";
            for (int i = 0; i < currentConfiguration.length()-1; i++) {
                newConfig += currentConfiguration.charAt(i);
            }
            tracks.remove(tracks.size() - 1);
            this.currentConfiguration = newConfig;
        }
    }

    public String getCurrentConfiguration(){
        return currentConfiguration;
    }


    public void editConfiguration(String s){
        while (!tracks.isEmpty()){
            tracks.remove(0);
        }
        this.currentConfiguration = s;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'L'){
                appendTrack(TrackType.CURVELEFT);
            } else if (cur == 'S'){
                appendTrack(TrackType.STRAIGHT);
            } else if (cur == 'R'){
                appendTrack(TrackType.CURVERIGHT);
            }
        }
    }
    public void removeAll(){
        this.currentConfiguration = "";
        while (!tracks.isEmpty()){
            tracks.remove(0);
        }
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
