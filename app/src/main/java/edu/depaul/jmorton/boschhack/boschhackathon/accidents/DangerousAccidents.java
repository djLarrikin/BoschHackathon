package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

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

    public String getInformation() {
        StringBuffer driverInfo = new StringBuffer();

        driverInfo.append(" Accident Alert\n");
        driverInfo.append(" GPS Location:\n");
        driverInfo.append(" Link:\n");

        driverInfo.append(" Driver Information:\n");
        driverInfo.append(" Driver name: " + person.getFirstName() + " " + person.getLastName() + "\n");
        driverInfo.append(" Gender: " + person.getGender() + " Blood Type: " + person.getBloodType());
        driverInfo.append(" Extra Info: \n" + person.getExtraInfo());


        driverInfo.append(" Car Information:\n");
        driverInfo.append(" Car Make: " + car.getBrand() + "\n");
        driverInfo.append(" Car Model: " + car.getModel() + "\n");
        driverInfo.append(" Car Color: " + car.getColor());
        driverInfo.append(" Licence Plate: " + car.getPlate() + "\n");


        String information = driverInfo.toString();
        return information;
    }
}



