module com.ggggght.javafx {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.ggggght.javafx to javafx.fxml;
  exports com.ggggght.javafx;
  exports com.ggggght.javafx.alertBox;
}