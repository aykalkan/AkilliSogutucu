package com.akilliSogutucu;

public interface IEkran {
    public void acilisMesajı();
    public Kullanici kullaniciGirisEkrani(TusTakimi tusTakimi);
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);
    public void kullaniciCıkısEkrani(Kullanici kullanici);
    public int kullaniciSecenekleri(TusTakimi tusTakimi);
    public int hataliKullanici();
    public void mesajYaz(String mesaj);
}
