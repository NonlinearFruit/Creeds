package com.nonlinearfruit.creeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.nonlinearfruit.creeds.apostlescreed.ApostlesCreedActivity;
import com.nonlinearfruit.creeds.firstcatechism.CatechismAdapter;
import com.nonlinearfruit.creeds.firstcatechism.FirstCatechismActivity;
import com.nonlinearfruit.creeds.firstcatechism.FirstCatechismDatabase;
import com.nonlinearfruit.creeds.firstcatechism.models.CatechismQnA;

import java.util.ArrayList;
import java.util.List;

public class CreedActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private ListView mListView;
    private CreedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        searchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_view);
        List<Creed> data = new ArrayList<Creed>(){{
            add(new Creed(){{
                Title="First Catechism";
                Year=2003;
                Class=FirstCatechismActivity.class;
            }});
            add(new Creed(){{
                Title="Apostles' Creed";
                Year=710; // De singulis libris canonicis scarapsus ("Excerpt from Individual Canonical Books") of St. Pirminius (Migne, Patrologia Latina 89, 1029 ff.), written between 710 and 714.
                Class= ApostlesCreedActivity.class;
            }});
        }};
        adapter = new CreedAdapter(data, this);

        setupListView();
        setupSearchView();
    }

    private void setupListView() {
        mListView.setAdapter(adapter);
        mListView.setTextFilterEnabled(false);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Creed creed = (Creed) parent.getAdapter().getItem(position);
                Intent toMediaWeGo = new Intent(CreedActivity.this, creed.Class);
                view.getContext().startActivity(toMediaWeGo);
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
        return false;
    }
}
