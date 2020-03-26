package com.nonlinearfruit.creeds.westminsterlargercatechism;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.firstcatechism.models.CatechismQnA;
import com.nonlinearfruit.creeds.westminsterlargercatechism.models.CatechismQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonfrt on 9/30/17.
 * https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 * https://github.com/survivingwithandroid/Surviving-with-android/blob/master/ListView_Filter_Tutorial/src/com/survivingwithandroid/listview/SimpleList/PlanetAdapter.java
 */
public class WestminsterLargerCatechismAdapter extends ArrayAdapter<CatechismQuestion> implements Filterable{

    private List<CatechismQuestion> catechismQnAs;
    private Context context;
    private Filter filter;
    private List<CatechismQuestion> originalQnAs;

    public WestminsterLargerCatechismAdapter(List<CatechismQuestion> catechismQnAs, Context ctx) {
        super(ctx, 0, catechismQnAs);
        this.catechismQnAs = catechismQnAs;
        this.context = ctx;
        this.originalQnAs = catechismQnAs;
    }

    public int getCount() {
        return catechismQnAs.size();
    }

    public CatechismQuestion getItem(int position) {
        return catechismQnAs.get(getCount()-position-1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        CatechismQuestion p = getItem(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_catechism, null);
        }

        ((TextView) view.findViewById(R.id.questionNumber)).setText("Q"+p.Number+": ");
        ((TextView) view.findViewById(R.id.question)).setText(p.Question);
        ((TextView) view.findViewById(R.id.answer)).setText(p.Answer);

        if (position%2==0)
            view.setBackgroundColor(Color.LTGRAY);
        else
            view.setBackgroundColor(Color.WHITE);

        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new CatechismFilter();
        return filter;
    }

    private class CatechismFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = originalQnAs;
                results.count = originalQnAs.size();
            }
            else {
                List<CatechismQuestion> matches = new ArrayList<CatechismQuestion>();
                String query = constraint.toString();
                for (CatechismQuestion qna : originalQnAs)
                    if (isMatch(query, qna))
                        matches.add(qna);

                results.values = matches;
                results.count = matches.size();
            }
            return results;
        }

        private boolean isMatch(String query, CatechismQuestion qna) {
            return qna.Number.toString().equals(query) ||
                    qna.Question.contains(query) ||
                    qna.Answer.contains(query);
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0) {
                catechismQnAs = (List<CatechismQuestion>) results.values;
                notifyDataSetInvalidated();
            }
            else {
                catechismQnAs = (List<CatechismQuestion>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}