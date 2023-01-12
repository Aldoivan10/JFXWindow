package com.aldoivan10.jfxwindow;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage)
    {
        JFXWindow window = new JFXWindow(stage);
        window.setWindowIcon(this.getClass().getResource("icon/icon16x16.png").toExternalForm());
        window.addIcons(this.getClass().getResource("icon/icon16x16.png").toExternalForm(),
                this.getClass().getResource("icon/icon32x32.png").toExternalForm(),
                this.getClass().getResource("icon/icon48x48.png").toExternalForm(),
                this.getClass().getResource("icon/icon64x64.png").toExternalForm());
        window.setWindowTitle("Window test");

        JFXButton btn = new JFXButton("Change look and feel");
        btn.setOnAction(event -> {});
        window.setContent(btn);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}