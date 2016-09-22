package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

import edu.depaul.jmorton.boschhack.boschhackathon.models.CarModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.TemperatureModel;

/**
 * Created by Dina on 9/20/16.
 */

public class Fire extends DangerousAccidents {

    TemperatureModel temperature;
    PersonModel person;
    CarModel car;

    public Fire(TemperatureModel temperature, PersonModel person, CarModel car) {
        super(person, car);
        this.temperature = temperature;
    }


    public boolean isThereFire() {
        if (temperature.getTemperature() > 55) {
            return true;
        } else {
            return false;
        }
    }


    public TemperatureModel getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperatureDegrees) {
        temperature.setTemperature(temperatureDegrees);
    }
}