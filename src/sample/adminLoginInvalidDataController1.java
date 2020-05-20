package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminLoginInvalidDataController1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button tryAgainButton;

    @FXML
    void initialize() {
        tryAgainButton.setOnAction(event -> {
            try {
                tryAgainButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("ATM created by Hazgar");
                primaryStage.setScene(new Scene(root, 960, 661));
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
