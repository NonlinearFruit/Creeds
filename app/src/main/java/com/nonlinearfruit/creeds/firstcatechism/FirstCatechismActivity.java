package com.nonlinearfruit.creeds.firstcatechism;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.firstcatechism.models.CatechismQnA;

import java.util.List;


// http://www.java2s.com/Code/Android/2D-Graphics/ShowsalistthatcanbefilteredinplacewithaSearchViewinnoniconifiedmode.htm
public class FirstCatechismActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "SearchViewFilterMode";

    private FirstCatechismDatabase db;
    private SearchView searchView;
    private ListView mListView;
    private CatechismAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        db = new FirstCatechismDatabase();
        List<CatechismQnA> data;
        try{
            data = db.getCatechism(this);
        } catch (Exception exception) {
            data = db.getDefaultCatechism();
        }
        searchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_view);
        adapter = new CatechismAdapter(data,this);

        setupListView();
        setupSearchView();
    }

    private void setupListView() {
        mListView.setAdapter(adapter);
        mListView.setTextFilterEnabled(false);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatechismQnA qna = (CatechismQnA) parent.getAdapter().getItem(position);
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
//            mListView.clearTextFilter();
            adapter.getFilter().filter("");
        } else {
//            mListView.setFilterText(newText.toString());
            adapter.getFilter().filter(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}