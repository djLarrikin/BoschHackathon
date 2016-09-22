package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

import android.location.Location;

import edu.depaul.jmorton.boschhack.boschhackathon.models.CarModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;

/**
 * Created by Jonathan Morton on 9/19/16.
 */

public abstract class DangerousAccidents {

    PersonModel person;
    CarModel car;

    public DangerousAccidents(PersonModel person, CarModel car) {
        this.person = person;
        this.car = car;
    }


    public StringBuffer getInformation(Location location) {
        StringBuffer driverInfo = new StringBuffer();


        driverInfo.append("Accident Alert\n");
        driverInfo.append("GPS Location:\n");
        driverInfo.append("Link:\n");

        driverInfo.append("Driver Information:\n");
        driverInfo.append(person.getFirstName() + " " + person.getLastName() + person.getGender() + "\n");
        driverInfo.append(person.getBloodType() + " Blood Type: ");
        driverInfo.append(person.getExtraInfo());


        driverInfo.append("Car Information:\n");
        driverInfo.append(car.getBrand() + car.getModel() + car.getColor() + "\n");
        driverInfo.append(car.getPlate() + "Plate number ");

        return driverInfo;
    }

    public void text911(StringBuffer information) {
        // text information to 911
    }
}
