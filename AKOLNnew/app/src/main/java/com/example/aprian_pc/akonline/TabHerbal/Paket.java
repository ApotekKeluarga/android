package com.example.aprian_pc.akonline.TabHerbal;

public class Paket {
    private String name;
    private int price;
    private int thumbnail;
    private String btnbeli;
    private String btndetail;

    public Paket(String name, int price, int thumbnail, String btnbeli,String btndetail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.btnbeli = btnbeli;
        this.btndetail = btndetail;

    }
    public String getBtn1(){
        return btnbeli;
    }
    public String getBtn2(){
        return btndetail;
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
