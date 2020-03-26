package com.nonlinearfruit.creeds.westminsterlargercatechism;

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
import com.nonlinearfruit.creeds.firstcatechism.CatechismAdapter;
import com.nonlinearfruit.creeds.firstcatechism.FirstCatechismDatabase;
import com.nonlinearfruit.creeds.firstcatechism.models.CatechismQnA;
import com.nonlinearfruit.creeds.westminsterlargercatechism.models.CatechismQuestion;

import java.util.List;


// http://www.java2s.com/Code/Android/2D-Graphics/ShowsalistthatcanbefilteredinplacewithaSearchViewinnoniconifiedmode.htm
public class WestminsterLargerCatechismActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "SearchViewFilterMode";

    private SearchView searchView;
    private ListView listView;
    private WestminsterLargerCatechismAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        WestminsterLargerCatechismDatabase db = new WestminsterLargerCatechismDatabase();
        List<CatechismQuestion> data;
        try{
            data = db.getCatechism(this);
        } catch (Exception exception) {
            data = db.getDefaultCatechism();
        }
        searchView = (SearchView) findViewById(R.id.search_view);
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new WestminsterLargerCatechismAdapter(data,this);

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
            adapter.getFilter().filter(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}