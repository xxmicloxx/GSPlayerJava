package com.xxmicloxx.gsplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setResources(ResourceBundle.getBundle("com.xxmicloxx.gsplayer.gui.view.res.i18n.MainMenu", Locale.ENGLISH));
        loader.setLocation(getClass().getResource("gui/view/MainWindow.fxml"));
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("GSPlayer");
        if (System.getProperty("java.version").startsWith("1.8")) {
            primaryStage.setScene(new Scene(root));
        } else {
            // java bugfix
            primaryStage.setScene(new Scene(root, 605, 332));
        }
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("gui/view/res/Icon.png")));
        if (SplashScreen.getSplashScreen() != null) {
            SplashScreen.getSplashScreen().close();
        }
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
