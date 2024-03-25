package org.svetlyakov.course_work;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class MyButton extends Button {
    public MyButton (String label) {
        super(label);
        this.setMaxWidth(Double.POSITIVE_INFINITY);
        this.setMaxHeight(Double.POSITIVE_INFINITY);
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
    }

    public MyButton (String label, FontAwesomeSolid icon) {
        super(label);
        this.setMaxWidth(Double.POSITIVE_INFINITY);
        this.setMaxHeight(Double.POSITIVE_INFINITY);
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        SetIcon(icon);
    }

    public void SetIcon(FontAwesomeSolid icon_id) {
        FontIcon icon = new FontIcon(icon_id);
        this.setGraphic(icon);
    }
}
