package com.akilliSogutucu;

public class Ekran implements IEkran{

    @Override
    public Kullanici acilisMesajı() {
        System.out.println("Akıllı soğutucuya hoşgeldiniz");
        System.out.println("-----------------------------\n");

        return kullaniciGirisEkrani();
    }

    @Override
    public Kullanici kullaniciGirisEkrani() {
        System.out.println("Kullanıcı adını giriniz:");
        TusTakimi tusTakimi = new TusTakimi();
        String kullaniciAdi = tusTakimi.veriAl();

        System.out.println("Şifre giriniz:");
        String sifre = tusTakimi.veriAl();

        return new Kullanici.Builder(kullaniciAdi,sifre).build();
    }

    @Override
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi) {
        this.mesajYaz("");
        if(dogrulandiMi) this.mesajYaz("--- Hoşgeldiniz! ---");
        else this.mesajYaz("--- Kullanici sistemde kayitli değil!!! ---");
        this.mesajYaz("");
    }

    @Override
    public void kullaniciCıkısEkrani(Kullanici kullanici) {

    }

    @Override
    public int kullaniciSecenekleri() {

        return 0;
    }

    @Override
    public int hataliKullanici() {
        return 0;
    }

    @Override
    public void mesajYaz(String mesaj) {
        System.out.println(mesaj);
    }
}
