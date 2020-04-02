package com.nonlinearfruit.creeds.main;

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
import androidx.core.content.ContextCompat;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends ArrayAdapter<MainMenuItem> implements Filterable {
    private List<MainMenuItem> creeds;
    private Context context;
    private Filter filter;
    private List<MainMenuItem> originalCreeds;

    public MainAdapter(List<MainMenuItem> creeds, @NonNull Context context) {
        super(context, 0, creeds);
        this.creeds = creeds;
        this.context = context;
        this.originalCreeds = this.creeds;
    }

    public int getCount() {
        return creeds.size();
    }

    public MainMenuItem getItem(int position) {
        return creeds.get(getCount() - position - 1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        MainMenuItem p = getItem(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_mainmenu, null);
        }

        ((TextView) view.findViewById(R.id.item_mainmenu_title)).setText(p.CreedTitle);
        ((TextView) view.findViewById(R.id.item_mainmenu_year)).setText(p.CreedYear + " AD");

        int color;
        if (position % 2 == 0)
            color = ContextCompat.getColor(context, R.color.listItemPlain);
        else
            color = ContextCompat.getColor(context, R.color.listItemAccented);
        view.setBackgroundColor(color);

        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new MainFilter();
        return filter;
    }

    private class MainFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = originalCreeds;
                results.count = originalCreeds.size();
            } else {
                List<MainMenuItem> matches = new ArrayList<MainMenuItem>();
                String query = constraint.toString();
                for (MainMenuItem item : originalCreeds)
                    if (isMatch(query, item))
                        matches.add(item);

                results.values = matches;
                results.count = matches.size();
            }
            return results;
        }

        private boolean isMatch(String query, MainMenuItem creed) {
            return creed.CreedYear.toString().equals(query) ||
                    creed.CreedTitle.contains(query);
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            creeds = (List<MainMenuItem>) results.values;
            if (results.count == 0)
                notifyDataSetInvalidated();
            else
                notifyDataSetChanged();
        }
    }
}
