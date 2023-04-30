package wsu.edu.traintrackjavafx.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class ArcLogic {

    public static Arc getTrackArc(Track track, StackPane stackPane, int GRID_DIMENSIONS){
        TrackType trackType = track.getTrackType();
        Direction direction = track.getInDirection();
        String imageUrl;
        Image image;
        ImageView imageView;
        if (trackType == TrackType.CURVELEFT){
            switch (direction){
                case UP:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Bottom.png";
                    return getQ1Bottom(stackPane, GRID_DIMENSIONS);
                case UPRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Top.png";
                    return getQ4Top(stackPane, GRID_DIMENSIONS);
                case RIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Bottom.png";
                    return getQ4Bottom(stackPane, GRID_DIMENSIONS);
                case DOWNRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png";
                    return getQ3Bottom(stackPane, GRID_DIMENSIONS);
                case DOWN:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Top.png";
                    return getQ3Top(stackPane, GRID_DIMENSIONS);
                case DOWNLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Bottom.png";
                    return getQ2Bottom(stackPane, GRID_DIMENSIONS);
                case LEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Top.png";
                    return getQ2Top(stackPane, GRID_DIMENSIONS);
                case UPLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Top.png";
                    return getQ1Top(stackPane, GRID_DIMENSIONS);
                default:
                    return null;
            }
        } else if (trackType == TrackType.CURVERIGHT){
            switch (direction){
                case UP:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Bottom.png";
                    return getQ2Bottom(stackPane, GRID_DIMENSIONS);
                case UPRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Top.png";
                    return getQ2Top(stackPane, GRID_DIMENSIONS);
                case RIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Top.png";
                    return getQ1Top(stackPane, GRID_DIMENSIONS);
                case DOWNRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Bottom.png";
                    return getQ1Bottom(stackPane, GRID_DIMENSIONS);
                case DOWN:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Top.png";
                    return getQ4Top(stackPane, GRID_DIMENSIONS);
                case DOWNLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Bottom.png";
                    return getQ4Bottom(stackPane, GRID_DIMENSIONS);
                case LEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png";
                    return getQ3Bottom(stackPane, GRID_DIMENSIONS);
                case UPLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Top.png";
                    return getQ3Top(stackPane, GRID_DIMENSIONS);
                default:
                    return null;
            }
        }
        else return null;
    }
    public static Arc getQ1Top(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 45.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }

    public static Arc getQ1Bottom(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 0.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }
    public static Arc getQ2Top(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 90.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }

    public static Arc getQ2Bottom(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 135.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }

    public static Arc getQ3Top(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 180.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }
    public static Arc getQ3Bottom(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 225.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }

    public static Arc getQ4Bottom(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 270.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }
    public static Arc getQ4Top(StackPane stackPane, int GRID_DIMENSIONS){
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 315.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4 - 3, GRID_DIMENSIONS * 4 - 3, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        return arc;
    }

}
