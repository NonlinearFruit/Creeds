package com.nonlinearfruit.creeds.catechism;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.catechism.models.CatechismQuestion;

import java.util.List;

public class CatechismActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private CatechismDatabase db;
    private SearchView searchView;
    private ListView listView;
    private CatechismAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        int jsonFile = intent.getIntExtra("JsonFileId",1); // TODO: Defaulting to 1 could be _bad_

        setTitle(title);
        setContentView(R.layout.activity_list);

        db = new CatechismDatabase(jsonFile);
        List<CatechismQuestion> data;
        try{
            data = db.getCatechism(this);
        } catch (Exception exception) {
            Log.e("CREEDS", "Loading json failed for "+title, exception);
            data = db.getDefaultCatechism();
        }
        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        adapter = new CatechismAdapter(data,this);

        setupListView();
        setupSearchView();
    }

    private void setupListView() {
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatechismQuestion qna = (CatechismQuestion) parent.getAdapter().getItem(position);
                Toast.makeText(view.getContext(),"Q"+qna.Number+" copied!",Toast.LENGTH_LONG).show();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("qna", "Q"+qna.Number+": "+qna.Question+"\nA: "+qna.Answer);
                clipboard.setPrimaryClip(clip);
            }
        });
    }

    private void setupSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            adapter.getFilter().filter("");
        } else {
            adapter.getFilter().filter(newText);
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}