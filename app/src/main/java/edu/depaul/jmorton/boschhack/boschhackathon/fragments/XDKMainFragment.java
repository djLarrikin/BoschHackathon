package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.accidents.Fire;
import edu.depaul.jmorton.boschhack.boschhackathon.bluetooth.Constants;
import edu.depaul.jmorton.boschhack.boschhackathon.databinding.FragmentXdkmainBinding;
import edu.depaul.jmorton.boschhack.boschhackathon.models.CarModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.PersonModel;
import edu.depaul.jmorton.boschhack.boschhackathon.models.TemperatureModel;
import edu.depaul.jmorton.boschhack.boschhackathon.receivers.AdvertiseFailureReceiver;
import edu.depaul.jmorton.boschhack.boschhackathon.services.AdvertiserService;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Fragment representing the XDK, will advertise different accident events.
 */
public class XDKMainFragment extends Fragment implements SensorEventListener {

    private AdvertiseFailureReceiver advertisingFailureReceiver;
    private FragmentXdkmainBinding binding;
    private String accident;
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
        accident = Constants.SAFE;
        startAdvertising(accident);

        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        gyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (gyroSensor != null) {
            mSensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_xdkmain, container, false);
        View view = binding.getRoot();

        ImageButton fireButton = binding.fireButton;
        PersonModel person = new PersonModel("John", "Doe", new Date(1988, 9, 21));
        CarModel car = new CarModel("FRESH");
        final Fire fire = new Fire(new TemperatureModel(), person, car);
        fire.setTemperature(58);
        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fire.isThereFire()) {
                    stopAdvertising();
                    accident = Constants.ACCIDENT_FIRE;
                    startAdvertising(accident);
                }
            }
        });

        Button resetToSafe = binding.safeButton;
        resetToSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAdvertising();
                accident = Constants.SAFE;
                startAdvertising(accident);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        IntentFilter failureFilter = new IntentFilter(AdvertiserService.ADVERTISING_FAILED);
        if (!AdvertiserService.running) {
            startAdvertising(accident);
            getActivity().registerReceiver(advertisingFailureReceiver, failureFilter);
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

            TextView xAxisTextView = binding.rolloverXAxisTextView;
            TextView yAxisTextView = binding.rolloverYAxisTextView;
            TextView zAxisTextView = binding.rolloverZAxisTextView;
            xAxisTextView.setText("X: " + axisX);
            yAxisTextView.setText("Y: " + axisY);
            zAxisTextView.setText("Z: " + axisZ);
        }
        timestamp = event.timestamp;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        do nothing
    }
}
