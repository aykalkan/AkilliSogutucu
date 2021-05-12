package com.akilliSogutucu;

public class AkilliSogutucu {
    IEkran ekran;
    ITusTakimi tusTakimi;
    IAgArayuzu agArayuzu;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IKisilerRepository kisilerVeritabani;
    SicaklikRepositoryPostgreSql sicaklikVeritabani;

    AkilliSogutucu(){
        ekran = new Ekran();
        tusTakimi = new TusTakimi();
        agArayuzu = new AgArayuzu();
        kisilerVeritabani = new KisilerRepositoryPostgreSql();
        sicaklikVeritabani = new SicaklikRepositoryPostgreSql();
        sicaklikAlgilayici = new SicaklikAlgilayici();

        sicaklikAlgilayici.attach(sicaklikVeritabani);

    }

    public void basla(){
        ekran.acilisMesajı();
        Kullanici kullanici = ekran.kullaniciGirisEkrani(tusTakimi);

        new Thread(sicaklikAlgilayici).start();
        boolean cikisYapilsinMi = false;
        int secenek = 0;

        do {

            boolean kullaniciDogrulandiMi = kisilerVeritabani.kullaniciDogrula(kullanici);
            ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);
            if (kullaniciDogrulandiMi)
                secenek = ekran.kullaniciSecenekleri(tusTakimi);

            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz? (E/H)");
                boolean tekrarDenemeYapilsinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("E");
                if (tekrarDenemeYapilsinMi)
                    kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
                else {
                    ekran.kullaniciCıkısEkrani();;
                    cikisYapilsinMi = true;
                }
            }
        }while (!cikisYapilsinMi);


    }

    private void kullaniciIslemleri(int secenek){
        switch (secenek){
            case 0:
                ekran.kullaniciCıkısEkrani();
                break;
            case 1:
                ekran.sicaklikGoruntule();
                break;
            case 2:
                ekran.sogutucuAc();
                break;
            case 3:
                ekran.sicaklikGoruntule();
                break;
        }
    }

}


