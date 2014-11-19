package com.operando.os.googleanalyticssdkv4.utils;

import android.app.Activity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.operando.os.googleanalyticssdkv4.GoogleAnalyticsApp;

public final class AnalyticsUtil {

    private AnalyticsUtil() {
    }

    public static void sendScreenName(Activity activity, String screenName) {
        sendScreenName(activity, GoogleAnalyticsApp.TrackerName.GLOBAL_TRACKER, screenName);
    }

    public static void sendScreenName(Activity activity, GoogleAnalyticsApp.TrackerName trackerName, String screenName) {
        Tracker t = getTracker(activity, trackerName);
        t.setScreenName(screenName);
        t.send(new HitBuilders.AppViewBuilder().build());
    }

    public static void sendEvent(Activity activity, String category, String action, String label) {
        sendEvent(activity, GoogleAnalyticsApp.TrackerName.GLOBAL_TRACKER, category, action, label);
    }

    public static void sendEvent(Activity activity, int categoryId, int actionId, int labelId) {
        sendEvent(activity, GoogleAnalyticsApp.TrackerName.GLOBAL_TRACKER,
                activity.getString(categoryId), activity.getString(actionId), activity.getString(labelId));
    }

    public static void sendEvent(Activity activity, GoogleAnalyticsApp.TrackerName trackerName, String category, String action, String label) {
        Tracker t = getTracker(activity, trackerName);
        t.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());
    }

    private static Tracker getTracker(Activity activity, GoogleAnalyticsApp.TrackerName trackerName) {
        return ((GoogleAnalyticsApp) activity.getApplication()).getTracker(activity, trackerName);
    }

}
