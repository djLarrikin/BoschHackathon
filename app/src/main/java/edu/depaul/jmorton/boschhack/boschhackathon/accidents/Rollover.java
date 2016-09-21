package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

/**
 * Created by stefanie on 9/21/16.
 */

import edu.depaul.jmorton.boschhack.boschhackathon.models.Gyroscope;

public class Rollover extends DangerousAccidents {

    //    PersonModel driver;
//    CarModel car;
    Gyroscope gyrosocpe;

    public Rollover(Gyroscope gyroscope) {
//        this.driver = driver;
//        this.car = car;
        checkGyrosocpe(gyroscope);
    }

    public void checkGyrosocpe(Gyroscope gyroscope) {
//      suppose when the car accident happened the rate of rotation is lager than 180 degree per second (pi/2)
        while ((gyroscope.getAxisX() < 1.57) && (gyroscope.getAxisY() < 1.57) && (gyroscope.getAxisZ() < 1.57)) {

        }

//        text911();

    }


}
