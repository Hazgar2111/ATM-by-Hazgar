package sample;

public class ConvertorCurrency {
    //Для реализации полиморфизма
    public double convertor (int a,long balance)
    {
        double total=0;
        total=balance/a;

        return  total;
    }
    public double convertor (double a,long balance)
    {
        double total=0;
        total=balance/a;

        return  total;
    }
}
