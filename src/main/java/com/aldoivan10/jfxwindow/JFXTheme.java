package com.aldoivan10.jfxwindow;

public enum JFXTheme
{
    LIGHT("#333333","#FAFAFA", "WHITE","#4d4d4d"),
    DARK("WHITE","#303030", "#424242","#BDBDBD");

    private final String fontColor;
    private final String paneColor;
    private final String containerColor;
    private final String unFocusColor;

    JFXTheme(String fontColor, String paneColor, String containerColor, String unFocusColor)
    {
        this.fontColor = fontColor;
        this.paneColor = paneColor;
        this.containerColor = containerColor;
        this.unFocusColor = unFocusColor;
    }

    public String toString()
    {
        return String.format("-jfx-font-color: %s; -jfx-container-color: %s; -jfx-pane-color: %s; -fx-un-focus-color: %s;",
                this.fontColor, this.containerColor, this.paneColor, this.unFocusColor);
    }
}
