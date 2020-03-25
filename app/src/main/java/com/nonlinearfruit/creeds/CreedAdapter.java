package com.nonlinearfruit.creeds;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CreedAdapter extends ArrayAdapter<Creed> implements Filterable {
    private List<Creed> creeds;
    private Context context;
    private Filter filter;
    private List<Creed> originalCreeds;

    public CreedAdapter(List<Creed> creeds, @NonNull Context context) {
        super(context, 0, creeds);
        this.creeds = creeds;
        this.context = context;
        this.originalCreeds = this.creeds;
    }

    public int getCount() {
        return creeds.size();
    }

    public Creed getItem(int position) {
        return creeds.get(getCount()-position-1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        Creed p = getItem(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_creed, null);
        }

        ((TextView) view.findViewById(R.id.item_creed_title)).setText(p.Title);
        ((TextView) view.findViewById(R.id.item_creed_year)).setText(p.Year+" AD");

        if (position%2==0)
            view.setBackgroundColor(Color.LTGRAY);
        else
            view.setBackgroundColor(Color.WHITE);

        return view;
    }

            @Override
            public Filter getFilter() {
                if (filter == null)
                    filter = new CreedFilter();
                return filter;
            }

            private class CreedFilter extends Filter {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    if (constraint == null || constraint.length() == 0) {
                        results.values = originalCreeds;
                        results.count = originalCreeds.size();
                    }
                    else {
                        List<Creed> matches = new ArrayList<Creed>();
                        String query = constraint.toString();
                        for (Creed qna : originalCreeds)
                            if (isMatch(query, qna))
                                matches.add(qna);

                        results.values = matches;
                        results.count = matches.size();
                    }
                    return results;
                }

                private boolean isMatch(String query, Creed creed) {
                    return (creed.Year+"").equals(query) ||
                            creed.Title.contains(query);
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    creeds = (List<Creed>) results.values;
                    if (results.count == 0)
                        notifyDataSetInvalidated();
                    else
                        notifyDataSetChanged();
                }
            }
        }
