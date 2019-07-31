package com.example.notes;

public class ModelNote {
    private String Judul;
    private String Desc;
    private int id;

    public ModelNote(String judul, String desc, int id) {
        Judul = judul;
        Desc = desc;
        this.id = id;
    }

    public ModelNote(int id, String judul, String desc) {
        Judul = judul;
        Desc = desc;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getDesc() {
        return Desc;
    }

    public void setIsi(String desc) {
        Desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
