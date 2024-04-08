package com.example.oop_cw_v1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class AttendanceHelloApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        switchToScene("Attendance.fxml");
        primaryStage.show();
    }

    public void switchToScene(String sceneFXML) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneFXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}