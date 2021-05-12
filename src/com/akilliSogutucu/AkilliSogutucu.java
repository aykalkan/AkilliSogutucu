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

        kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
        boolean kullaniciDogrulandiMi = kisilerVeritabani.kullaniciDogrula(kullanici);
        ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulandiMi);
        do {



            if (kullaniciDogrulandiMi){
                secenek = ekran.kullaniciSecenekleri(tusTakimi);
                cikisYapilsinMi = kullaniciIslemleri(secenek);
            }
            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz? (E/H)");
                boolean tekrarDenensinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("H");
                if (tekrarDenensinMi)
                    kullanici = ekran.kullaniciGirisEkrani(tusTakimi);
                else
                    cikisYapilsinMi = true;
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
                ekran.sicaklikGoruntule(agArayuzu);
                break;
            case 2:
                ekran.sogutucuAc(agArayuzu);
                break;
            case 3:
                ekran.sogutucuKapat(agArayuzu);
                break;
        }

        return cikisYapilsinMi;
    }

}


