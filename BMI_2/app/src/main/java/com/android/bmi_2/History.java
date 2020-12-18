package com.android.bmi_2;

public class History {
    private int icon;
    private int height;
    private int weight;
    private int bmi;
    private int userneed;
    private String name;

    public History(int icon, int height, int weight, int bmi, int userneed, String name) {
        this.icon = icon;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.userneed = userneed;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public int getUserneed() {
        return userneed;
    }

    public void setUserneed(int userneed) {
        this.userneed = userneed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
