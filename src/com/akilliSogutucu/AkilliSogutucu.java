package com.akilliSogutucu;

public class AkilliSogutucu {
    Ekran ekran;
    TusTakimi tusTakimi;
    KisilerRepositoryPostgreSql veritabani;

    AkilliSogutucu(){
        ekran = new Ekran();
        tusTakimi = new TusTakimi();
        veritabani = new KisilerRepositoryPostgreSql();
    }

    public void basla(){
        ekran.acilisMesajı();
        Kullanici kullanici = ekran.kullaniciGirisEkrani(tusTakimi);

        boolean cikisYapilsinMi = true;
        int secenek = 0;

        do {
            boolean kullaniciDogrulandiMi = veritabani.kullaniciDogrula(kullanici);
            ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);
            if (kullaniciDogrulandiMi)
                secenek = ekran.kullaniciSecenekleri(tusTakimi);
            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz? (E/H)");
                boolean tekrarDenemeYapilsinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("E");
                if (tekrarDenemeYapilsinMi)
                    kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
                else {
                    ekran.mesajYaz("--- Hoşçakalın ---");
                    cikisYapilsinMi = false;
                }
            }
        }while (cikisYapilsinMi);


    }

}


