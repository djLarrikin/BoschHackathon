package edu.depaul.jmorton.boschhack.boschhackathon.receivers;

import android.bluetooth.le.AdvertiseCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import edu.depaul.jmorton.boschhack.boschhackathon.R;
import edu.depaul.jmorton.boschhack.boschhackathon.events.AdvertiseFailureEvent;
import edu.depaul.jmorton.boschhack.boschhackathon.services.AdvertiserService;

/**
 * Created by Jonathan Morton on 9/20/16.
 */

public class AdvertiseFailureReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int errorCode = intent.getIntExtra(AdvertiserService.ADVERTISING_FAILED_EXTRA_CODE, -1);

        String errorMessage = context.getString(R.string.start_error_prefix);
        switch (errorCode) {
            case AdvertiseCallback.ADVERTISE_FAILED_ALREADY_STARTED:
                errorMessage += " " + context.getString(R.string.start_error_already_started);
                break;
            case AdvertiseCallback.ADVERTISE_FAILED_DATA_TOO_LARGE:
                errorMessage += " " + context.getString(R.string.start_error_too_large);
                break;
            case AdvertiseCallback.ADVERTISE_FAILED_FEATURE_UNSUPPORTED:
                errorMessage += " " + context.getString(R.string.start_error_unsupported);
                break;
            case AdvertiseCallback.ADVERTISE_FAILED_INTERNAL_ERROR:
                errorMessage += " " + context.getString(R.string.start_error_internal);
                break;
            case AdvertiseCallback.ADVERTISE_FAILED_TOO_MANY_ADVERTISERS:
                errorMessage += " " + context.getString(R.string.start_error_too_many);
                break;
            case AdvertiserService.ADVERTISING_TIMED_OUT:
                errorMessage = " " + context.getString(R.string.advertising_timedout);
                break;
            default:
                errorMessage += " " + context.getString(R.string.start_error_unknown);
        }

        EventBus.getDefault().post(new AdvertiseFailureEvent(errorCode, errorMessage));
    }
}
