module com.server.server {
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
    requires org.slf4j;

    opens com.server.server to javafx.fxml;
    exports com.server.server;
    exports com.server.server.controllers;
    opens com.server.server.controllers to javafx.fxml;
}