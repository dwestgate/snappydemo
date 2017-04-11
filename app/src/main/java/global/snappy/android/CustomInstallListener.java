package global.snappy.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import io.branch.referral.InstallListener;

/**
 * Created by david on 2/16/17.
 */

public class CustomInstallListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //Inform Branch Install listener about the install
        InstallListener listener = new InstallListener();
        listener.onReceive(context, intent);
//
//        In case you want to use  multiple listeners for install Add other install referrer listeners here.
//        Below example shows how to do it for Google Analytics

//        InstallReferrerReceiver receiver = new InstallReferrerReceiver();
//        receiver.onReceive(Context context, Intent intent);

    }
}
