package com.akilliSogutucu;
import java.util.List;

public interface IKisilerRepository {
    public Kullanici ara(int id);
    public boolean kullaniciDogrula(Kullanici kullanici);
    public List<Kullanici> tumKullanicilar();
    public void kaydet(Kullanici kullanici);
    public void sil(int id);
    public void degistir(Kullanici kullanici);
}
