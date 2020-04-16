package com.nonlinearfruit.creeds.henryscatechism;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nonlinearfruit.creeds.henryscatechism.models.HenrysCatechismQuestion;

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

public class HenrysCatechismDatabase {
    private List<HenrysCatechismQuestion> catechism = new ArrayList<HenrysCatechismQuestion>(){{
        add(new HenrysCatechismQuestion(){{
            Number = "1";
            Question = "Who made you?";
            Answer = "God made me";
        }});
        add(new HenrysCatechismQuestion(){{
            Number = "2";
            Question = "What else did God make?";
            Answer = "God made all things";
        }});
        add(new HenrysCatechismQuestion(){{
            Number = "3";
            Question = "Why did God make you and all things";
            Answer = "For His own glory";
        }});
    }};

    private int jsonFileId;

    public HenrysCatechismDatabase(int jsonFileId) {

        this.jsonFileId = jsonFileId;
    }

    public List<HenrysCatechismQuestion> getDefaultCatechism() {
        return catechism;
    }

    public List<HenrysCatechismQuestion> getCatechism(Context context) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Type listType = new TypeToken<List<HenrysCatechismQuestion>>(){}.getType();
        List<HenrysCatechismQuestion> qnas = gson.fromJson(jsonOutput, listType);
        Collections.reverse(qnas);
        return qnas;
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
