package com.example.aprian_pc.akonline.TabHerbal;

public class Barang {

    private String name;
    private int price;
    private int thumbnail;
    private String btnbeli;
    private String btndetail;
    private int jumlahpesanan;


    public Barang(String name, int price, int thumbnail, String btnbeli, String btndetail, int jumlahpesanan) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.btnbeli = btnbeli;
        this.btndetail = btndetail;
        this.jumlahpesanan = jumlahpesanan;
    }

    public String getBtn1() {
        return btnbeli;
    }

    public String getBtn2() {
        return btndetail;
    }

    public int getPesanan() {
        return jumlahpesanan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
