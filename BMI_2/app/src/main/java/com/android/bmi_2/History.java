package com.android.bmi_2;

public class History {
    private int icon;
    private String height;
    private String weight;
    private String bmi;
    private String name;

    public History(int icon, String height, String weight, String bmi, String name) {
        this.icon = icon;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }
}
