package wsu.edu.traintrackjavafx.model.interfaces;

import javafx.scene.shape.Shape;
import wsu.edu.traintrackjavafx.model.OrderedPair;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public interface TrackInterface {

    public TrackType getTrackType();

    public Direction getInDirection();

    public Direction getOutDirection();

    public OrderedPair getCurPos();

    public OrderedPair getNextPos();

    public Shape getTrack();

    public TrackInterface getPrev();

    public TrackInterface getNext();
}
