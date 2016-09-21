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
        checkTemperature(temperature);
    }


    public void checkTemperature(TemperatureModel temperature) {
        while (temperature.getTemperature() < 55) {
        } // dont do anything
        // temperature >= 55
        StringBuffer information = new StringBuffer();
        information = getInformation();
        text911(information);
    }


}