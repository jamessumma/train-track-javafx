package wsu.edu.traintrackjavafx.view;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import wsu.edu.traintrackjavafx.model.GenericTrack;
import wsu.edu.traintrackjavafx.model.OrderedPair;
import wsu.edu.traintrackjavafx.model.Track;
import wsu.edu.traintrackjavafx.model.enums.Direction;
import wsu.edu.traintrackjavafx.model.enums.TrackType;

import java.util.ArrayList;

public class StackingGridPane {

    private static final int GRID_WIDTH = 159;
    private static final int GRID_HEIGHT = 90;
    private static final int GRID_DIMENSIONS = 9;
    private static final int COL_SPAN = 3;
    private static final int ROW_SPAN = 3;
    private static final ImageLogic imageLogic = new ImageLogic();
    ScrollPane scroller;
    StackPane base;
    GridPane backGround;
    GridPane imageContainer;
    GridPane clickHandler;

    // 2D array where the first index is the x coordinate, and the second is the y coordinate
    // each cell in the array will store a list of StackPanes
    //ArrayList<StackPane>[][] imageTracker;
    StackPane[][] imageTracker;

    ArrayList<StackPane> imageContainers;

    public StackingGridPane() {
        this.scroller = new ScrollPane();
        this.base = new StackPane();
        this.backGround = new GridPane();
        this.imageContainer = new GridPane();
        this.clickHandler = new GridPane();
        this.imageContainers = new ArrayList<>();
        // create a 2D array with the same dimensions as the grid
        this.imageTracker = new StackPane[GRID_WIDTH][GRID_HEIGHT];

        scroller.setContent(base);
        base.getChildren().add(backGround);
        base.getChildren().add(imageContainer);
        base.getChildren().add(clickHandler);
        initialize();
    }

    private void initialize() {
        // set up the imageContainer and clickHandler GridPanes

        // Create a 10x10 grid of rectangles as placeholders for the shapes
        // i is columns, j is rows
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                final int row = j;
                final int col = i;
                Rectangle viewGrid = new Rectangle(GRID_DIMENSIONS, GRID_DIMENSIONS, Color.DARKGREY);
                Rectangle clickDetector = new Rectangle(GRID_DIMENSIONS, GRID_DIMENSIONS, Color.DARKGREY);
                Rectangle placeHolder = new Rectangle(GRID_DIMENSIONS, GRID_DIMENSIONS, Color.DARKGREY);
                clickDetector.setOpacity(0);
                placeHolder.setOpacity(0);
                backGround.add(viewGrid, col, row);
                imageContainer.add(placeHolder, col, row);
                clickHandler.add(clickDetector, col, row);

                clickDetector.setOnMouseClicked(event -> {
                    System.out.println("grid " +"row " + row + " col " + col);
                    /*
                    StackPane stackPane = new StackPane();
                    GridPane.setColumnSpan(stackPane, COL_SPAN);
                    GridPane.setRowSpan(stackPane, ROW_SPAN);
                    String imageUrl = "/wsu/edu/traintrackjavafx/trackImages/q3Bottom.png";
                    Image image = new Image(getClass().getResourceAsStream(imageUrl));
                    ImageView imageView = new ImageView(image);
                    imageView.fitWidthProperty();
                    imageView.setFitWidth(GRID_DIMENSIONS * COL_SPAN);
                    imageView.setFitHeight(GRID_DIMENSIONS * COL_SPAN);
                    stackPane.getChildren().add(imageView);
                    imageContainer.add(stackPane, col-1, row-1);

                    if (imageTracker[col][row] == null) {
                        imageTracker[col][row] = stackPane;
                    }

                     */
                });
            }
        }
    }

    private void initializeImages(){

    }


    public void addTrack(Track track){
        OrderedPair op = track.getCurPos();
        StackPane stackPane;
        int col = op.getX();
        int row = op.getY();
        if (imageTracker[col][row] == null) {
            imageTracker[col][row] = new StackPane();
            stackPane = imageTracker[col][row];
            imageContainers.add(stackPane);
            GridPane.setColumnSpan(stackPane, COL_SPAN);
            GridPane.setRowSpan(stackPane, ROW_SPAN);
            stackPane.setPrefSize(27,27);
            imageContainer.add(stackPane, col-1, row-1);
        }
        stackPane = imageTracker[col][row];

        if (track.getTrackType() == TrackType.STRAIGHT){
            stackPane.getChildren().add(imageLogic.getTrackImage(track));
        } else {
            Arc arc = ArcLogic.getTrackArc(track, stackPane,GRID_DIMENSIONS);
            stackPane.getChildren().add(arc);

        }

         /*
        double height = stackPane.getHeight();
        double centerX = 0.0;
        double startAngle = 45.0;
        double length = 45.0;
        Arc arc = new Arc(centerX, height, GRID_DIMENSIONS * 4, GRID_DIMENSIONS * 4, startAngle, length);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);
        stackPane.getChildren().add(arc);

          */

        //ImageView imageView = imageLogic.getTrackImage(track);
        //imageView.setFitWidth(GRID_DIMENSIONS * COL_SPAN);
        //imageView.setFitHeight(GRID_DIMENSIONS * COL_SPAN);
        //stackPane.getChildren().add(imageView);
    }

    public void removeRecentTrack(Track track){
        OrderedPair op = track.getCurPos();
        int col = op.getX();
        int row = op.getY();
        StackPane stackPane = imageTracker[col][row];
        stackPane.getChildren().remove(stackPane.getChildren().size()-1);
    }

    public void removeAll(){
        for (int i = 0; i < imageContainers.size(); i++) {
            imageContainers.get(i).getChildren().clear();
            //imageContainers.get(i).getChildren().removeAll();
        }
    }
    public void addAll(ArrayList<Track> newConfig){
        for (int i = 0; i < newConfig.size(); i++) {
            addTrack(newConfig.get(i));
        }
    }

    private void addImageHandler(){

    }

    public Node getNode() {
        return this.scroller;
    }
}