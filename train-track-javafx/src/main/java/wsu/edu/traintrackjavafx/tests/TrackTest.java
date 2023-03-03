package wsu.edu.traintrackjavafx.tests;

import org.testng.annotations.Test;
import wsu.edu.traintrackjavafx.model.OrderedPair;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

import static org.testng.AssertJUnit.assertEquals;


public class TrackTest {

    @Test
    public void testCalcNextPos() {
        Track straightTrack = new Track(0, 0, TrackType.STRAIGHT, Direction.RIGHT);
        assert straightTrack.getNextPos().equals(new OrderedPair(1,0));

        Track leftCurveTrack = new Track(0, 0, TrackType.CURVELEFT, Direction.RIGHT);
        assert leftCurveTrack.getNextPos().equals(new OrderedPair(1,-1));

        Track rightCurveTrack = new Track(0, 0, TrackType.CURVERIGHT, Direction.UP);
        assert rightCurveTrack.getNextPos().equals(new OrderedPair(1,-1));
    }

    @Test
    public void testGetOutDirectionStraight() {
        Track up = new Track(0, 0, TrackType.STRAIGHT, Direction.UP);
        assertEquals(Direction.UP, up.getOutDirection());

        Track upright = new Track(0, 0, TrackType.STRAIGHT, Direction.UPRIGHT);
        assertEquals(Direction.UPRIGHT, upright.getOutDirection());

        Track right = new Track(0, 0, TrackType.STRAIGHT, Direction.RIGHT);
        assertEquals(Direction.RIGHT, right.getOutDirection());

        Track downright = new Track(0, 0, TrackType.STRAIGHT, Direction.DOWNRIGHT);
        assertEquals(Direction.DOWNRIGHT, downright.getOutDirection());

        Track down = new Track(0, 0, TrackType.STRAIGHT, Direction.DOWN);
        assertEquals(Direction.DOWN, down.getOutDirection());

        Track downleft = new Track(0, 0, TrackType.STRAIGHT, Direction.DOWNLEFT);
        assertEquals(Direction.DOWNLEFT, downleft.getOutDirection());

        Track left = new Track(0, 0, TrackType.STRAIGHT, Direction.LEFT);
        assertEquals(Direction.LEFT, left.getOutDirection());

        Track upleft = new Track(0, 0, TrackType.STRAIGHT, Direction.UPLEFT);
        assertEquals(Direction.UPLEFT, upleft.getOutDirection());
    }

    @Test
    public void testGetOutDirectionLeft(){
        Track upLeft = new Track(0, 0, TrackType.CURVELEFT, Direction.UP);
        assertEquals(Direction.UPLEFT, upLeft.getOutDirection());

        Track left = new Track(0, 0, TrackType.CURVELEFT, Direction.LEFT);
        assertEquals(Direction.DOWNLEFT, left.getOutDirection());

        Track downLeft = new Track(0, 0, TrackType.CURVELEFT, Direction.DOWN);
        assertEquals(Direction.DOWNRIGHT, downLeft.getOutDirection());

        Track down = new Track(0, 0, TrackType.CURVELEFT, Direction.DOWNLEFT);
        assertEquals(Direction.DOWN, down.getOutDirection());

        Track downRight = new Track(0, 0, TrackType.CURVELEFT, Direction.DOWNRIGHT);
        assertEquals(Direction.RIGHT, downRight.getOutDirection());

        Track right = new Track(0, 0, TrackType.CURVELEFT, Direction.RIGHT);
        assertEquals(Direction.UPRIGHT, right.getOutDirection());

        Track upRight = new Track(0, 0, TrackType.CURVELEFT, Direction.UPRIGHT);
        assertEquals(Direction.UP, upRight.getOutDirection());

        Track up = new Track(0, 0, TrackType.CURVELEFT, Direction.UPLEFT);
        assertEquals(Direction.LEFT, up.getOutDirection());
    }

    @Test
    public void testGetOutDirectionRight(){
        Track upRight = new Track(0, 0, TrackType.CURVERIGHT, Direction.UP);
        assertEquals(Direction.UPRIGHT, upRight.getOutDirection());

        Track right = new Track(0, 0, TrackType.CURVERIGHT, Direction.RIGHT);
        assertEquals(Direction.DOWNRIGHT, right.getOutDirection());

        Track downRight = new Track(0, 0, TrackType.CURVERIGHT, Direction.DOWN);
        assertEquals(Direction.DOWNLEFT, downRight.getOutDirection());

        Track down = new Track(0, 0, TrackType.CURVERIGHT, Direction.DOWNRIGHT);
        assertEquals(Direction.DOWN, down.getOutDirection());

        Track downLeft = new Track(0, 0, TrackType.CURVERIGHT, Direction.DOWNLEFT);
        assertEquals(Direction.LEFT, downLeft.getOutDirection());

        Track left = new Track(0, 0, TrackType.CURVERIGHT, Direction.LEFT);
        assertEquals(Direction.UPLEFT, left.getOutDirection());

        Track upLeft = new Track(0, 0, TrackType.CURVERIGHT, Direction.UPLEFT);
        assertEquals(Direction.UP, upLeft.getOutDirection());

        Track up = new Track(0, 0, TrackType.CURVERIGHT, Direction.UPRIGHT);
        assertEquals(Direction.RIGHT, up.getOutDirection());
    }

    @Test
    public void testGettersAndSetters() {
        Track track = new Track(0, 0, TrackType.STRAIGHT, Direction.UP);
        assertEquals(TrackType.STRAIGHT, track.getTrackType());
        assertEquals(Direction.UP, track.getInDirection());
        assertEquals(0, track.getCurPos().getX());
        assertEquals(0, track.getCurPos().getY());
    }
}

