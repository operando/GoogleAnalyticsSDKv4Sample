package com.operando.os.googleanalyticssdkv4;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;

public class GoogleAnalyticsApp extends Application {

    public enum TrackerName {
        APP_TRACKER,
        GLOBAL_TRACKER,
        ECOMMERCE_TRACKER,
    }

    HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

    public synchronized Tracker getTracker(Context context, TrackerName trackerName) {
        if (!mTrackers.containsKey(trackerName)) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
            Tracker t = (trackerName == TrackerName.APP_TRACKER) ? analytics.newTracker("")
                    : (trackerName == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker)
                    : analytics.newTracker("");
            mTrackers.put(trackerName, t);
        }
        return mTrackers.get(trackerName);
    }
}
