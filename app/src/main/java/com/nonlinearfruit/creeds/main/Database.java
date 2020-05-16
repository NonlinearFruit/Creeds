package com.nonlinearfruit.creeds.main;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nonlinearfruit.creeds.canon.models.Article;
import com.nonlinearfruit.creeds.main.models.Document;

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

public class Database {
    private int jsonFileId;

    public Database(int jsonFileId) {

        this.jsonFileId = jsonFileId;
    }

    public <T> Document<T> getDocument(Context context, Type typeParameter) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Document<T> document = gson.fromJson(jsonOutput, TypeToken.getParameterized(Document.class, typeParameter).getType());
        return document;
    }

    public <T> Document<T> getDocument(Context context, Type typeParameter, Type typeSubParameter) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Document<T> document = gson.fromJson(jsonOutput, TypeToken.getParameterized(Document.class, TypeToken.getParameterized(typeParameter, typeSubParameter).getType()).getType());
        return document;
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
