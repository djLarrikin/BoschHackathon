package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.receivers.AdvertiseFailureReceiver;
import edu.depaul.jmorton.boschhack.boschhackathon.services.AdvertiserService;

/**
 * Fragment representing the XDK, will advertise different accident events.
 */
public class XDKMainFragment extends Fragment {

    private AdvertiseFailureReceiver advertisingFailureReceiver;

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
        startAdvertising();
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
            startAdvertising();
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
    private static Intent getServiceIntent(Context c) {
        return new Intent(c, AdvertiserService.class);
    }

    /**
     * Starts BLE Advertising by starting {@code AdvertiserService}.
     */
    private void startAdvertising() {
        Context c = getActivity();
        c.startService(getServiceIntent(c));
    }

    /**
     * Stops BLE Advertising by stopping {@code AdvertiserService}.
     */
    private void stopAdvertising() {
        Context c = getActivity();
        c.stopService(getServiceIntent(c));
    }
}
