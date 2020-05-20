package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Check {

    private String time= LocalDateTime.now() .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private String operationType;
    private String balance;
    private String currency;

    public Check(String operationType, String balance, String currency) {
        this.operationType = operationType;
        this.balance = balance;
        this.currency = currency;
    }

    public String getTime() {
        return time;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Check{" +
                "time='" + time +"\n" +
                ", operationType='" + operationType + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public Check(String operationType, String balance) {
        this.operationType = operationType;
        this.balance = balance;
    }
}
