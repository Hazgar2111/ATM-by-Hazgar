package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class adminLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterPinButton;

    @FXML
    private Button cancelPinButton;

    @FXML
    private TextField loginText1;

    @FXML
    private PasswordField passwordText1;

    static String login;
    static String pass;
    ArrayList<admin> admins=new ArrayList<>();

    @FXML
    void initialize() {
        admins=Main.getAdminsMethod();
        login=admins.get(0).getLogin();
        pass=admins.get(0).getPassword();
        enterPinButton.setOnAction(event -> {
            try {

                if((loginText1.getText().trim().equals(admins.get(0).getLogin())&& passwordText1.getText().trim().equals(admins.get(0).getPassword()))
                ||(loginText1.getText().trim().equals(admins.get(1).getLogin())&& passwordText1.getText().trim().equals(admins.get(1).getPassword())))
                {

                    enterPinButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                    enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                }
                else{

                    enterPinButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("adminLoginInvalidData.fxml"));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                    enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                }
            } catch(Exception e) {
                e.printStackTrace();
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
