package com.nonlinearfruit.creeds.henryscatechism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.catechism.models.CatechismQuestion;
import com.nonlinearfruit.creeds.confession.models.Chapter;
import com.nonlinearfruit.creeds.confession.models.Section;
import com.nonlinearfruit.creeds.henryscatechism.models.HenrysCatechismQuestion;

import java.util.ArrayList;
import java.util.List;

public class HenrysCatechismAdapter extends ArrayAdapter<HenrysCatechismQuestion> implements Filterable{

    private List<HenrysCatechismQuestion> catechismQnAs;
    private Context context;
    private Filter filter;
    private List<HenrysCatechismQuestion> originalQnAs;

    public HenrysCatechismAdapter(List<HenrysCatechismQuestion> catechismQnAs, Context ctx) {
        super(ctx, 0, catechismQnAs);
        this.catechismQnAs = catechismQnAs;
        this.context = ctx;
        this.originalQnAs = catechismQnAs;
    }

    public int getCount() {
        return catechismQnAs.size();
    }

    public HenrysCatechismQuestion getItem(int position) {
        return catechismQnAs.get(getCount()-position-1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        HenrysCatechismQuestion chapter = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.item_henrycatechism, null);

        ((TextView) view.findViewById(R.id.item_henrycatechism_number)).setText("Q" + chapter.Number + ":");
        ((TextView) view.findViewById(R.id.item_henrycatechism_question)).setText(chapter.Question);
        ((TextView) view.findViewById(R.id.item_henrycatechism_answer)).setText(chapter.Answer);

        LinearLayout sectionHolder = view.findViewById(R.id.item_henrycatechism_catechism_list);
        sectionHolder.removeAllViewsInLayout();
        for (CatechismQuestion section : chapter.SubQuestions)
            sectionHolder.addView(getSectionView(inflater, chapter, section));

        return view;
    }

    private View getSectionView(LayoutInflater inflater, final HenrysCatechismQuestion chapter, final CatechismQuestion section) {
        View sectionView = inflater.inflate(R.layout.item_catechism, null);
        ((TextView) sectionView.findViewById(R.id.item_catechism_number)).setText(chapter.Number+"."+section.Number+":");
        ((TextView) sectionView.findViewById(R.id.item_catechism_question)).setText(section.Question);
        ((TextView) sectionView.findViewById(R.id.item_catechism_answer)).setText(section.Answer);
        sectionView.setClickable(true);
        sectionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Clicked "+chapter.Number+"."+section.Number,Toast.LENGTH_LONG).show();
            }
        });
        return sectionView;
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
            } else {
                List<HenrysCatechismQuestion> matches = new ArrayList<HenrysCatechismQuestion>();
                String query = constraint.toString().toLowerCase();
                for (HenrysCatechismQuestion chapter : originalQnAs)
                    if (isMatch(query, chapter))
                        matches.add(chapter);
                    else {
                        HenrysCatechismQuestion onlyMatches = getOnlyMatchingSections(query, chapter);
                        if (!onlyMatches.SubQuestions.isEmpty())
                            matches.add(onlyMatches);
                    }


                results.values = matches;
                results.count = matches.size();
            }
            return results;
        }

        private boolean isMatch(String query, HenrysCatechismQuestion chapter) {
            return chapter.Number.equals(query) ||
                    chapter.Question.toLowerCase().contains(query) ||
                    chapter.Answer.toLowerCase().contains(query);
        }

        private HenrysCatechismQuestion getOnlyMatchingSections(String query, final HenrysCatechismQuestion chapter) {
            HenrysCatechismQuestion onlyMatches = new HenrysCatechismQuestion(){{
                 Number = chapter.Number;
                 Question = chapter.Question;
                 Answer = chapter.Answer;
                 SubQuestions = new ArrayList<CatechismQuestion>();
            }};

            for (CatechismQuestion section : chapter.SubQuestions)
                if (isMatch(query, section))
                    onlyMatches.SubQuestions.add(section);
            return onlyMatches;
        }

        private boolean isMatch(String query, CatechismQuestion section) {
            return section.Number.equals(query) ||
                    section.Question.toLowerCase().contains(query) ||
                    section.Answer.toLowerCase().contains(query);
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0) {
                catechismQnAs = (List<HenrysCatechismQuestion>) results.values;
                notifyDataSetInvalidated();
            }
            else {
                catechismQnAs = (List<HenrysCatechismQuestion>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}