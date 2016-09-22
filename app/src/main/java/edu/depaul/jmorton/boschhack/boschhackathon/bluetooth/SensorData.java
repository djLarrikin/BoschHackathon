package edu.depaul.jmorton.boschhack.boschhackathon.bluetooth;

import javax.inject.Singleton;

import edu.depaul.jmorton.boschhack.boschhackathon.models.Gyroscope;
import edu.depaul.jmorton.boschhack.boschhackathon.models.TemperatureModel;

/**
 * Created by Jonathan Morton on 9/21/16.
 */

@Singleton
public class SensorData {

    private Gyroscope gyroscope;
    private TemperatureModel temperature;

    private static SensorData sensorData = null;

    private SensorData() {
        gyroscope = new Gyroscope();
        temperature = new TemperatureModel();
    }

    public static SensorData getSensorData() {

        if (sensorData == null) {
            sensorData = new SensorData();
        }

        return sensorData;
    }

    public Gyroscope getGyroscope() {
        return gyroscope;
    }

    public TemperatureModel getTemperature() {
        return temperature;
    }


}
