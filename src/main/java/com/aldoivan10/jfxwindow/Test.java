package com.aldoivan10.jfxwindow;

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
        window.setContent(new JFXComponents(window.parent(), window));
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}