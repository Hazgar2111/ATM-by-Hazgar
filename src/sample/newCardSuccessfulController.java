package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class newCardSuccessfulController {

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
                Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

    }
}

