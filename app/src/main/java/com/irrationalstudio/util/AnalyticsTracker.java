package com.irrationalstudio.util;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.irrationalstudio.thefootballmaniac.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prasad-Dekstop on 07-01-2016.
 */
public final class AnalyticsTracker {

    public enum Target {
        APP,
    }

    private static AnalyticsTracker analyticsTracker;

    public static synchronized void initialize(Context context) {

        if (analyticsTracker != null)
            throw new IllegalStateException("Extra call to initialize analytics trackers");

        analyticsTracker = new AnalyticsTracker(context);
    }

    public static synchronized AnalyticsTracker getAnalyticsTracker() {

        if (analyticsTracker == null)
            throw new IllegalStateException("Call initialize() before getInstance()");

        return analyticsTracker;
    }

    private final Map<Target, Tracker> mTrackers = new HashMap();
    private final Context mContext;

    public AnalyticsTracker(Context mContext) {
        this.mContext = mContext;
    }

    public synchronized Tracker get(Target target) {

        if (mTrackers.containsKey(target)) {
            Tracker tracker;

            switch (target) {
                case APP:
                    tracker = GoogleAnalytics.getInstance(mContext).newTracker(R.xml.app_tracker);
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled analytics target " + target);
            }

            mTrackers.put(target, tracker);
        }

        return mTrackers.get(target);

    }
}
