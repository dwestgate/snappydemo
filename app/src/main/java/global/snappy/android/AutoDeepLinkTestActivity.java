package global.snappy.android;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.util.Iterator;

import io.branch.referral.Branch;

/**
 * Created by david on 2/16/17.
 */

public class AutoDeepLinkTestActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.auto_deep_link_test);

        TextView launch_mode_txt = (TextView) findViewById(R.id.launch_mode_txt);
        if (Branch.isAutoDeepLinkLaunch(this)) {
            String message = null;
            try {
                message = Branch.getInstance().getLatestReferringParams().getString("$deeplink_path");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            launch_mode_txt.setText(message);
        } else {
            launch_mode_txt.setText("Launched by normal application flow");
        }

        //You can also get linked params for the intent extra.
        if (getIntent().getExtras() != null && getIntent().getExtras().keySet() != null) {
            Iterator<?> keys = getIntent().getExtras().keySet().iterator();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Log.i("BranchTestBed:", "Deep Linked Param " +
                        key + " = " + getIntent().getExtras().getString(key));
            }
        }

    }
}
