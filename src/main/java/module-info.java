module com.example.todolistjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.julius.todolistjava to javafx.fxml;
    exports com.julius.todolistjava;
}