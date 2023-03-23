package wsu.edu.traintrackjavafx.model;

import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class Clicker {
    GenericTrack track;
    boolean snapping = false;
    Direction direction = Direction.LEFT;
    ApplicationController controller;
    TrackType trackType;

    public Clicker(ApplicationController controller){
        this.controller = controller;
        this.track = null;
    }
    public void selectObject(GenericTrack track){
        this.track = track;
    }

    public GenericTrack placeObject(){
        GenericTrack tmp = this.track;
        this.track = null;
        return tmp;
    }

    public void setTrack(GenericTrack track) {
        this.track = track;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }

    public void setSnapping(boolean snapping) {
        this.snapping = snapping;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
