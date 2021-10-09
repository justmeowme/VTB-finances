package com.example.vtb_finances.model;

public class Stock {
    private String name;
    private int count;
    private long sellingPrice;
    private long purchaseCost;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public long getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(long purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Stock(String name, int count, long sellingPrice, long purchaseCost, String image) {
        this.name = name;
        this.count = count;
        this.sellingPrice = sellingPrice;
        this.purchaseCost = purchaseCost;
        this.image = image;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", sellingPrice=" + sellingPrice +
                ", purchaseCost=" + purchaseCost +
                ", image='" + image + '\'' +
                '}';
    }
}
