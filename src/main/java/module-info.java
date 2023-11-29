module oop.oopdictionary {
    requires java.net.http;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;
    requires com.jfoenix;


    exports oop.oopdictionary.quizgame;
    opens oop.oopdictionary.quizgame to javafx.fxml;
    exports oop.oopdictionary.wordsortgame;
    opens oop.oopdictionary.wordsortgame to javafx.fxml;
    exports oop.oopdictionary;
    opens oop.oopdictionary to javafx.fxml;
    exports oop.oopdictionary.design;
    opens oop.oopdictionary.design to javafx.fxml;
    exports oop.oopdictionary.mydictionary;
    opens oop.oopdictionary.mydictionary to javafx.fxml;
    exports oop.oopdictionary.menu;
    opens oop.oopdictionary.menu to javafx.graphics, javafx.fxml;
}