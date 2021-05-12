package com.akilliSogutucu;

public class AgArayuzu implements IAgArayuzu {
    ISicaklikRepository sicaklikVeritabani = new SicaklikRepositoryPostgreSql();

    @Override
    public int sicaklikOku() {
        return sicaklikVeritabani.sonSicaklikGetir();
    }
}
