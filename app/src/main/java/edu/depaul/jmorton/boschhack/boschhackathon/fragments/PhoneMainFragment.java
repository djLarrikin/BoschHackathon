package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.depaul.jmorton.boschhack.boschhackathon.R;


/**
 * Fragment representing the phone that will have GPS information and handle receiving advertisements.
 */
public class PhoneMainFragment extends Fragment {

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_main, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
