module org.example.lab_worklab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab_worklab2 to javafx.fxml;
    exports org.example.lab_worklab2;
}