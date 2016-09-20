package edu.depaul.jmorton.boschhack.boschhackathon.models;

/**
 * Created by Ru Fang on 9/20/16.
 */

public class CarModel {
    private String brand;
    private String model;
    private String color;
    private String plate;
    private String driver;

    //  Constructor
    public CarModel(String plate) {
//        this.brand = nBrand;
//        this.model = nModel;
//        this.color = nColor;
//        String nBrand, String nModel, String nColor
        this.plate = plate;
    }

    //  getters and setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public String getPlate() {
        return this.plate;
    }

//    public String

}
