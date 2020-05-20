package sample;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import   javafx.scene.Parent;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button engButton;

    @FXML
    private Button rusButton;


    @FXML
    private Button buttonAdmin;
    public Controller() {
    }

    @FXML
    void initialize() {
        buttonAdmin.setOnAction(event -> {
            try {
                buttonAdmin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
                Stage enterCardEng = new Stage();
                enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                enterCardEng.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        engButton.setOnAction(event -> {
            try {
                engButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("englishCard.fxml"));
                Stage enterCardEng = new Stage();
                enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                enterCardEng.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        rusButton.setOnAction(event -> {
            try {
                rusButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("rusCardMenu.fxml"));
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

