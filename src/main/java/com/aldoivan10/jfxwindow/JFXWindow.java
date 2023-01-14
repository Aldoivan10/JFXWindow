package com.aldoivan10.jfxwindow;

import com.jfoenix.assets.JFoenixResources;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class JFXWindow
{
    private Scene scene;
    private JFXLook look;
    private final Stage stage;
    private JFXToolbar toolbar;
    private JFXDecorator decorator;
    private final BorderPane parent = new BorderPane();
    private final StackPane container = new StackPane();
    private final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    private final ChangeListener<? super Number> win11Listener = (observableValue, lastHeight, newHeight) ->
    {
        if(newHeight.intValue() == this.screenBounds.getHeight()) this.decorator.getStyleClass().add("jfx-decorator-win-10");
        else this.decorator.getStyleClass().remove("jfx-decorator-win-10");
    };

    public JFXWindow(Stage stage)
    {
        this.stage = stage;
        this.decorator = new JFXDecorator(stage,this.parent);
        this.decorator.setCustomMaximize(true);
        this.scene = new Scene(this.decorator);
        this.stage.setScene(this.scene);
        this.scene.setFill(Color.TRANSPARENT);
        this.stage.initStyle(StageStyle.TRANSPARENT);

        this.parent.setCenter(this.container);
        this.parent.getStyleClass().add("container");

        this.addStyleSheets(JFoenixResources.load("css/jfoenix-fonts.css").toExternalForm(),
                JFoenixResources.load("css/jfoenix-design.css").toExternalForm(),
                Objects.requireNonNull(this.getClass().getResource("md-style.css")).toExternalForm());

        this.setWindowMinSize(300,250);
        this.setWindowSize(800,600);
        this.setLook(JFXLook.WIN11);
    }

    public void setLook(JFXLook look)
    {
        this.look = look;
        switch (look)
        {
            case WIN10 ->
            {
                this.decorator.heightProperty().removeListener(this.win11Listener);
                this.decorator.getStyleClass().add("jfx-decorator-win-10");
            }
            case WIN11 ->
            {
                this.decorator.heightProperty().addListener(this.win11Listener);
                this.decorator.getStyleClass().remove("jfx-decorator-win-10");
            }
        }
    }

    public JFXLook look() { return this.look; }

    public void setWindowMinSize(double width, double height)
    {
        this.stage.setMinWidth(width);
        this.stage.setMinHeight(height);
    }

    public void setWindowSize(double width, double height)
    {
        this.stage.setWidth(width);
        this.stage.setHeight(height);
    }

    public void setWindowMaxSize(double width, double height)
    {
        this.decorator = new JFXDecorator(this.stage, this.parent, false, false, true);
        Scene scene = new Scene(this.decorator);
        scene.setFill(this.scene.getFill());
        scene.getStylesheets().addAll(this.scene.getStylesheets());

        this.stage.setScene(scene);
        this.scene = scene;

        this.stage.widthProperty().addListener((observableValue, oldW, newW) -> { if(newW.doubleValue() > width) this.stage.setWidth(width); });
        this.stage.heightProperty().addListener((observableValue, oldH, newH) -> { if(newH.doubleValue() > height) this.stage.setHeight(height); });
    }

    public void setWindowIcon(String path) { this.decorator.setGraphic(new ImageView(path)); }

    public void addIcons(String... paths)
    {
        for(String path:paths)
        {
            this.stage.getIcons().add(new Image(path));
        }
    }

    public void addIcons(Image... icons) { this.stage.getIcons().addAll(icons); }

    public void setWindowTitle(String title)
    {
        this.decorator.setTitle(title);
        this.stage.setTitle(title);
    }

    public void setContent(Node node) { this.container.getChildren().add(node); }

    public void setDrawerContent(Node node)
    {
        if(this.toolbar == null) { this.toolbar = new JFXToolbar(); }

        JFXDrawer drawer = new JFXDrawer();
        drawer.setContent(this.container);
        drawer.setSidePane(node);
        drawer.setPrefWidth(250);

        this.toolbar.setPadding(new Insets(5,10,5,10));
        this.toolbar.getLeftItems().add(this.buildHmbButton(drawer));

        this.parent.setCenter(drawer);
        this.parent.setTop(this.toolbar);
    }

    private JFXRippler buildHmbButton(JFXDrawer drawer)
    {
        JFXHamburger hmbButton = new JFXHamburger();
        JFXRippler rippler = new JFXRippler(hmbButton, JFXRippler.RipplerMask.CIRCLE);
        HamburgerBasicCloseTransition animation = new HamburgerBasicCloseTransition(hmbButton);
        hmbButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->
        {
            animation.setRate(animation.getRate() * -1);
            animation.play();

            if(drawer.isClosed() || drawer.isClosing()) drawer.open();
            else drawer.close();
        });
        animation.setRate(-1);
        hmbButton.setPadding(new Insets(10));
        rippler.setRipplerFill(Color.WHITE);

        return rippler;
    }

    public void setToolbar(JFXToolbar toolbar) { this.toolbar = toolbar; }

    public ObservableList<String> stylesheets() { return this.scene.getStylesheets(); }

    public void addStyleSheets(String... stylesheets) { for(String stylesheet:stylesheets) { this.stylesheets().add(stylesheet); } }

    public Stage stage() { return stage; }

    public Scene scene() { return scene; }

    public JFXDecorator decorator() { return decorator; }

    public StackPane container() { return this.container; }

    public JFXToolbar toolbar() { return this.toolbar; }

    public BorderPane parent() { return this.parent; }

    public void show() { this.stage.show(); }
}
