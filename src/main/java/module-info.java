module com.aldoivan10.jfxwindow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aldoivan10.jfxwindow to javafx.fxml;
    exports com.aldoivan10.jfxwindow;
}