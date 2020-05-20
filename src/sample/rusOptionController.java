package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class rusOptionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cashButton;

    @FXML
    private Button aAButton;

    @FXML
    private Button eServiceshButton;

    @FXML
    private Button pTButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button cashInButton;

    @FXML
    void initialize() {

        cashInButton.setOnAction(event -> {
            try {
                cashInButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("rusCashIn.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cashButton.setOnAction(event -> {
            try {
                cashButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("rusCashGiver.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        aAButton.setOnAction(event -> {
            try {
                aAButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("rusChoiceCurrencyAA.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cancelButton.setOnAction(event -> {

            try {
                cancelButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}