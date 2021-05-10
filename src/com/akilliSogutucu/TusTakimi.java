package com.akilliSogutucu;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi{

    @Override
    public String veriAl() {
        Scanner giris = new Scanner(System.in);
        String veri = giris.nextLine();
        return veri;
    }
}
