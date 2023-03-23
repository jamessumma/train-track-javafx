package wsu.edu.traintrackjavafx.model;

import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

// this class is intended to test the basic functionality of adding tracks to the screen
// and thus, does not have all the features
public class GenericTrack {
    TrackType trackType;
    Direction inDirection;
    int x;
    int y;

    public GenericTrack(TrackType trackType, Direction inDirection, int x, int y) {
        this.trackType = trackType;
        this.inDirection = inDirection;
        this.x = x;
        this.y = y;
    }

    public GenericTrack(TrackType trackType, int x, int y) {
        this.trackType = trackType;
        this.inDirection = Direction.LEFT;
        this.x = x;
        this.y = y;
    }

    public TrackType getTrackType() {
        return trackType;
    }

    public Direction getInDirection() {
        return inDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
