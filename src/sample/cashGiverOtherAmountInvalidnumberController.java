package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class cashGiverOtherAmountInvalidnumberController {

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
                Parent root = FXMLLoader.load(getClass().getResource("OtherAmountInCashGiver.fxml"));
                Stage otherAmount = new Stage();
                otherAmount.setTitle("ATM CREATED BY <HAZGAR>");
                otherAmount.setScene(new Scene(root, 960, 661)); // размеры нового окна
                otherAmount.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

    }
}
