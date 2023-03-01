package wsu.edu.traintrackjavafx.model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Track {

    // 8 possible directions given that a curved track curves exactly 45 degrees
    public enum Direction {
        DOWN,
        UP,
        LEFT,
        RIGHT,
        UPLEFT,
        UPRIGHT,
        DOWNLEFT,
        DOWNRIGHT
    }
    public enum TrackType{
        STRAIGHT,
        CURVELEFT,
        CURVERIGHT
    }
    TrackType trackType;
    Direction direction;
    OrderedPair curPos;
    OrderedPair nextPos;
    ArrayList<Direction> dirList;
    Track prev;
    Track next;


    public Track(int x, int y, TrackType trackType, Direction direction){
        this.curPos = new OrderedPair(x, y);
        this.trackType = trackType;
        this.dirList = new ArrayList<>();
        initDirList(dirList);
        this.nextPos = calcNextPos(trackType, direction);
    }
    public Track(OrderedPair orderedPair, TrackType trackType, Direction direction){
        this.curPos = orderedPair;
        this.trackType = trackType;
        this.dirList = new ArrayList<>();
        initDirList(dirList);
        this.nextPos = calcNextPos(trackType, direction);
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
     * @param trackType enum CURVEDLEFT, CURVEDRIGHT, or STRAIGHT
     * @param prevDirection enum DOWN, UP, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT
     * @return ordered pair containing coordinates of the next track to be placed
     */
    private OrderedPair calcNextPos(TrackType trackType, Direction prevDirection) {
        Direction relDir = getRelativeDirection(trackType);
        int x = this.curPos.getX();
        int y = this.curPos.getY();

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


    /**
     * gets the direction the track is pointing in
     * @param trackType enum STRAIGHT, CURVEDLEFT, CURVEDRIGHT
     * @return enum DOWN, UP, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT
     */
    private Direction getRelativeDirection(TrackType trackType){
        int index = dirList.indexOf(this.direction);
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

    public Direction getDirection() {
        return direction;
    }

    public OrderedPair getCurPos() {
        return curPos;
    }

    public OrderedPair getNextPos() {
        return nextPos;
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
