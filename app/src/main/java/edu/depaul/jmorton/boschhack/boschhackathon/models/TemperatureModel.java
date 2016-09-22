package edu.depaul.jmorton.boschhack.boschhackathon.models;

/**
 * Created by Jonathan Morton on 9/19/16.
 */

public class TemperatureModel {

    private long temperature;

    public TemperatureModel() {
        this.temperature = 55;
    }

    public TemperatureModel(long temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getTemperature() {
        return temperature;
    }
}
