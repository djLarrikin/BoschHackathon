package edu.depaul.jmorton.boschhack.boschhackathon.models;

/**
 * Created by Jonathan Morton on 9/21/16.
 */

public class DriverModel extends PersonModel {

    private CarModel car;

    public DriverModel(PersonModel person, CarModel car) {
        super(person.getNamef(), person.getNamel(), person.getBirthdate());
        this.car = car;
    }
}
