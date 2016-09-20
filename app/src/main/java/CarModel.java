/**
 * Created by Ru Fang on 9/20/16.
 */

public class CarModel {
    private String brand;
    private String model;
    private String color;
    private String plate;

    //  Constructor
    public CarModel(String nPlate) {
//        this.brand = nBrand;
//        this.model = nModel;
//        this.color = nColor;
//        String nBrand, String nModel, String nColor
        this.plate = nPlate;
    }

    //  getters and setters
    public void setBrand(String nBrand) {
        this.brand = nBrand;
    }

    public void setModel(String nModel) {
        this.model = nModel;
    }

    public void setColor(String nColor) {
        this.color = nColor;
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

}
