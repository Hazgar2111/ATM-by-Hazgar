package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class adminDeleteCardController extends adminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField idText;

    static String s;

    @FXML
    void initialize() {


        enterButton.setOnAction(event -> {
            try {
                s=idText.getText();
                enterButton.getScene().getWindow().hide();
                int id=Integer.parseInt(s);
                deleteCard(id);
                Parent root = FXMLLoader.load(getClass().getResource("newCardSuccessful.fxml"));
                Stage enterCardEng = new Stage();
                enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                enterCardEng.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
        cancelButton.setOnAction(event -> {
            try {
                cancelButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                Stage enterCardEng = new Stage();
                enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                enterCardEng.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

    }
}

