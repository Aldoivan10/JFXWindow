package com.aldoivan10.jfxwindow;

import com.jfoenix.controls.JFXRadioButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application
{
    @Override
    public void start(Stage stage)
    {
        final
        JFXWindow window = new JFXWindow(stage);
        window.setWindowIcon(this.getClass().getResource("icon/icon16x16.png").toExternalForm());
        window.addIcons(this.getClass().getResource("icon/icon16x16.png").toExternalForm(),
                this.getClass().getResource("icon/icon32x32.png").toExternalForm(),
                this.getClass().getResource("icon/icon48x48.png").toExternalForm(),
                this.getClass().getResource("icon/icon64x64.png").toExternalForm());
        window.setWindowTitle("Window test");
        window.setContent(new JFXComponents(window.parent()));
        window.setDrawerContent(getThemes(window));
        window.show();
    }

    public static ScrollPane getThemes(JFXWindow window)
    {
        ToggleGroup group = new ToggleGroup();
        ScrollPane scrollPane = new ScrollPane();
        VBox themeContainer = new VBox(15);
        themeContainer.setPadding(new Insets(15));
        scrollPane.setContent(themeContainer);
        scrollPane.setPrefWidth(150);
        scrollPane.setFitToWidth(true);
        for(JFXTheme theme:JFXTheme.values())
        {
            JFXRadioButton radioButton = new JFXRadioButton(theme.theme());
            radioButton.setStyle(String.format("-jfx-selected-color: %s;", theme.primary()));
            radioButton.setSelected(theme.equals(JFXTheme.DEEP_PURPLE_A));
            radioButton.setOnAction(event -> window.setTheme(theme));
            themeContainer.getChildren().add(radioButton);
            radioButton.setToggleGroup(group);
        }
        return scrollPane;
    }

    public static void main(String[] args) {
        launch();
    }
}