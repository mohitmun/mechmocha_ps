package com.mechmocha_chorsipahi;

import android.app.Application;

import com.mechmocha_chorsipahi.model.CurrentUserSettings;
import com.mechmocha_chorsipahi.model.WorkerThread;

public class AGApplication extends Application {

    public static long myuid;
    private WorkerThread mWorkerThread;

    @Override
    public void onCreate() {
        super.onCreate();

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
