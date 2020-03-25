package com.nonlinearfruit.creeds.apostlescreed;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;

// http://www.java2s.com/Code/Android/2D-Graphics/ShowsalistthatcanbefilteredinplacewithaSearchViewinnoniconifiedmode.htm
public class ApostlesCreedActivity extends AppCompatActivity {

    private ApostlesCreedDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_paragraph);

        db = new ApostlesCreedDatabase();
        ((TextView) findViewById(R.id.activity_paragraph_paragraph)).setText(db.getCreed());
    }
}