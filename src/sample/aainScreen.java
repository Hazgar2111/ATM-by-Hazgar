package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class aainScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text textFieldBalance;

    @FXML
    private Text textCurrency;

    @FXML
    private Button cancelAAButton;

    public double getBalance()
    {
        double balance=0;
        try{
            ObjectInputStream inputStream=
                    new ObjectInputStream(new FileInputStream("balanceAAinScreen.txt"));
            balance=(Double) inputStream.readObject();
            inputStream.close();

        }catch (FileNotFoundException e){

        }catch (Exception e) {
            e.printStackTrace();
        }
        //ОЧИСТКА ДОКУМЕНТА
        try {
            FileWriter fstream1 = new FileWriter("balanceAAinScreen.txt");
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
        return balance;
    }
    public String getCurrency()
    {
        String str="";
        try{
            ObjectInputStream inputStream=
                    new ObjectInputStream(new FileInputStream("currency.txt"));
            str=(String)inputStream.readObject();
            inputStream.close();

        }catch (FileNotFoundException e){

        }catch (Exception e) {
            e.printStackTrace();
        }
        //ОЧИСТКА ДОКУМЕНТА
        try {
            FileWriter fstream1 = new FileWriter("currency.txt");
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
        return str;
    }
    @FXML
    void initialize() {
        String currency=getCurrency();
        if(currency.equals("TENGE"))
        {
            int index=engController.getIndex();
            long balance=Main.getCards().get(index).getBalance();
            String str=Long.toString(balance);
            textFieldBalance.setText(str);
            textCurrency.setText(currency);
        }
        else if(currency.equals("USD"))
        {
            double doubleBalance=getBalance();
            String str1=Double.toString(doubleBalance);
            textFieldBalance.setText(str1);
            textCurrency.setText(currency);
        }
        else if(currency.equals("EURO"))
        {
            double doubleBalance=getBalance();
            String str1=Double.toString(doubleBalance);
            textFieldBalance.setText(str1);
            textCurrency.setText(currency);
        }


        cancelAAButton.setOnAction(event -> {
            try {
                cancelAAButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
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
