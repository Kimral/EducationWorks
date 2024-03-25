package org.svetlyakov.course_work;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setMinWidth(400);
        stage.setMinHeight(300);

        stage.setScene(CreateScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Scene CreateScene() {
        MainWidget main_scene = new MainWidget();
        return new Scene(main_scene.asParent(), 400, 300);
    }
}