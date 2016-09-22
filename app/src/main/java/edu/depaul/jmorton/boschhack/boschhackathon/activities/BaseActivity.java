package edu.depaul.jmorton.boschhack.boschhackathon.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.databinding.ActivitySingleFragmentBinding;

public class BaseActivity extends AppCompatActivity {

    ActivitySingleFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_fragment);
    }
}
