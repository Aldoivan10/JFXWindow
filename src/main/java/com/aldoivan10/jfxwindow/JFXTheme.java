package com.aldoivan10.jfxwindow;

public enum JFXTheme
{
    LIGHT("#333333","WHITE", "#FAFAFA","#4d4d4d", "WHITE", "#CACACA", "-fx-focus-color","#989898"),
    DARK("#BDBDBD","#1B1B1B", "#121212","#5A5A5A", "#242424", "#343434", "derive(-fx-focus-color, -40%)","#5A5A5A");

    private final String fontColor;
    private final String paneColor;
    private final String containerColor;
    private final String unFocusColor;
    private final String bgColor;
    private final String borderColor;
    private final String focusColor;
    private final String trackColor;


    JFXTheme(String fontColor, String paneColor, String containerColor, String unFocusColor, String bgColor, String borderColor, String focusColor, String trackColor)
    {
        this.fontColor = fontColor;
        this.paneColor = paneColor;
        this.containerColor = containerColor;
        this.unFocusColor = unFocusColor;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.focusColor = focusColor;
        this.trackColor = trackColor;
    }

    public String toString()
    {
        return String.format("-jfx-font-color: %s;" +
                        "-jfx-container-color: %s;" +
                        "-jfx-pane-color: %s;" +
                        "-jfx-un-focus-color: %s;" +
                        "-jfx-border-color: %s;" +
                        "-jfx-focus-border-color: %s;" +
                        "-jfx-track-color: %s;" +
                        "-jfx-background-color: %s;",
                this.fontColor, this.containerColor, this.paneColor, this.unFocusColor, this.borderColor, this.focusColor, this.trackColor, this.bgColor);
    }
}
