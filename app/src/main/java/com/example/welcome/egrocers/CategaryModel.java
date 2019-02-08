package com.example.welcome.egrocers;

/**
 * Created by WELCOME on 2/5/2019.
 */

public class CategaryModel {

private String Name;
private String Image;

    public CategaryModel() {
    }

    public CategaryModel(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
