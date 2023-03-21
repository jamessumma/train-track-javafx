package wsu.edu.traintrackjavafx.model;

public class Clicker {
    Track track;

    public Clicker(){
        this.track = null;
    }
    public void selectObject(Track track){
        this.track = track;
    }
    public Track placeObject(){
        Track tmp = this.track;
        this.track = null;
        return tmp;
    }
}
