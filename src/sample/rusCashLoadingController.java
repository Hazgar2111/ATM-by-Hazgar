package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class rusCashLoadingController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {
        cancelButton.setOnAction(event -> {
            try {
                cancelButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage start = new Stage();
                start.setTitle("СОЗДАНО ХАЗГАРОМ");
                start.setScene(new Scene(root, 960, 661));
                start.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}