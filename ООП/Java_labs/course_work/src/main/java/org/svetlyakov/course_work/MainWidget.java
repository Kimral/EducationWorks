package org.svetlyakov.course_work;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.fontawesome5.*;

public class MainWidget extends BorderPane {
    private static BorderPane borderPane;
    public MainWidget() {
        borderPane = new BorderPane();
        borderPane.setTop(InitTop());
        borderPane.setLeft(InitLeft());
    }

    private Pane InitTop() {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        {
            MyButton button = new MyButton("", FontAwesomeSolid.WINDOW_CLOSE);
            button.setOnAction(event -> {
                Platform.exit();;
            });
            hbox.getChildren().add(button);
        }
        return hbox;
    }

    private Pane InitLeft() {
        VBox vbox = new VBox();
        vbox.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        {
            MyButton button = new MyButton("Logo");
            vbox.getChildren().add(button);
        }
        {
            VBox empty_space = new VBox();
            vbox.getChildren().add(empty_space);
            VBox.setVgrow(empty_space, Priority.ALWAYS);
        }
        {
            MyButton button = new MyButton("setting");
            vbox.getChildren().add(button);
        }
        return vbox;
    }

    public Parent asParent() {
        return borderPane ;
    }
}
