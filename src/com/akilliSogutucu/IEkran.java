package com.akilliSogutucu;

public interface IEkran {
    public Kullanici acilisMesajı();
    public Kullanici kullaniciGirisEkrani();
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);
    public void kullaniciCıkısEkrani(Kullanici kullanici);
    public int kullaniciSecenekleri();
    public int hataliKullanici();
    public void mesajYaz(String mesaj);
}
