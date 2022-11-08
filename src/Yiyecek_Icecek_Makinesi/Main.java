package Yiyecek_Icecek_Makinesi;


public class Main {
    

    public static void main(String[] args) {
        double accountBalance = 1;

        Urun urun = new Urun();
        Options options = new Options();

        urun.setPrice(options.select(urun));
        accountBalance = options.balance(urun.getPrice(), accountBalance, urun);

    }
}
