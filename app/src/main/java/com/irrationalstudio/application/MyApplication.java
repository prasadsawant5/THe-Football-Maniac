package com.irrationalstudio.application;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.irrationalstudio.util.AnalyticsTracker;

/**
 * Created by Prasad-Dekstop on 18-12-2015.
 */
public class MyApplication extends Application {

    private static String action;
    private static final String TAG = MyApplication.class.getName();
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        AnalyticsTracker.initialize(this);
        AnalyticsTracker.getAnalyticsTracker().get(AnalyticsTracker.Target.APP);
    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

    public synchronized Tracker getGoogleAnalyticsTracker() {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.getAnalyticsTracker();
        return analyticsTracker.get(AnalyticsTracker.Target.APP);
    }

    public void trackScreenView(String screenName) {

        Tracker tracker = getGoogleAnalyticsTracker();

        tracker.setScreenName(screenName);

        tracker.send(new HitBuilders.ScreenViewBuilder().build());

        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }

    public void trackException(Exception e) {

        if (e != null) {
            Tracker tracker = getGoogleAnalyticsTracker();

            tracker.send(new HitBuilders.ExceptionBuilder().setDescription(new StandardExceptionParser(this, null).getDescription(Thread.currentThread().getName(), e)).setFatal(false).build());
        }
    }

    public void trackEvent(String category, String action, String label) {
        Tracker tracker = getGoogleAnalyticsTracker();

        tracker.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
    }

    public static void setAction(String response) {
        action = response;
    }

    public static String getAction() {
        return action;
    }


}
