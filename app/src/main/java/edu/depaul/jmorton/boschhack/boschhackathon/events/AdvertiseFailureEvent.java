package edu.depaul.jmorton.boschhack.boschhackathon.events;

/**
 * Created by Jonathan Morton on 9/20/16.
 */

public class AdvertiseFailureEvent {
    private int errorCode;
    private String errorMessage;

    public AdvertiseFailureEvent(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
