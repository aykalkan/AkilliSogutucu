package com.akilliSogutucu;

public class AgArayuzu implements IAgArayuzu {
    ISicaklikRepository sicaklikVeritabani = new SicaklikRepositoryPostgreSql();
    IEyleyici eyleyici = new Eyleyici();

    @Override
    public int sicaklikOku() {
        return sicaklikVeritabani.sonSicaklikGetir();
    }

    @Override
    public void sogutucuAc() {
        eyleyici.sogutucuAc();
    }

    @Override
    public void sogutucuKapat() {
        eyleyici.sogutucuKapat();
    }
}
