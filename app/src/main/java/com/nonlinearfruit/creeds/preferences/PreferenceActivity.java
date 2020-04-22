package com.nonlinearfruit.creeds.preferences;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;

public class PreferenceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Preferences");
        setContentView(R.layout.activity_preferences);
    }
}
