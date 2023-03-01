package wsu.edu.traintrackjavafx.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    // ratio 16:9 for every 16 cols there are 9 rows
    private final int ROWS = 90;
    private final int COLUMNS = 160;
    private OrderedPair nextPos;
    private List<Track> tracks;

    public Grid(){
        this.tracks = new ArrayList<>();
    }


    // place a track in the grid, make sure it is a valid placement
    public boolean add(Track track){
        OrderedPair op = track.getCurPos();
        if (!inBounds(op)){
            return false;
        }

        // makes sure we are not placing a track in a spot that is taken
        for (int i = 0; i < tracks.size(); i++) {
            if (op.equals(tracks.get(i).getCurPos())){
                return false;
            }
        }
        tracks.add(track);
        return true;
    }


    public boolean remove(Track track){
        OrderedPair op = track.getCurPos();
        for (int i = 0; i < tracks.size(); i++) {
            if (op.equals(tracks.get(i).getCurPos())){
                return false;
            }
        }
        return true;
    }

    // checks if a coordinate is in bounds based on the size of the grid
    private boolean inBounds(OrderedPair op){
        return (op.getX() >= 0 && op.getX() < COLUMNS && op.getY() >= 0 && op.getY() < ROWS);
    }

    // this effectively removes the track stored at index by shifting everything to the left
    private boolean shiftFrom(int index){
        if (index >= this.tracks.size() || index < 0) return false;
        for (int i = index; i < tracks.size() - 1; i++) {
            tracks.set(i, tracks.get(i+1));
        }
        // remove the duplicate
        tracks.remove(tracks.size() - 1);
        return true;
    }

}
