package com.mechmocha_chorsipahi;

import android.app.Application;
import android.util.Log;

import com.mechmocha_chorsipahi.model.CurrentUserSettings;
import com.mechmocha_chorsipahi.model.WorkerThread;

import java.util.HashMap;
import java.util.Map;

public class AGApplication extends Application {

    public static long myuid;
    public static boolean reveal;
    private WorkerThread mWorkerThread;
    public static Map<Long, String> role_map = new HashMap<>();

    public static boolean isitme(long longUid) {
        Log.d("wtf", "myuid: " + myuid + " passed: "+longUid);
        return myuid == longUid;
    }

    public static String myrole() {
        return role_map.get(myuid);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        resetGame();
    }

    private void resetGame() {
        reveal = false;
        role_map.clear();
//        myuid = Long.parseLong(null);
    }

    public synchronized void initWorkerThread() {
        if (mWorkerThread == null) {
            mWorkerThread = new WorkerThread(getApplicationContext());
            mWorkerThread.start();

            mWorkerThread.waitForReady();
        }
    }

    public synchronized WorkerThread getWorkerThread() {
        return mWorkerThread;
    }

    public synchronized void deInitWorkerThread() {
        mWorkerThread.exit();
        try {
            mWorkerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mWorkerThread = null;
    }

    public static final CurrentUserSettings mVideoSettings = new CurrentUserSettings();
}
