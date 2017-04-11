package global.snappy.android;

import io.branch.referral.BranchApp;

/**
 * Created by david on 2/16/17.
 */

public final class CustomBranchApp extends BranchApp {
    @Override
    public void onCreate() {
        super.onCreate();
        // Uncomment to test memory leak
        // LeakCanary.install(this);
    }
}
