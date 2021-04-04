package com.mygdx.game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("StaticFieldLeak")
public class AppLifecycleManager {

    private static Map<Class<? extends Activity>, Boolean> ongoingActivities;

    private static Context context;
    private static LifecycleCallbacks callbacks;

    private static boolean isStarted;


    static void init(Context context, LifecycleCallbacks callbacks) {
        AppLifecycleManager.context = context;
        AppLifecycleManager.callbacks = callbacks;

        ongoingActivities = new HashMap<>();
        isStarted = false;
    }


/*    public static void updateActivityLifecycle(Class<? extends Activity> activity, boolean isVisible) {
        ongoingActivities.put(activity, isVisible);
        manageLifecycleUpdate();
    }*/

    private static void manageLifecycleUpdate() {
        boolean isAppVisible = ongoingActivities.containsValue(true);

        if (isAppVisible) {
            if (!isStarted) {
                isStarted = true;
                callbacks.onVisible();
            }
        } else {
            isStarted = false;
            callbacks.onGone();
        }
    }

    interface LifecycleCallbacks {

        void onVisible();

        void onGone();

    }

}