package edu.depaul.jmorton.boschhack.boschhackathon.accidents;

import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;

/**
 * Created by Dina on 9/20/16.
 */

public class Fire extends DangerousAccidents {
    StringBuffer information = new StringBuffer();
    PersonModel person;


    public Fire(PersonModel person) {
        this.person = person;
        checkTemperature();
    }

    public void checkTemperature() {
        int temperature = 55;
        while (temperature < 55) {
        } // dont do anything
        // temperature >= 55
        getInformation(information);
        text911(information);
    }

    public void getInformation(StringBuffer information) {

        information.append(" Accident Alert\n");
        information.append(" GPS Location:\n");
        information.append(" Link:\n");

        information.append(" Driver Information:\n");
        information.append(" Driver name: " + person.getFirstName() + " " + person.getLastName() + "\n");
        information.append(" Gender: " + person.getGender() + " Blood Type: " + person.getBloodType());
        information.append(" Extra Info: \n" + person.getExtraInfo());

        /*
        information.append(" Car Information:\n");
        information.append(" Car Make: " + car.getBrand() + "\n");
        information.append(" Car Model: " + car.getModel() + "\n");
        information.append(" Car Color: " + car.getColor());
        information.append(" Licence Plate: " + car.getPlate()+ "\n");
        */
    }

    public void text911(StringBuffer information) {
        // text information to 911
    }
}