package comlucifer017.github.absdelivery;

import java.io.Serializable;

public class Order implements Serializable {

    private String menu;
    private String jumlah;
    private int harga;

    public Order(String menu, String jumlah, int harga) {
        this.menu = menu;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getMenu() {
        return menu;
    }

    public String getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }
}