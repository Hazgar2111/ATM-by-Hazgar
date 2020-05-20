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

import javax.swing.*;

public class PrintCheckCashGiverController  implements Printable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkYesButton;

    @FXML
    private Button checkNoButton;



    public PrintCheckCashGiverController() {
    }


    private String balance;

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        String operationType="Cash Advance";
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

           String time="Time: "+check.getTime();
           String operationType1=check.getOperationType()+": "+check.getBalance();
           g.drawString("Check ",100,100);
           g.drawString(time,100,120);
           g.drawString(operationType1,100,140);


        return PAGE_EXISTS;
    }

    @FXML
    void initialize() {

        checkYesButton.setOnAction(event -> {
            try {
                checkYesButton.getScene().getWindow().hide();
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
            } catch(Exception e) {
                e.printStackTrace();
            }

            //ОЧИСТКА ДОКУМЕНТА
            try {
                FileWriter fstream1 = new FileWriter("save.txt");
                BufferedWriter out1 = new BufferedWriter(fstream1);
                out1.write("");
                out1.close();
            } catch (Exception e)
            {System.err.println("Error in file cleaning: " + e.getMessage());}
            //ЗАВЕРШЕНИЕ ПРОГРАММЫ
            System.exit(0);
        });
        
        checkNoButton.setOnAction(event -> {
            try {
                checkNoButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("cashLoading.fxml"));
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
