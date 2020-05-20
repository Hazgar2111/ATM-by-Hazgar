package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String operationType;
    private ArrayList<Card> cards;
    private static final long serialVersionUID=9180844317717290831L;
    private int index;
    private Card card;
    private int id;
    private ArrayList<admin> admins;
    String s="";

    public ArrayList<admin> getAdmins() {
        return admins;
    }

    public Request(String operationType, ArrayList<admin> admins, String s) {
        this.operationType = operationType;
        this.s=s;
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "Request{" +
                "operationType='" + operationType + '\'' +
                ", cards=" + cards +
                ", index=" + index +
                ", card=" + card +
                ", id=" + id +
                '}';
    }

    public Request(String operationType, Card card, int index) {
        this.operationType = operationType;
        this.card = card;
        this.index = index;
    }



    public Request() {
    }

    public Request(String operationType, ArrayList<Card> cards) {
        this.operationType = operationType;
        this.cards = cards;
    }

    public Request(String operationType,int id) {
        this.operationType = operationType;
        this.id=id;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }



}
