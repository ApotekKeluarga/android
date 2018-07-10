package com.example.aprian_pc.akonline.TabSuplemen;

public class Suplemen {
    private String name;
    private int price;
    private String thumbnail;
    private String btnbeli;
    private String id;
    private String btndetail;

    public Suplemen(String name, int price, String thumbnail, String btnbeli, String btndetail, String id) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.btnbeli = btnbeli;
        this.btndetail = btndetail;
        this.id = id;

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

    public String getThumbnail() {
        return thumbnail;
    }

    public String getId(){
        return this.id;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
