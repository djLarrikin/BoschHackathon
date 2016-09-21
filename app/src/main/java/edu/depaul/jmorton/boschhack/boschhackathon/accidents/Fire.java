package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

import edu.depaul.jmorton.boschhack.boschhackathon.models.CarModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.TemperatureModel;

/**
 * Created by Dina on 9/20/16.
 */

public class Fire extends DangerousAccidents {

    PersonModel person;
    CarModel car;
    TemperatureModel temperature;


    public Fire(PersonModel person, CarModel car, TemperatureModel temperature) {
        this.person = person;
        this.car = car;
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

    public StringBuffer getInformation() {
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

        return driverInfo;
    }

    public void text911(StringBuffer information) {
        // text information to 911
    }
}