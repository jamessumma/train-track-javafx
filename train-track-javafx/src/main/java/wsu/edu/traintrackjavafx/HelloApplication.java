package wsu.edu.traintrackjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wsu.edu.traintrackjavafx.controller.ApplicationController;
import wsu.edu.traintrackjavafx.view.MainView;

import java.io.IOException;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        MainView mainView = new MainView(stage);
        mainView.show();
         */
        ApplicationController applicationController = new ApplicationController(stage);
        applicationController.start();
    }

    public static void main(String[] args) {
        launch();
    }
}