package sample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

public class OtherAmountInCashGiverController extends saverBalance{

    @Override
    public void saveBalance(String balance)
    {
        try{
            ObjectOutputStream outputStream=
                    new ObjectOutputStream(new FileOutputStream("save.txt"));
            outputStream.writeObject(balance);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelOtherAmountButton;

    @FXML
    private Button enterOtherAmountButton;

    @FXML
    private TextField textAmount;

    public OtherAmountInCashGiverController() {
    }



    @FXML
    void initialize() {

        enterOtherAmountButton.setOnAction(event -> {
            //Новый баланс.
            String amount=textAmount.getText();
            long a=Long.parseLong(amount);
            if(a%1000!=0)
            {

                try {
                    enterOtherAmountButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("cashGiverOtherAmountInvalidnumber.fxml"));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                    enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                ArrayList<Card> cardInOtherAmount = Main.getCards();
                final int index = engController.getIndex();
                long newBalanceOther = cardInOtherAmount.get(index).getBalance() - a;
                if (newBalanceOther >= 0) {
                    saveBalance(amount);


                    cardInOtherAmount.get(index).setBalance(newBalanceOther);
                    Main.setCards(cardInOtherAmount);
                    Main.saveCardsInServer(cardInOtherAmount.get(index), index);
                    System.out.println("new Balance" + Main.getCards().get(index).getBalance());
                    try {
                        enterOtherAmountButton.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("CheckPrintCashGiver.fxml"));
                        Stage enterCardEng = new Stage();
                        enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                        enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                        enterCardEng.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else
                {
                    try {
                        enterOtherAmountButton.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("notEnoughMoney.fxml"));
                        Stage enterCardEng = new Stage();
                        enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
                        enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
                        enterCardEng.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        cancelOtherAmountButton.setOnAction(event -> {

            try {
                cancelOtherAmountButton.getScene().getWindow().hide();
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
