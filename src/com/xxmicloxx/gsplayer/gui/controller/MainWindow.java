package com.xxmicloxx.gsplayer.gui.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindow {
    public AnchorPane dei;

    public void initialize() {
        final Rectangle rect = new Rectangle();
        rect.setFill(Color.BLACK);
        rect.setWidth(dei.getPrefWidth());
        rect.setHeight(dei.getPrefWidth());
        dei.getChildren().add(rect);
        final AnimationTimer timer = new AnimationTimer() {
            int skipCount = 30;
            @Override
            public void handle(long l) {
                if (skipCount != 0) {
                    skipCount--;
                    return;
                }
                double opacity = rect.getOpacity()-0.02;
                opacity = Math.max(0, opacity);
                rect.setOpacity(opacity);
                if (opacity == 0) {
                    stop();
                    dei.getChildren().remove(rect);
                }
            }
        };
        timer.start();
    }
}
