package com.mechmocha_chorsipahi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpashActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SpashActivity.this.startActivity(new Intent(SpashActivity.this, SpinTheBottleActivity.class));
                SpashActivity.this.finish();
            }
        }, 500);
    }
}
