module com.example.calendar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
//    requires org.postgresql.jdbc;


    opens com.example.calendar to javafx.fxml;
    exports com.example.calendar;
}
