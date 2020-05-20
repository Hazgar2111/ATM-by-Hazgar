package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class pinEngController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField Pin;

    @FXML
    private Button enterPinButton;

    @FXML
    private Button cancelPinButton;

    public pinEngController() {
    }
    static ArrayList<Card> cards1 = Main.getCards();

    @FXML
    void initialize() {


        final int index=engController.getIndex();
        System.out.println("index of pin "+index);

        enterPinButton.setOnAction(event -> {
            try {
                String pin=Pin.getText().trim();
                if ( cards1.get(index).getPin().equals(pin)) {
                    enterPinButton.getScene().getWindow().hide();
                    Parent root1 = FXMLLoader.load((getClass().getResource("engOption.fxml")));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                    enterCardEng.setScene(new Scene(root1, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                }
                else
                {
                    enterPinButton.getScene().getWindow().hide();
                    Parent root1 = FXMLLoader.load((getClass().getResource("notFoundPin.fxml")));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                    enterCardEng.setScene(new Scene(root1, 960, 661)); // размеры нового окна
                    enterCardEng.show();

                }
            } catch(IOException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException a)
            {
                a.printStackTrace();
            }
        });

        cancelPinButton.setOnAction(event -> {

            try {
                cancelPinButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
