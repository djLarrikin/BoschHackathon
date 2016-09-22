package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.bluetooth.Constants;
import edu.depaul.jmorton.boschhack.boschhackathon.databinding.FragmentPhoneMainBinding;
import edu.depaul.jmorton.boschhack.boschhackathon.utils.L;


/**
 * Fragment representing the phone that will have GPS information and handle receiving advertisements.
 */
public class PhoneMainFragment extends Fragment {

    /**
     * Stops scanning after 5 seconds.
     */
    private static final long SCAN_PERIOD = 100 * 1000;

    private BluetoothAdapter mBluetoothAdapter;

    private BluetoothLeScanner mBluetoothLeScanner;

    private ScanCallback mScanCallback;

    private Handler mHandler;
    FragmentPhoneMainBinding binding;

    int textSent = 0;

    /**
     * Must be called after object creation by MainActivity.
     *
     * @param btAdapter the local BluetoothAdapter
     */
    public void setBluetoothAdapter(BluetoothAdapter btAdapter) {
        this.mBluetoothAdapter = btAdapter;
        mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
    }

    public PhoneMainFragment() {
        // Required empty public constructor
    }

    public static PhoneMainFragment newInstance() {
        PhoneMainFragment fragment = new PhoneMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setBluetoothAdapter(mBluetoothAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_main, container, false);
        View view = binding.getRoot();
        mHandler = new Handler();
        startScanning();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Start scanning for BLE Advertisements (& set it up to stop after a set period of time).
     */
    public void startScanning() {
        if (mScanCallback == null) {
            L.d("Starting Scanning");

            // Will stop the scanning after a set time.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    stopScanning();
                }
            }, SCAN_PERIOD);

            // Kick off a new scan.
            mScanCallback = new SampleScanCallback();
            mBluetoothLeScanner.startScan(buildScanFilters(), buildScanSettings(), mScanCallback);

            String toastText = "Scanning every" + " "
                    + TimeUnit.SECONDS.convert(SCAN_PERIOD, TimeUnit.MILLISECONDS) + " "
                    + "seconds";
            Toast.makeText(getActivity(), toastText, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Already scanning", Toast.LENGTH_SHORT);
        }
    }

    /**
     * Stop scanning for BLE Advertisements.
     */
    public void stopScanning() {
        L.d("Stopping Scanning");
        // Stop the scan, wipe the callback.
        mBluetoothLeScanner.stopScan(mScanCallback);
        mScanCallback = null;
    }

    /**
     * Return a List of {@link ScanFilter} objects to filter by Service UUID.
     */
    private List<ScanFilter> buildScanFilters() {
        List<ScanFilter> scanFilters = new ArrayList<>();

        ScanFilter.Builder builder = new ScanFilter.Builder();
        // Comment out the below line to see all BLE devices around you
        builder.setServiceUuid(Constants.Service_UUID);
        scanFilters.add(builder.build());

        return scanFilters;
    }

    /**
     * Return a {@link ScanSettings} object set to use low power (to preserve battery life).
     */
    private ScanSettings buildScanSettings() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY);
        return builder.build();
    }

    /**
     * Custom ScanCallback object - adds to adapter on success, displays error on failure.
     */
    private class SampleScanCallback extends ScanCallback {

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);

            for (ScanResult result : results) {
                L.d(result.getDevice().getName());
                String status = new String(result.getScanRecord().getBytes());
                L.d("status: " + status);
                checkAccident(status);
                L.d(result.getScanRecord().getBytes().toString());
            }
        }

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);

            L.d(result.getDevice().getName());
            String status = new String(result.getScanRecord().getBytes());
            L.d("status: " + status);
            checkAccident(status);
            L.d(result.getScanRecord().getBytes().toString());
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Toast.makeText(getActivity(), "Scan failed with error: " + errorCode, Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void checkAccident(String status) {
        if (status.contains(Constants.ACCIDENT_FIRE)) {
            binding.statusTextView.setText("THERES A FIRE");
            binding.getRoot().setBackgroundColor(Color.RED);
            //sendSMS("", "FIRE");
        } else if (status.contains(Constants.ACCIDENT_ROLLOVER)) {
            binding.statusTextView.setText("THERES A ROLLOVER");
            binding.getRoot().setBackgroundColor(Color.BLUE);
            //sendSMS("", "ROLLOVER");
        } else {
            binding.statusTextView.setText("SAFE");
            binding.getRoot().setBackgroundColor(Color.WHITE);
        }
    }

    public void sendSMS(String phoneNo, String msg) {
        if (textSent <= 0) {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                Toast.makeText(getActivity(), "Message Sent",
                        Toast.LENGTH_LONG).show();
            } catch (Exception ex) {
                Toast.makeText(getActivity(), ex.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
                ex.printStackTrace();
            }

        }
        textSent += 1;
    }
}
