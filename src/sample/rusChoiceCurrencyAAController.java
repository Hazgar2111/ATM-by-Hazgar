package sample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class rusChoiceCurrencyAAController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button tengeButton;

    @FXML
    private Button usdButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button euroButton1;

        public void saverCurrency(String currency)
        {
            try{
                ObjectOutputStream outputStream=
                        new ObjectOutputStream(new FileOutputStream("currency.txt"));
                outputStream.writeObject(currency);
                outputStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        @FXML
        void initialize() {
            tengeButton.setOnAction(event -> {
                try {
                    saverCurrency("TENGE");
                    tengeButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("rusAvailableAmount.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            usdButton.setOnAction(event -> {
                try {
                    saverCurrency("USD");
                    usdButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("rusAvailableAmount.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            euroButton1.setOnAction(event -> {
                try {
                    saverCurrency("EURO");
                    euroButton1.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("rusAvailableAmount.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            cancelButton.setOnAction(event -> {
                try {
                    cancelButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("rusOption.fxml"));
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
