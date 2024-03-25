module org.svetlyakov.course_work {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.fontawesome5;

    opens org.svetlyakov.course_work to javafx.fxml;
    exports org.svetlyakov.course_work;
}