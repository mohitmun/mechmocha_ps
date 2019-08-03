package com.mechmocha_chorsipahi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.mechmocha_chorsipahi.R;

public class MainActivity extends AppCompatActivity {
    private OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            switch (menuItem.getItemId()) {
//                case R.id.navigation_dashboard /*2131296433*/:
//                    MainActivity.this.mTextMessage.setText("R.string.title_dashboard");
//                    return true;
//                case C0669R.C0671id.navigation_home /*2131296435*/:
//                    MainActivity.this.mTextMessage.setText("C0669R.string.title_home");
//                    return true;
//                case C0669R.C0671id.navigation_notifications /*2131296436*/:
//                    MainActivity.this.mTextMessage.setText("C0669R.string.title_notifications");
//                    return true;
//                default:
//                    return false;
//            }
            return true;
        }
    };

    /* access modifiers changed from: private */
    public TextView mTextMessage;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.mTextMessage = (TextView) findViewById(R.id.message);
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
    }
}
