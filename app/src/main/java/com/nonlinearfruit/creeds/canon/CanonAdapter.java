package com.nonlinearfruit.creeds.canon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.canon.models.Article;

import java.util.ArrayList;
import java.util.List;

public class CanonAdapter extends ArrayAdapter<Article> implements Filterable{

    private List<Article> articles;
    private Context context;
    private Filter filter;
    private List<Article> originalArticles;

    public CanonAdapter(List<Article> articles, Context ctx) {
        super(ctx, 0, articles);
        this.articles = articles;
        this.context = ctx;
        this.originalArticles = articles;
    }

    public int getCount() {
        return articles.size();
    }

    public Article getItem(int position) {
        return articles.get(getCount()-position-1);
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        Article data = getItem(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_article, null);
        }

        ((TextView) view.findViewById(R.id.item_article_number)).setText(data.Article +".");
        ((TextView) view.findViewById(R.id.item_article_title)).setText(data.Title);
        ((TextView) view.findViewById(R.id.item_article_content)).setText(data.Content);

        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new ArticleFilter();
        return filter;
    }

    private class ArticleFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = originalArticles;
                results.count = originalArticles.size();
            }
            else {
                List<Article> matches = new ArrayList<Article>();
                String query = constraint.toString().toLowerCase();
                for (Article article : originalArticles)
                    if (isMatch(query, article))
                        matches.add(article);

                results.values = matches;
                results.count = matches.size();
            }
            return results;
        }

        private boolean isMatch(String query, Article article) {
            return article.Article.toLowerCase().equals(query) ||
                    article.Title.toLowerCase().contains(query) ||
                    article.Content.toLowerCase().contains(query);
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0) {
                articles = (List<Article>) results.values;
                notifyDataSetInvalidated();
            }
            else {
                articles = (List<Article>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}