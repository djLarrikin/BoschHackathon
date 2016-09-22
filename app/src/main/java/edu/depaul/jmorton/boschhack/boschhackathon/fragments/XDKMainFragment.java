package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.bluetooth.Constants;
import edu.depaul.jmorton.boschhack.boschhackathon.receivers.AdvertiseFailureReceiver;
import edu.depaul.jmorton.boschhack.boschhackathon.services.AdvertiserService;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Fragment representing the XDK, will advertise different accident events.
 */
public class XDKMainFragment extends Fragment implements SensorEventListener {

    private AdvertiseFailureReceiver advertisingFailureReceiver;
    private SensorManager mSensorManager;
    private Sensor gyroSensor;
    private static final float NS2S = 1.0f / 1000000000.0f; // Create a constant to convert nanoseconds to seconds.
    private final float[] deltaRotationVector = new float[4];
    private float timestamp;

    public XDKMainFragment() {
        // Required empty public constructor
    }

    public static XDKMainFragment newInstance() {
        return new XDKMainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        advertisingFailureReceiver = new AdvertiseFailureReceiver();
        startAdvertising(Constants.SAFE);

        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        gyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xdkmain, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        IntentFilter failureFilter = new IntentFilter(AdvertiserService.ADVERTISING_FAILED);
        getActivity().registerReceiver(advertisingFailureReceiver, failureFilter);
        if (!AdvertiserService.running) {
            startAdvertising(Constants.SAFE);
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        stopAdvertising();
        super.onDestroy();
    }

    /**
     * Returns Intent addressed to the {@code AdvertiserService} class.
     */
    private static Intent getServiceIntent(Context c, String accident) {
        Intent intent = new Intent(c, AdvertiserService.class);
        intent.putExtra(Constants.ACCIDENT_TYPE, accident);
        return intent;
    }

    /**
     * Starts BLE Advertising by starting {@code AdvertiserService}.
     */
    private void startAdvertising(String accident) {
        Context c = getActivity();
        c.startService(getServiceIntent(c, accident));
    }

    /**
     * Stops BLE Advertising by stopping {@code AdvertiserService}.
     */
    private void stopAdvertising() {
        Context c = getActivity();
        c.stopService(getServiceIntent(c, Constants.SAFE));
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if (timestamp != 0) {
            final float dT = (event.timestamp - timestamp) * NS2S;
            // Axis of the rotation sample, not normalized yet.
            float axisX = Math.abs(event.values[0]);
            float axisY = Math.abs(event.values[1]);
            float axisZ = Math.abs(event.values[2]);
        }
        timestamp = event.timestamp;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        do nothing
    }
}
