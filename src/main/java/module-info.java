module oop.oopdictionary {
    requires java.net.http;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;


    exports oop.oopdictionary.quizgame;
    opens oop.oopdictionary.quizgame to javafx.fxml;
    exports oop.oopdictionary.wordsortgame;
    opens oop.oopdictionary.wordsortgame to javafx.fxml;
}