package sample;

import java.awt.*;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class availableAmountController extends saverBalance implements Printable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkYesButton;

    @FXML
    private Button checkNoButton;

    private String balance;


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

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        String operationType="Available Amount ";
        //Десеарилизация баланса
        try{
            ObjectInputStream inputStream=
                    new ObjectInputStream(new FileInputStream("save.txt"));
            balance=(String)inputStream.readObject();
            inputStream.close();

        }catch (FileNotFoundException e){

        }catch (Exception e) {
            e.printStackTrace();
        }
        Check check=new Check(operationType,balance);
        System.out.println(check);

        String time="Time: "+check.getTime();
        String operationType1=check.getOperationType()+": "+check.getBalance();
        g.drawString("Check ",100,100);
        g.drawString(time,100,120);
        g.drawString(operationType1,100,140);

        return PAGE_EXISTS;
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

        return str;
    }
    @FXML
    void initialize() {
       String str1=getCurrency();
        System.out.println(str1);

        final int index=engController.getIndex();
        long balanceAA=Main.getCards().get(index).getBalance();
        ConvertorCurrency convertorCurrency=new ConvertorCurrency();

        System.out.println(balanceAA);
        if (str1.equals("EURO")) {

            double balanceEuro=convertorCurrency.convertor(440.6,balanceAA);
            try{
                ObjectOutputStream outputStream=
                        new ObjectOutputStream(new FileOutputStream("balanceAAinScreen.txt"));
                outputStream.writeObject(balanceEuro);
                outputStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            checkNoButton.setOnAction(event -> {
                try {
                    checkNoButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("aaInScreen.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            checkYesButton.setOnAction(event -> {

                try {
                    String str = Double.toString(balanceEuro);
                    saveBalance(str);

                    Check checkEuro=new Check("Available amount",balance,"Euro");
                    checkYesButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();


                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPrintable(this);
                    boolean ok = job.printDialog();
                    if (ok) {
                        try {
                            job.print();
                        } catch (PrinterException ex) {
                            /* The job did not successfully complete */
                        }
                    }
                    new PrintCheckCashGiverController();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //
                try {
                    FileWriter fstream1 = new FileWriter("save.txt");
                    BufferedWriter out1 = new BufferedWriter(fstream1);
                    out1.write("");
                    out1.close();
                } catch (Exception e) {
                    System.err.println("Error in file cleaning: " + e.getMessage());
                }
            });

        }
        if (str1.equals("USD")) {

            double balanceUsd=convertorCurrency.convertor(380,balanceAA);
            try{
                ObjectOutputStream outputStream=
                        new ObjectOutputStream(new FileOutputStream("balanceAAinScreen.txt"));
                outputStream.writeObject(balanceUsd);
                outputStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            checkNoButton.setOnAction(event -> {
                try {
                    checkNoButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("aaInScreen.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            checkYesButton.setOnAction(event -> {

                try {


                    String str = Double.toString(balanceUsd);
                    saveBalance(str);


                    checkYesButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();


                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPrintable(this);
                    boolean ok = job.printDialog();
                    if (ok) {
                        try {
                            job.print();
                        } catch (PrinterException ex) {
                            /* The job did not successfully complete */
                        }
                    }
                    new PrintCheckCashGiverController();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //
                try {
                    FileWriter fstream1 = new FileWriter("save.txt");
                    BufferedWriter out1 = new BufferedWriter(fstream1);
                    out1.write("");
                    out1.close();
                } catch (Exception e) {
                    System.err.println("Error in file cleaning: " + e.getMessage());
                }
            });

        }
        else if (str1.equals("TENGE")) {

            try{
                ObjectOutputStream outputStream=
                        new ObjectOutputStream(new FileOutputStream("balanceAAinScreen.txt"));
                outputStream.writeObject(balanceAA);
                outputStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            checkNoButton.setOnAction(event -> {
                try {
                    checkNoButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("aaInScreen.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            checkYesButton.setOnAction(event -> {

                try {
                    long balance = Main.getCards().get(index).getBalance();
                    String str = Long.toString(balance);
                    saveBalance(str);


                    checkYesButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("engOption.fxml"));
                    Stage cancelLanguage = new Stage();
                    cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                    cancelLanguage.setScene(new Scene(root, 960, 661)); // размеры нового окна
                    cancelLanguage.show();


                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPrintable(this);
                    boolean ok = job.printDialog();
                    if (ok) {
                        try {
                            job.print();
                        } catch (PrinterException ex) {
                            /* The job did not successfully complete */
                        }
                    }
                    new PrintCheckCashGiverController();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //
                try {
                    FileWriter fstream1 = new FileWriter("save.txt");
                    BufferedWriter out1 = new BufferedWriter(fstream1);
                    out1.write("");
                    out1.close();
                } catch (Exception e) {
                    System.err.println("Error in file cleaning: " + e.getMessage());
                }
            });

        }
    }
}
