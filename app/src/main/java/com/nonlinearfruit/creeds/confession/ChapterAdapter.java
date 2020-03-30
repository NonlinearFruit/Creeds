package com.nonlinearfruit.creeds.confession;

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

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.confession.models.Chapter;
import com.nonlinearfruit.creeds.confession.models.Section;

import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends ArrayAdapter<Chapter> implements Filterable {

    private List<Chapter> chapters;
    private Context context;
    private Filter filter;
    private List<Chapter> originalChapters;

    public ChapterAdapter(List<Chapter> catechismQnAs, Context ctx) {
        super(ctx, 0, catechismQnAs);
        this.chapters = catechismQnAs;
        this.context = ctx;
        this.originalChapters = catechismQnAs;
    }

    public int getCount() {
        return chapters.size();
    }

    public Chapter getItem(int position) {
        return chapters.get(getCount() - position - 1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        Chapter chapter = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.item_chapter, null);

        ((TextView) view.findViewById(R.id.item_chapter_number)).setText("Chapter " + chapter.Chapter + ": ");
        ((TextView) view.findViewById(R.id.item_chapter_title)).setText(chapter.Title);

        LinearLayout sectionHolder = view.findViewById(R.id.item_chapter_section_list);
        sectionHolder.removeAllViewsInLayout();
        for (Section section : chapter.Sections)
            sectionHolder.addView(getSectionView(inflater, chapter, section));

        return view;
    }

    private View getSectionView(LayoutInflater inflater, final Chapter chapter, final Section section) {
        View sectionView = inflater.inflate(R.layout.item_section, null);
        ((TextView) sectionView.findViewById(R.id.item_section_content)).setText(section.Content);
        ((TextView) sectionView.findViewById(R.id.item_section_number)).setText(chapter.Chapter+"."+section.Section);
        sectionView.setClickable(true);
        sectionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Clicked "+chapter.Chapter+"."+section.Section,Toast.LENGTH_LONG).show();
            }
        });
        return sectionView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new ChapterFilter();
        return filter;
    }

    private class ChapterFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = originalChapters;
                results.count = originalChapters.size();
            } else {
                List<Chapter> matches = new ArrayList<Chapter>();
                String query = constraint.toString().toLowerCase();
                for (Chapter chapter : originalChapters)
                    if (isMatch(query, chapter))
                        matches.add(chapter);
                    else {
                        Chapter onlyMatches = getOnlyMatchingSections(query, chapter);
                        if (!onlyMatches.Sections.isEmpty())
                            matches.add(onlyMatches);
                    }


                results.values = matches;
                results.count = matches.size();
            }
            return results;
        }

        private boolean isMatch(String query, Chapter chapter) {
            return chapter.Chapter.toString().equals(query) ||
                    chapter.Title.toLowerCase().contains(query);
        }

        private Chapter getOnlyMatchingSections(String query, final Chapter chapter) {
            Chapter onlyMatches = new Chapter(){{
               Chapter = chapter.Chapter;
               Title = chapter.Title;
               Proofs = chapter.Proofs;
               ProofsWithScripture = chapter.ProofsWithScripture;
               Sections = new ArrayList<Section>();
            }};

            for (Section section : chapter.Sections)
                if (isMatch(query, section))
                    onlyMatches.Sections.add(section);
            return onlyMatches;
        }

        private boolean isMatch(String query, Section section) {
            return section.Section.toString().equals(query) ||
                    section.Content.toLowerCase().contains(query);
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0) {
                chapters = (List<Chapter>) results.values;
                notifyDataSetInvalidated();
            } else {
                chapters = (List<Chapter>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}
