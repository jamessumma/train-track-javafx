package wsu.edu.traintrackjavafx.model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;
import wsu.edu.traintrackjavafx.model.interfaces.TrackInterface;

import java.util.ArrayList;

public class Track implements TrackInterface {
    private static final int TRACK_OFFSET = 2;

    // 8 possible directions given that a curved track curves exactly 45 degrees

    TrackType trackType;
    Direction inDirection;
    OrderedPair curTrackPosition;
    OrderedPair nextTrackPosition;
    ArrayList<Direction> dirList;
    Track prev;
    Track next;


    public Track(int x, int y, TrackType trackType, Direction inDirection){
        this.inDirection = inDirection;
        this.curTrackPosition = new OrderedPair(x, y);
        this.trackType = trackType;
        this.dirList = new ArrayList<>();
        initDirList(dirList);
        this.nextTrackPosition = calcNextPos();
    }
    public Track(OrderedPair orderedPair, TrackType trackType, Direction inDirection){
        this.inDirection = inDirection;
        this.curTrackPosition = orderedPair;
        this.trackType = trackType;
        this.dirList = new ArrayList<>();
        initDirList(dirList);
        this.nextTrackPosition = calcNextPos();
    }

    public void initDirList(ArrayList<Direction> list){
        list.add(Direction.UP);
        list.add(Direction.UPRIGHT);
        list.add(Direction.RIGHT);
        list.add(Direction.DOWNRIGHT);
        list.add(Direction.DOWN);
        list.add(Direction.DOWNLEFT);
        list.add(Direction.LEFT);
        list.add(Direction.UPLEFT);
    }

    /**
     * calculate the position of the next track based on the current track's type and direction
     * @return ordered pair containing coordinates of the next track to be placed
     */
    private OrderedPair calcNextPos() {
        Direction relDir = getOutDirection();
        int x = this.curTrackPosition.getX();
        int y = this.curTrackPosition.getY();

        if (relDir == Direction.UP) {
            y-=TRACK_OFFSET;
        } else if (relDir == Direction.UPRIGHT) {
            x+=TRACK_OFFSET;
            y-=TRACK_OFFSET;
        } else if (relDir == Direction.RIGHT) {
            x+=TRACK_OFFSET;
        } else if (relDir == Direction.DOWNRIGHT) {
            x+=TRACK_OFFSET;
            y+=TRACK_OFFSET;
        } else if (relDir == Direction.DOWN) {
            y+=TRACK_OFFSET;
        } else if (relDir == Direction.DOWNLEFT) {
            x-=TRACK_OFFSET;
            y+=TRACK_OFFSET;
        } else if (relDir == Direction.LEFT) {
            x-=TRACK_OFFSET;
        } else if (relDir == Direction.UPLEFT) {
            x-=TRACK_OFFSET;
            y-=TRACK_OFFSET;
        }
        return new OrderedPair(x, y);
    }
    /*
    private OrderedPair calcNextPos() {
        Direction relDir = getOutDirection();
        int x = this.curTrackPosition.getX();
        int y = this.curTrackPosition.getY();

        if (relDir == Direction.UP) {
            y--;
        } else if (relDir == Direction.UPRIGHT) {
            x++;
            y--;
        } else if (relDir == Direction.RIGHT) {
            x++;
        } else if (relDir == Direction.DOWNRIGHT) {
            x++;
            y++;
        } else if (relDir == Direction.DOWN) {
            y++;
        } else if (relDir == Direction.DOWNLEFT) {
            x--;
            y++;
        } else if (relDir == Direction.LEFT) {
            x--;
        } else if (relDir == Direction.UPLEFT) {
            x--;
            y--;
        }
        return new OrderedPair(x, y);
    }

     */


    /**
     * gets the direction the track is pointing in
     * @return enum DOWN, UP, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT
     */
    public Direction getOutDirection(){
        int index = dirList.indexOf(this.inDirection);
        int nextIndex = -1;

        if (this.trackType == TrackType.STRAIGHT) {
            nextIndex = index;
        } else if (this.trackType == TrackType.CURVELEFT) {
            nextIndex = (index + dirList.size() - 1) % dirList.size();
        } else if (this.trackType == TrackType.CURVERIGHT) {
            nextIndex = (index + 1) % dirList.size();
        }

        return dirList.get(nextIndex);
    }

    public TrackType getTrackType() {
        return trackType;
    }

    public Direction getInDirection() {
        return inDirection;
    }

    public OrderedPair getCurPos() {
        return curTrackPosition;
    }

    public OrderedPair getNextPos() {
        return nextTrackPosition;
    }

    public Shape getTrack(){
        return new Rectangle();
    }

    public Track getPrev() {
        return prev;
    }

    public void setPrev(Track prev) {
        this.prev = prev;
    }

    public Track getNext() {
        return next;
    }

    public void setNext(Track next) {
        this.next = next;
    }
}
