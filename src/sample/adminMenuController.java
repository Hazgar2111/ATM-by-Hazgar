package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminMenuController implements methodForAdmin{


    @Override
    public void addCard(Card card)
    {
        Main.saveCardsInServerWhole(card,0);
    }

    @Override
    public void deleteCard( int id)
    {
        Main.deleteCard(id);
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {


        addButton.setOnAction(event -> {
            try {
                addButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("newCard.fxml"));
                Stage enterCardEng = new Stage();
                enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                enterCardEng.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        deleteButton.setOnAction(event -> {
            try {
                deleteButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("adminDeleteCard.fxml"));
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

