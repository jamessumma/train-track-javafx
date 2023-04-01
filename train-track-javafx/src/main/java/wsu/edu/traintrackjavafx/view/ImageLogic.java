package wsu.edu.traintrackjavafx.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

public class ImageLogic {

    public ImageLogic(){

    }
    private static final String[] imageUrls = new String[]{
        "/wsu/edu/traintrackjavafx/trackImages/q1Bottom.png",
                "/wsu/edu/traintrackjavafx/trackImages/q4Top.png",
                "/wsu/edu/traintrackjavafx/trackImages/q4Bottom.png",
                "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png",
                "/wsu/edu/traintrackjavafx/trackImages/q3Top.png",
                "/wsu/edu/traintrackjavafx/trackImages/q2Bottom.png",
                "/wsu/edu/traintrackjavafx/trackImages/q2Top.png",
                "/wsu/edu/traintrackjavafx/trackImages/q1Top.png"
    };

    public ImageView getTrackImage(Track track){
        TrackType trackType = track.getTrackType();
        Direction direction = track.getInDirection();
        String imageUrl;
        Image image;
        ImageView imageView;
        if (trackType == TrackType.CURVELEFT){
            switch (direction){
                case UP:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case RIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWNRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWN:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWNLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case LEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                default:
                    return null;
            }
        } else if (trackType == TrackType.CURVERIGHT){
            switch (direction){
                case UP:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q2Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case RIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWNRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q1Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWN:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case DOWNLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q4Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case LEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Top.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                default:
                    return null;
            }
        } else {
            switch (direction){
                case UP, DOWN:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/vertical.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case LEFT, RIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/horizontal.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPLEFT, DOWNRIGHT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/diagonalLeft.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                case UPRIGHT, DOWNLEFT:
                    imageUrl = "/wsu/edu/traintrackjavafx/trackImages/diagonalRight.png";
                    image = new Image(getClass().getResourceAsStream(imageUrl));
                    imageView = new ImageView(image);
                    return imageView;
                default:
                    return null;
            }
        }
    }

}
