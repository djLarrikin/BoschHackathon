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
    }


    public boolean isThereFire(TemperatureModel temperature) {
        if (temperature.getTemperature() < 55) {
            return false;
        } else {
            return true;
        }

    }
}