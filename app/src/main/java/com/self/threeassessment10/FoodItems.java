package com.self.threeassessment10;

public class FoodItems {

        public int id;
        public String name, price, imageurl;

    public FoodItems(int id, String name, String price, String imageurl)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }

    public FoodItems() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    
}
