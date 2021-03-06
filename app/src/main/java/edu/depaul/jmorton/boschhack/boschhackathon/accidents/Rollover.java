package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

/**
 * Created by stefanie on 9/21/16.
 */

import edu.depaul.jmorton.boschhack.boschhackathon.models.CarModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.Gyroscope;
import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;

public class Rollover extends DangerousAccidents {

    PersonModel person;
    CarModel car;
    Gyroscope gyrosocpe;

    public Rollover(PersonModel person, CarModel car, Gyroscope gyroscope) {
        super(person, car);
    }

    public boolean isThereRollover(Gyroscope gyroscope) {
        //suppose when the car accident happened the rate of rotation is larger than 180 degree per second (pi/2)
        if ((gyroscope.getAxisX() < 1.57) && (gyroscope.getAxisY() < 1.57) && (gyroscope.getAxisZ() < 1.57)) {
            return false;
        } else {
            return true;
        }

    }


}
