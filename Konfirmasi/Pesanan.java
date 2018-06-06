package com.example.aprian_pc.akonline.TabHerbal;

public class Pesanan {
    private String status, code;
    private String btnbeli;
    private String btndetail;

    public Pesanan(String status, String code, String btnbeli, String btndetail) {
        this.status = status;
        this.code = code;
        this.btnbeli = btnbeli;
        this.btndetail = btndetail;
}

    public String getBtn1() {
        return btndetail;
    }

    public String getBtn2() {
        return btnbeli;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

}
