package com.aldoivan10.jfxwindow;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application
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
        btn.setOnAction(event -> {
            if(window.look().equals(JFXLook.WIN10)) window.setLook(JFXLook.WIN11);
            else window.setLook(JFXLook.WIN10);
        });
        window.setContent(btn);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}