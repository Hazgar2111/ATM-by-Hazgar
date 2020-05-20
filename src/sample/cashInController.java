package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class cashInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textAmount;

    @FXML
    private Button enterPinButton;

    @FXML
    private Button cancelPinButton;

    @FXML
    void initialize() {
        enterPinButton.setOnAction(event -> {
            try {
                final int index=engController.getIndex();

                ArrayList<Card> cards=Main.getCards();
                String s=textAmount.getText();
                int a=Integer.parseInt(s);
                long newBalance=cards.get(index).getBalance()+a;
                cards.get(index).setBalance(newBalance);
                Main.setCards(cards);
                Main.saveCardsInServer(cards.get(index),index);



                enterPinButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("cashInSuccessful.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("ATM created by Hazgar");
                primaryStage.setScene(new Scene(root, 960, 661));
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        cancelPinButton.setOnAction(event -> {
            try {
                cancelPinButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("ATM created by Hazgar");
                primaryStage.setScene(new Scene(root, 960, 661));
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}

