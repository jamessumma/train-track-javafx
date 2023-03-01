module com.example.traintrackjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens wsu.edu.traintrackjavafx to javafx.fxml;
    exports wsu.edu.traintrackjavafx;
    exports wsu.edu.traintrackjavafx.model;
    opens wsu.edu.traintrackjavafx.model to javafx.fxml;
}