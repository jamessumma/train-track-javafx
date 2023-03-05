module com.example.traintrackjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens wsu.edu.traintrackjavafx to javafx.fxml;
    exports wsu.edu.traintrackjavafx;
    exports wsu.edu.traintrackjavafx.model;
    exports wsu.edu.traintrackjavafx.tests;
    opens wsu.edu.traintrackjavafx.model to javafx.fxml;
    exports wsu.edu.traintrackjavafx.model.enums;
    opens wsu.edu.traintrackjavafx.model.enums to javafx.fxml;
    exports wsu.edu.traintrackjavafx.model.interfaces;
    opens wsu.edu.traintrackjavafx.model.interfaces to javafx.fxml;
    exports wsu.edu.traintrackjavafx.model.tracks;
    opens wsu.edu.traintrackjavafx.model.tracks to javafx.fxml;
}