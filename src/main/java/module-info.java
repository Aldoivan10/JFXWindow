module com.aldoivan10.jfxwindow {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens com.aldoivan10.jfxwindow to javafx.fxml;
    exports com.aldoivan10.jfxwindow;
    exports com.aldoivan10.jfxwindow_demo;
    opens com.aldoivan10.jfxwindow_demo to javafx.fxml;
}