package edu.depaul.jmorton.boschhack.boschhackathon.fragments;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.activities.PhoneMainActivity;
import edu.depaul.jmorton.boschhack.boschhackathon.activities.XDKMainActivity;
import edu.depaul.jmorton.boschhack.boschhackathon.databinding.FragmentChooserBinding;


/**
 * Fragment representing the phone that will have GPS information and handle receiving advertisements.
 */
public class ChooserFragment extends Fragment {

    FragmentChooserBinding binding;

    public ChooserFragment() {
        // Required empty public constructor
    }

    public static ChooserFragment newInstance() {
        ChooserFragment fragment = new ChooserFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chooser, container, false);
        View view = binding.getRoot();

        ImageButton xdkButton = binding.xdkButton;
        xdkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XDKMainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton phoneButton = binding.phoneButton;
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PhoneMainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
