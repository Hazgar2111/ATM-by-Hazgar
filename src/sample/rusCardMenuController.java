package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class rusCardMenuController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField cardNumber;

    @FXML
    private Button enterCardButton;

    @FXML
    private Button cancelCardButton;

    public rusCardMenuController() {

    }

    ArrayList<Card> cards1 = new ArrayList<>();
    static int index; //для получения индекса для карты и пин кода

    public void setIndex(int index) {
        this.index = index;
    }

    public static int getIndex() {
        return index;
    }

    public int getIndexMethod(ArrayList<Card> cards)
    {

        int index=0;
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(i).getNumber1().equals(cardNumber.getText()))
            {
                index=i;
                System.out.println("Index of card "+index);

            }
        }
        return index;
    }




    @FXML
    void initialize() {

        cards1=Main.getCards();

        enterCardButton.setOnAction(event -> {
            String cardNumber1=cardNumber.getText().trim();
            setIndex(getIndexMethod(cards1));
            try {
                if (cards1.get(index).getNumber1().equals(cardNumber1)) {
                    enterCardButton.getScene().getWindow().hide();
                    Parent root1 = FXMLLoader.load((getClass().getResource("rusPinMenu.fxml")));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("СОЗДАНО ХАЗГАРОМ>");
                    enterCardEng.setScene(new Scene(root1, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                } else {
                    enterCardButton.getScene().getWindow().hide();
                    Parent root1 = FXMLLoader.load((getClass().getResource("rusCardNotFound.fxml")));
                    Stage enterCardEng = new Stage();
                    enterCardEng.setTitle("СОЗДАНО ХАЗГАРОМ>");
                    enterCardEng.setScene(new Scene(root1, 960, 661)); // размеры нового окна
                    enterCardEng.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        cancelCardButton.setOnAction(event -> {
            try {
                cancelCardButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
