package com.akilliSogutucu;

public interface IEkran {
    public void acilisMesajı();
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi);
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);
    public void kullaniciCıkısEkrani();
    public int kullaniciSecenekleri(ITusTakimi tusTakimi);
    public void mesajYaz(String mesaj);
    public void sicaklikGoruntule();
    public void sogutucuAc();
    public void sogutucuKapat();
}
