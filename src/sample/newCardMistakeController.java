package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class newCardMistakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton1;

    @FXML
    void initialize() {
        cancelButton1.setOnAction(event -> {
            try {
                cancelButton1.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("newCard.fxml"));
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

