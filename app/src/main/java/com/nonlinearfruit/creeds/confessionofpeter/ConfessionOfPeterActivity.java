package com.nonlinearfruit.creeds.confessionofpeter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.shemayisrael.ShemaYisraelDatabase;

public class ConfessionOfPeterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_paragraph);

        ((TextView) findViewById(R.id.activity_paragraph_paragraph))
                .setText(new ConfessionOfPeterDatabase().getCreed());
    }
}