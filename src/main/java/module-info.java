module com.imob {
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
    requires java.logging;
    requires java.sql;
    requires com.jfoenix;

    opens com.imob.view to javafx.fxml;
    opens com.imob.model.domain to javafx.fxml;
    exports com.imob.view;
    exports com.imob.model.domain;



}