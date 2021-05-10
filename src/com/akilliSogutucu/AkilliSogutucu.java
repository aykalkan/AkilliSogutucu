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
        Kullanici kullanici = ekran.acilisMesajı();



    }

    private int KullaniciDogrula (Kullanici kullanici) {
        boolean cikisYapilsinMi = true;
        int secenek = 0;

        do {
            boolean kullaniciDogrulandiMi = veritabani.kullaniciDogrula(kullanici);
            ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);
            if (kullaniciDogrulandiMi)
                secenek = ekran.kullaniciSecenekleri();
            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz? (E/H)");
                boolean tekrarDenemeYapilsinMi = tusTakimi.veriAl().equalsIgnoreCase("E");
                if (tekrarDenemeYapilsinMi)
                    kullanici = ekran.kullaniciGirisEkrani();
                else {
                    ekran.mesajYaz("--- Hoşçakalın ---");
                    cikisYapilsinMi = false;
                }
            }
        }while (cikisYapilsinMi);

        return secenek;
    }
}


