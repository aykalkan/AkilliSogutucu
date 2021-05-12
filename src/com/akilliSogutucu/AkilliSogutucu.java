package com.akilliSogutucu;

public class AkilliSogutucu {
    IEkran ekran;
    ITusTakimi tusTakimi;
    IAgArayuzu agArayuzu;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IKisilerRepository kisilerVeritabani;
    ISicaklikRepository sicaklikVeritabani;

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
        Kullanici kullanici;

        Thread run = new Thread(sicaklikAlgilayici);
        run.start();

        boolean cikisYapilsinMi = false;
        int secenek = 0;

        do {
            kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
            boolean kullaniciDogrulandiMi = kisilerVeritabani.kullaniciDogrula(kullanici);
            ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);

            if (kullaniciDogrulandiMi){
                secenek = ekran.kullaniciSecenekleri(tusTakimi);
                cikisYapilsinMi = kullaniciIslemleri(secenek);
            }
            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz? (E/H)");
                cikisYapilsinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("H");
            }
        }while (!cikisYapilsinMi);

        ekran.kullaniciCıkısEkrani();
        run.stop();
    }

    private boolean kullaniciIslemleri(int secenek){
        boolean cikisYapilsinMi = false;

        switch (secenek){
            case 0:
                cikisYapilsinMi = true;
                break;
            case 1:
                ekran.sicaklikGoruntule();
                break;
            case 2:
                ekran.sogutucuAc();
                break;
            case 3:
                ekran.sogutucuKapat();
                break;
        }

        return cikisYapilsinMi;
    }

}


