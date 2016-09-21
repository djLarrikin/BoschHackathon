package edu.depaul.jmorton.boschhack.boschhackathon.models;

/**
 * Created by Ru Fang on 9/21/16.
 */

public class Gyroscope {
    //    In three axises is rate of rotation: rad/s
    private float axisX;
    private float axisY;
    private float axisZ;
    public Gyroscope() {
        this.axisX = 0;
        this.axisY = 0;
        this.axisZ = 0;
    }

//    getters and setters

    public void setAxisX(float axisX) {
        this.axisX = axisX;
    }

    public void setAxisY(float axisY) {
        this.axisY = axisY;
    }

    public void setAixsZ(float aixsZ) {
        this.axisZ = axisZ;
    }

    public float getAxisX() {
        return this.axisX;
    }

    public float getAxisY() {
        return this.axisY;
    }

    public float getAxisZ() {
        return this.axisZ;
    }

    public float[] getGyroscope() {
        float[] gyro = new float[3];
        gyro[0] = getAxisX();
        gyro[1] = getAxisY();
        gyro[2] = getAxisZ();

        return gyro;
    }
}

