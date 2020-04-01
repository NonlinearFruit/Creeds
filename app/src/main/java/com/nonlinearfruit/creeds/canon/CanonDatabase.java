package com.nonlinearfruit.creeds.canon;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nonlinearfruit.creeds.canon.models.Article;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanonDatabase {
    private List<Article> canons = new ArrayList<Article>(){{
        add(new Article(){{
            Article = "1";
            Title = "Of Creation";
            Content = "God made all things";
        }});
    }};

    private int jsonFileId;

    public CanonDatabase(int jsonFileId) {

        this.jsonFileId = jsonFileId;
    }

    public List<Article> getDefaultCanon() {
        return canons;
    }

    public List<Article> getCanon(Context context) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Type listType = new TypeToken<List<Article>>(){}.getType();
        List<Article> canons = gson.fromJson(jsonOutput, listType);
        Collections.reverse(canons);
        return canons;
    }

    private String readJson(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(jsonFileId);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }

        String jsonString = writer.toString();
        return jsonString;
    }
}
