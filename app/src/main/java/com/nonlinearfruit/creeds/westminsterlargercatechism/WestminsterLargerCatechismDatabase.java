package com.nonlinearfruit.creeds.westminsterlargercatechism;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.firstcatechism.models.CatechismQnA;
import com.nonlinearfruit.creeds.westminsterlargercatechism.models.CatechismQuestion;

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

public class WestminsterLargerCatechismDatabase {
    private List<CatechismQuestion> catechism = new ArrayList<CatechismQuestion>(){{
        add(new CatechismQuestion(){{
            Number = 1;
            Question = "Who made you?";
            Answer = "God made me";
        }});
        add(new CatechismQuestion(){{
            Number = 2;
            Question = "What else did God make?";
            Answer = "God made all things";
        }});
        add(new CatechismQuestion(){{
            Number = 3;
            Question = "Why did God make you and all things";
            Answer = "For His own glory";
        }});
    }};

    public List<CatechismQuestion> getDefaultCatechism() {
        return catechism;
    }

    public List<CatechismQuestion> getCatechism(Context context) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Type listType = new TypeToken<List<CatechismQuestion>>(){}.getType();
        List<CatechismQuestion> qnas = gson.fromJson(jsonOutput, listType);
        Collections.reverse(qnas);
        return qnas;
    }

    private String readJson(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.wlc);
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
