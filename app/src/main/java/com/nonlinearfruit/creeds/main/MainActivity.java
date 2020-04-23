package com.nonlinearfruit.creeds.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;
import com.nonlinearfruit.creeds.preferences.PreferenceActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private MainAdapter adapter;
    private ListView listView;
    private Boolean preferencesHaveChanged = false;
    private SharedPreferences.OnSharedPreferenceChangeListener listener; // If reference isn't stored, it is garbage collected and lost

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupListView();
        setupAdapter(listView);
        setupSearchView();
        setupPreferenceListener();
    }

    private void setupPreferenceListener() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences preference, String newValue) {
                preferencesHaveChanged = true;
            }
        };
        preferences.registerOnSharedPreferenceChangeListener(listener);
    }

    private void setupAdapter(ListView listView) {
        adapter = new MainAdapter(getFilteredCreeds(), this);
        listView.setAdapter(adapter);
    }

    private void setupListView() {
        listView = findViewById(R.id.list_view);
        listView.setTextFilterEnabled(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainMenuItem creed = (MainMenuItem) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, creed.getIntentClass());
                intent.putExtra("JsonFileId", creed.getJsonFileId());
                intent.putExtra("Title", creed.getCreedTitle());
                view.getContext().startActivity(intent);
            }
        });
    }

    private void setupSearchView() {
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
    }

    private List<MainMenuItem> getFilteredCreeds() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        MainDatabase db = new MainDatabase();
        List<MainMenuItem> items = db.getMainMenuItems();

        Set<String> defaultCheckedCreeds = new HashSet<>();
        for (MainMenuItem item : items)
           defaultCheckedCreeds.add(item.getCreedTitle());
        Set<String> checkedCreeds = preferences.getStringSet("creeds", defaultCheckedCreeds);

        List<MainMenuItem> filteredItems = new ArrayList<MainMenuItem>();
        for (MainMenuItem item: items)
            if (checkedCreeds.contains(item.getCreedTitle()))
                filteredItems.add(item);
        return sortList(filteredItems);
    }

    private List<MainMenuItem> sortList(List<MainMenuItem> items) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final Boolean chronologicalOrder = preferences.getBoolean("order", true);
        Collections.sort(items, new Comparator<MainMenuItem>() {
            @Override
            public int compare(MainMenuItem a, MainMenuItem b) {
                return chronologicalOrder
                        ? b.getCreedYear() - a.getCreedYear()
                        : b.getCreedTitle().compareTo(a.getCreedTitle());
            }
        });
        return items;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!preferencesHaveChanged)
            return;

        setupAdapter(listView);
        preferencesHaveChanged = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 0, 0, "Preferences");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
        this.startActivity(intent);
        return true;
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
