package com.nonlinearfruit.creeds.creed;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;

public class CreedActivity extends AppCompatActivity {

    private ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        Intent intent = getIntent();
        final String title = intent.getStringExtra("Title");
        int contentId = intent.getIntExtra("JsonFileId",1); // TODO: Defaulting to 1 could be _bad_

        setTitle(title);
        setContentView(R.layout.activity_paragraph);

        TextView textView = findViewById(R.id.activity_paragraph_paragraph);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String creed = new CreedDatabase().getCreed(contentId);
        textView.setText(creed);
        textView.setOnLongClickListener(new TextView.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData clip = ClipData.newPlainText("Creeds", title+"\n\n"+((TextView) v).getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(v.getContext(),title+" copied!",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}