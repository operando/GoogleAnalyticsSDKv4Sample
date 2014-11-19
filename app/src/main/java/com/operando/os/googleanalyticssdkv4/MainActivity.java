package com.operando.os.googleanalyticssdkv4;

import android.app.Activity;
import android.os.Bundle;

import com.operando.os.googleanalyticssdkv4.utils.AnalyticsUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AnalyticsUtil.sendScreenName(this, "Test Page");
        AnalyticsUtil.sendEvent(this, "test", "test", "test");
        AnalyticsUtil.sendEvent(this, R.string.analytics_event_test_category,
                R.string.analytics_event_test_action, R.string.analytics_event_test_label);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
