package Yiyecek_Icecek_Makinesi;

import java.util.Scanner;

/*
Urun urun = new Urun();

1) Kullanıcı ürünleri göstermeliyiz. ----> Urun clasın da bir obj. toString()
2) Scanner --> Scanner clasından bir obj create ediniz.
3) Loop --> Do-While Loop --> kullanıcı 1-7 rakamları arasında bir seçim yapmalı ve eğer girmiş olduğu rakam
1 den küçük ve ya 7 den büyük ise döngü devam etmeli ve kullanıcı 1-7 arasında bir seçim yapmaya force edilmeli.
4) 0 a basarak ta menuden cıkabilmeli. --> Yine Bekleriz... Yazısını konsola yazdıralım....
5) Kullanıcıdan productNum (1-7 arasında rakam {Kullanıcı 1 rakamı seçerse, Kraker, 2 rakamını seçerse cips etc.... }) --> switch-case yapısı kurmalıyım...
6) switch benden ProductNum ve alınan bu productNum a göre ilgili ürünün price ı alınmalı. urun.getKraker(), urun.getCips(), urun.getCay(), getCocaCola() etc....
(price set edebilmek için ben price ın setPrice() metodunu kullanmalıyım...)
7) return olarak bana price dönmeli. return getPrice() (double)

 */
public class Options {

    public double select(Urun urun) {
        System.out.println(urun.toString());
        Scanner scanner = new Scanner(System.in);


        do {
            int select;
            System.out.println("Lutfen seciminizi yapiniz ya da cikis icin 0 basiniz: \n");
            System.out.println(urun);
            urun.setProductNum(scanner.nextInt());

            if (urun.getProductNum() < 0 || urun.getProductNum() > 7) {
                System.out.println("lutfen belirtilen aralikta bir rakam giriniz ");

            }

        } while (urun.getProductNum() < 0 || urun.getProductNum() > 7);


        switch (urun.getProductNum()) {
            case 0:
                System.out.println("yine bekleriz ...");
                break;
            case 1:
                urun.setPrice(urun.getKraker());
                break;
            case 2:
                urun.setPrice(urun.getCips());
                break;
            case 3:
                urun.setPrice(urun.getCocaCola());
                break;
            case 4:
                urun.setPrice(urun.getFanta());
                break;
            case 5:
                urun.setPrice(urun.getSu());
                break;
            case 6:
                urun.setPrice(urun.getCay());
                break;
            case 7:
                urun.setPrice(urun.getFiltreKahve());
                break;
        }
        return urun.getPrice();
    }

    public double balance(double price, double accountBalance, Urun urun) {
        double fonlama;
        while (accountBalance < price) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Yeterli bakiyeniz bulunmamamktadir... Ekleme yapmak istiyor musunuz (Y/N)");
            char confirm = scanner.next().toLowerCase().charAt(0);
            if (confirm == 'n') {
                System.out.println("Mevcut Bakiyeniz: " + accountBalance);
                System.out.println("Yine Bekleriz...");
                break;

            } else {
                System.out.println("Ne kadar ekleme yapmak istiyorsunuz?");
                fonlama = scanner.nextDouble();
                accountBalance = accountBalance + fonlama;
                System.out.println("Yeni bakiyeniz: " + accountBalance);
                price = select(urun);
            }
        }

        return accountBalance;
    }

}
