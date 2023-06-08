package com.example.calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calendar-window.fxml"));
    public static Scene scene;

    static {
        try {
            scene = new Scene(fxmlLoader.load(), 872, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}