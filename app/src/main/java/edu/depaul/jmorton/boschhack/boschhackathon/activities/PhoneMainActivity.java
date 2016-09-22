package edu.depaul.jmorton.boschhack.boschhackathon.activities;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import edu.depaul.jmorton.boschhack.boschhackathon.R;

public class PhoneMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_main);
        sendSMS("2025940521", "testing");
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(this, "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
