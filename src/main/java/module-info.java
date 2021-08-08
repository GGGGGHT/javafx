module com.ggggght.javafx {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens com.ggggght.javafx to javafx.fxml;
  exports com.ggggght.javafx;
  exports com.ggggght.javafx.alertBox;
  exports com.ggggght.javafx.layout;
  exports com.ggggght.javafx.tree;
  exports com.ggggght.javafx.table;
  exports com.ggggght.javafx.css;
  exports com.ggggght.javafx.listen;
}