package com.akilliSogutucu;

import javafx.util.Builder;

public class KullaniciHesabi {

    private String isim;
    private String sifre;
    private String yas;

    public KullaniciHesabi (Builder builder){
        this.isim = builder.isim;
        this.sifre = builder.sifre;
        this.yas = builder.yas;
    }

    @Override
    public String toString() {
        return "KullaniciHesabi{" +
                "isim=" + isim +
                '}';
    }

    public static class Builder  {

        private String isim;
        private String sifre;
        private String yas;

        public Builder(String isim, String sifre){
            this.isim = isim;
            this.sifre = sifre;
        }

        public void setYas(String yas) {
            this.yas = yas;
        }

        public KullaniciHesabi build(){
            return new KullaniciHesabi(this);
        }
    }
}
