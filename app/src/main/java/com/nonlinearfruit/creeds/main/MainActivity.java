package com.nonlinearfruit.creeds.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private ListView listView;
    private MainAdapter adapter;
    private MainDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        db = new MainDatabase();
        adapter = new MainAdapter(db.getMainMenuItems(), this);

        setupListView();
        setupSearchView();
    }

    private void setupListView() {
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainMenuItem creed = (MainMenuItem) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, creed.IntentClass);
                intent.putExtra("JsonFileId", creed.JsonFileId);
                intent.putExtra("Title", creed.CreedTitle);
                view.getContext().startActivity(intent);
            }
        });
    }

    private void setupSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            adapter.getFilter().filter("");
        } else {
            adapter.getFilter().filter(newText);
        }
        return true;
    }
}
