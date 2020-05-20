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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class newCardControllerEng extends adminMenuController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField textNumber;

    @FXML
    private TextField textPin;

    @FXML
    private TextField textName;

    @FXML
    private TextField textSurname;

    @FXML
    private Button enterButton;


    static String number;
    static String pin;
    static String nameHolder;
    static String surnameHolder;
    static String validity;
    long balance;
    static ArrayList<Card> cards = new ArrayList<>();
    @FXML
    void initialize() {


        cards=Main.getCards();
        enterButton.setOnAction(event -> {
            try {
                if((!textNumber.getText().trim().isEmpty())
                        &&(!textPin.getText().trim().isEmpty())
                        &&(!textName.getText().trim().isEmpty())
                        &&(!textSurname.getText().trim().isEmpty())) {
                    number = textNumber.getText();
                    pin = textPin.getText();
                    nameHolder = textName.getText();
                    surnameHolder = textSurname.getText();
                    validity = getCurrentLocalDateTimeStamp();
                    balance = 0;
                    int proverka=0;
                    for (int i = 0; i < cards.size(); i++)
                    {
                        if(number.equals(cards.get(i).getNumber1()))
                        {
                            proverka=1;
                        }
                    }
                    if(proverka==0)
                    {
                        Card card=new Card(number,pin,nameHolder,surnameHolder,validity,balance);

                        //ИСПОЛЬЗОВАННИЕ НАСЛЕДОВАНИЯ
                        addCard(card);

                        enterButton.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("newCardSuccessful.fxml"));
                        Stage cancelLanguage = new Stage();
                        cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                        cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                        cancelLanguage.show();
                    }
                    else {
                        System.out.println("pizda proval");
                    }
                }
                else
                {
                    enterButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("newCardMistake.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        cancelButton.setOnAction(event -> {
            try {
                System.out.println(getCurrentLocalDateTimeStamp());
                cancelButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                Stage cancelLanguage = new Stage();
                cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                cancelLanguage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

    }
    public String getCurrentLocalDateTimeStamp()
    {
        String s=LocalDateTime.now() .format(DateTimeFormatter.ofPattern("yyyy"));
        String s1=LocalDateTime.now() .format(DateTimeFormatter.ofPattern("MM"));
        int a=Integer.parseInt(s)+3;
        String str=s1+"/"+a;
        return str;
    }
}
