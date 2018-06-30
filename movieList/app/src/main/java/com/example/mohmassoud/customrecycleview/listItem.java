package com.example.mohmassoud.customrecycleview;

/**
 * Created by Moh.Massoud on 6/30/2018.
 */

public class listItem {
    private String itemName;
    private String itemDes;
    private int itemImg;
    private double itemRating;


    public listItem(String itemName, String itemDes, int itemImg, double itemRating) {
        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemImg = itemImg;
        this.itemRating = itemRating;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
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

    public int getItemImg() {
        return itemImg;
    }

    public double getItemRating() {
        return itemRating;
    }
}
