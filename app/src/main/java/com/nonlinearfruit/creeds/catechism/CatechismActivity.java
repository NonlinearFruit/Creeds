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
import com.nonlinearfruit.creeds.main.Database;
import com.nonlinearfruit.creeds.main.models.Document;

import java.util.List;

public class CatechismActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Database db;
    private SearchView searchView;
    private ListView listView;
    private CatechismAdapter adapter;
    private ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        int jsonFile = intent.getIntExtra("JsonFileId",1); // TODO: Defaulting to 1 could be _bad_

        setTitle(title);
        setContentView(R.layout.activity_list);

        db = new Database(jsonFile);
        Document<List<CatechismQuestion>> data;
        try{
            data = db.getDocument(this, List.class, CatechismQuestion.class);
        } catch (Exception exception) {
            Log.e("CREEDS", "Loading json failed for "+title, exception);
            return;
        }
        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        adapter = new CatechismAdapter(data.Data,this);
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        setupListView();
        setupSearchView();
    }

    private void setupListView() {
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                CatechismQuestion qna = (CatechismQuestion) parent.getAdapter().getItem(position);
                ClipData clip = ClipData.newPlainText("Creeds", "Q"+qna.Number+": "+qna.Question+"\n"+qna.Answer);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(view.getContext(),"Q"+qna.Number+" copied!",Toast.LENGTH_LONG).show();
                return false;
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