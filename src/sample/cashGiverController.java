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
import javafx.stage.Stage;

public class cashGiverController extends saverBalance{

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
    private Button button100k;

    @FXML
    private Button button50k;

    @FXML
    private Button button20k;

    @FXML
    private Button button5k;

    @FXML
    private Button button2k;

    @FXML
    private Button button10k;

    @FXML
    private Button buttonOtherAmount;

    @FXML
    private Button cancelButton2;

    public void cashLoading(Button button)
    {
        try {
            button.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("CheckPrintCashGiver.fxml"));
            Stage enterCardEng = new Stage();
            enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
            enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
            enterCardEng.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void notEnoughBalance(Button button)
    {
        try {
            button.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("notEnoughMoney.fxml"));
            Stage enterCardEng = new Stage();
            enterCardEng.setTitle("ATM CREATED BY <HAZGAR>");
            enterCardEng.setScene(new Scene(root, 960, 661)); // размеры нового окна
            enterCardEng.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public cashGiverController() {
    }



    @FXML
    void initialize() {
        final int index=engController.getIndex();
        System.out.println("index of cashGiver "+index);
        ArrayList<Card> cardInCash=Main.getCards();
        long newBalance100k=cardInCash.get(index).getBalance()-100000;
        long newBalance50k=cardInCash.get(index).getBalance()-50000;
        long newBalance20k=cardInCash.get(index).getBalance()-20000;
        long newBalance10k=cardInCash.get(index).getBalance()-10000;
        long newBalance5k=cardInCash.get(index).getBalance()-5000;
        long newBalance2k=cardInCash.get(index).getBalance()-2000;


        button100k.setOnAction(event -> {
            if(newBalance100k>=0) {
                saveBalance("100,000");
                //Новый баланс.
                cardInCash.get(index).setBalance(newBalance100k);
                Main.setCards(cardInCash);
                Main.saveCardsInServer(cardInCash.get(index), index);
                System.out.println("new Balance" + Main.getCards().get(index).getBalance());
                cashLoading(button100k);
            }
            else
            {
                notEnoughBalance(button100k);
            }
        });
        button50k.setOnAction(event -> {
            if(newBalance50k>=0) {
                //Новый баланс.
                saveBalance("50,000");
                cardInCash.get(index).setBalance(newBalance50k);
                Main.setCards(cardInCash);
                Main.saveCardsInServer(cardInCash.get(index), index);
                System.out.println("new Balance" + Main.getCards().get(index).getBalance());
                cashLoading(button100k);
            }
            else
            {
                notEnoughBalance(button50k);
            }
        });
        button20k.setOnAction(event -> {
            //Новый баланс.
            if (newBalance20k>=0)
            {


            saveBalance("20,000");
            cardInCash.get(index).setBalance(newBalance20k);
            Main.setCards(cardInCash);
            Main.saveCardsInServer(cardInCash.get(index), index);
            System.out.println("new Balance" + Main.getCards().get(index).getBalance());
            cashLoading(button100k);
            }
            else
            {
                notEnoughBalance(button20k);
            }
        });
        button10k.setOnAction(event -> {
            //Новый баланс.
            if (newBalance10k >= 0)
            {


            saveBalance("10,000");
            cardInCash.get(index).setBalance(newBalance10k);
            Main.setCards(cardInCash);
            Main.saveCardsInServer(cardInCash.get(index), index);
            System.out.println("new Balance" + Main.getCards().get(index).getBalance());
            cashLoading(button100k);
        }
            else
            {
                notEnoughBalance(button10k);
            }
        });
        button5k.setOnAction(event -> {
            //Новый баланс.
            if(newBalance5k>=0) {
                saveBalance("5000");
                cardInCash.get(index).setBalance(newBalance5k);
                Main.setCards(cardInCash);
                Main.saveCardsInServer(cardInCash.get(index), index);
                System.out.println("new Balance" + Main.getCards().get(index).getBalance());
                cashLoading(button100k);
            }
            else
            {
                notEnoughBalance(button5k);
            }
        });
        button2k.setOnAction(event -> {
            //Новый баланс.
            if(newBalance2k>=0) {
                saveBalance("2000");
                cardInCash.get(index).setBalance(newBalance2k);
                Main.setCards(cardInCash);
                Main.saveCardsInServer(cardInCash.get(index), index);
                System.out.println("new Balance" + Main.getCards().get(index).getBalance());
                cashLoading(button100k);
            }
            else
            {
                notEnoughBalance(button2k);
            }
        });

        buttonOtherAmount.setOnAction(event -> {
            try {
                buttonOtherAmount.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("OtherAmountInCashGiver.fxml"));
                Stage otherAmount = new Stage();
                otherAmount.setTitle("ATM CREATED BY <HAZGAR>");
                otherAmount.setScene(new Scene(root, 960, 661)); // размеры нового окна
                otherAmount.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        cancelButton2.setOnAction(event -> {
            try {
                cancelButton2.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
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
