package com.example.mohmassoud.upcomingmovies;

/**
 * Created by Moh.Massoud on 6/30/2018.
 */

public class listItem {
    private String itemName;
    private String itemDes;
    private String itemImgURL;
    private double itemRating;


    public listItem(String itemName, String itemDes, String itemImgURL, double itemRating) {
        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemImgURL = itemImgURL;
        this.itemRating = itemRating;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }

    public void setitemImgURL(String itemImgURL) {
        this.itemImgURL = itemImgURL;
    }

    public void setItemRating(double itemRating) {
        this.itemRating = itemRating;
    }

    public String getItemName() {

        return itemName;
    }

    public String getItemDes() {
        return itemDes;
    }

    public String getitemImgURL() {
        return itemImgURL;
    }

    public double getItemRating() {
        return itemRating;
    }
}
