package com.akilliSogutucu;

public class Ekran implements IEkran {

    @Override
    public void acilisMesajı() {
        System.out.println("Akıllı soğutucuya hoşgeldiniz");
        System.out.println("-----------------------------\n");
    }

    @Override
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi) {
        System.out.println("Kullanıcı adını giriniz:");
        String kullaniciAdi = tusTakimi.stringVeriAl();

        System.out.println("Şifre giriniz:");
        String sifre = tusTakimi.stringVeriAl();

        return new Kullanici.Builder(kullaniciAdi, sifre).build();
    }

    @Override
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi) {
        this.mesajYaz("");
        if (dogrulandiMi) this.mesajYaz("--- Hoşgeldiniz! ---");
        else this.mesajYaz("--- Kullanici sistemde kayitli değil!!! ---");
        this.mesajYaz("");
    }

    @Override
    public void kullaniciCıkısEkrani() {
        this.mesajYaz("--- Hoşçakalın, yine bekleriz ---");
    }

    @Override
    public int kullaniciSecenekleri(ITusTakimi tusTakimi) {
        boolean secenekHataliMi = false;
        int secenek;

        do {
            this.mesajYaz("--- Kullanıcı Seçenekleri ---");
            this.mesajYaz("1 - Sıcaklığı görüntüle");
            this.mesajYaz("2 - Soğutucuyu aç");
            this.mesajYaz("3 - Soğutucuyu kapat");
            this.mesajYaz("0 - Çıkış");

            secenek = tusTakimi.intVeriAl();

            if (secenek < 0 || secenek > 3) {
                this.mesajYaz("\nHATALI BİR SEÇENEK GİRDİNİZ");
                this.mesajYaz("Lütfen aşağıdaki seçeneklerden birini giriniz:");
                secenekHataliMi = true;
            }
        } while (secenekHataliMi);

        return secenek;
    }

    @Override
    public void mesajYaz(String mesaj) {
        System.out.println(mesaj);
    }

    @Override
    public void sicaklikGoruntule() {

    }

    @Override
    public void sogutucuAc() {

    }

    @Override
    public void sogutucuKapat() {

    }
}
