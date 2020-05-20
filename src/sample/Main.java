package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {

    private static Socket socket;
    private static ObjectOutputStream outStream;
    private static  ObjectInputStream inStream;
    private static ArrayList<Card> cards = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ATM created by Hazgar");
        primaryStage.setScene(new Scene(root, 960, 661));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        connect();
        cards=getCardsMethod();

        launch(args);

    }

    private static void connect(){
        try {

            socket = new Socket("127.0.0.1", 2111);
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Main.cards = cards;
    }

    public static void saveCardsInServer(Card card,int index)
    {
        try {
            Request r = new Request("NEW_CARDS", null);
            outStream.writeObject(r);
            Request r1 = new Request("NEW_CARDS", card,index);
            System.out.println("proverka"+r1);
            outStream.writeObject(r1);

        }catch ( IOException a)
        {
            a.printStackTrace();
        }
    }
    public static void deleteCard(int id)
    {
        try {
            Request r = new Request("DELETE_CARD", null);
            outStream.writeObject(r);
            Request r1 = new Request("DELETE_CARD", id);
            System.out.println("proverka"+r1);
            outStream.writeObject(r1);

        }catch ( IOException a)
        {
            a.printStackTrace();
        }
    }
    public static void saveCardsInServerWhole(Card card,int index)
    {
        try {
            Request r = new Request("WHOLE_CARDS", null);
            outStream.writeObject(r);
            Request r1 = new Request("WHOLE_CARDS", card,index);
            System.out.println("proverka"+r1);
            outStream.writeObject(r1);

        }catch ( IOException a)
        {
            a.printStackTrace();
        }
    }

    public static ArrayList<Card> getCardsMethod(){

        ArrayList<Card> cards = new ArrayList<>();
        try {
            Request r = new Request("LIST_CARDS", null);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                cards = request.getCards();
                for (int i = 0; i <cards.size() ; i++) {
                    System.out.println(cards.get(i));
                }
            }

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch ( IOException a)
        {
            a.printStackTrace();
        }

        return cards;
    }
    public static ArrayList<admin> getAdminsMethod(){

        ArrayList<admin> admins = new ArrayList<>();
        try {
            Request r = new Request("LIST_ADMINS", null,null);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                admins = request.getAdmins();
                for (int i = 0; i <cards.size() ; i++) {
                    System.out.println(cards.get(i));
                }
            }

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch ( IOException a)
        {
            a.printStackTrace();
        }

        return admins;
    }

}
