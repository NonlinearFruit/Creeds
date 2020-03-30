package com.nonlinearfruit.creeds.confession;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nonlinearfruit.creeds.confession.models.Chapter;
import com.nonlinearfruit.creeds.confession.models.Section;

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

public class ConfessionDatabase {
    private List<Chapter> chapters = new ArrayList<Chapter>(){{
        add(new Chapter(){{
            Chapter = 1;
            Title = "Of Holy Scripture";
            Sections = new ArrayList<Section>() {{
                add(new Section(){{
                    Section = "1";
                    Content = "Although the light of nature, and the works of creation and providence do so far manifest the goodness, wisdom, and power of God, as to leave men unexcusable; yet are they not sufficient to give that knowledge of God, and of his will, which is necessary unto salvation. Therefore it pleased the Lord, at sundry times, and in divers manners, to reveal Himself, and to declare that his will unto his Church; and afterwards for the better preserving and propagating of the truth, and for the more sure establishment and comfort of the Church against the corruption of the flesh, and the malice of Satan and of the world, to commit the same wholly unto writing; which makes the Holy Scripture to be most necessary; those former ways of God's revealing his will unto his people being now ceased.";
                    ContentWithProofs = "Although the light of nature, and the works of creation and providence do so far manifest the goodness, wisdom, and power of God, as to leave men unexcusable; yet are they not sufficient to give that knowledge of God, and of his will, which is necessary unto salvation. Therefore it pleased the Lord, at sundry times, and in divers manners, to reveal Himself, and to declare that his will unto his Church; and afterwards for the better preserving and propagating of the truth, and for the more sure establishment and comfort of the Church against the corruption of the flesh, and the malice of Satan and of the world, to commit the same wholly unto writing; which makes the Holy Scripture to be most necessary; those former ways of God's revealing his will unto his people being now ceased.";
                }});
            }};
        }});
    }};

    private int jsonFileId;

    public ConfessionDatabase(int jsonFileId) {

        this.jsonFileId = jsonFileId;
    }

    public List<Chapter> getDefaultConfession() {
        return chapters;
    }

    public List<Chapter> getConfession(Context context) throws IOException{
        Gson gson = new Gson();
        String jsonOutput = readJson(context);
        Type listType = new TypeToken<List<Chapter>>(){}.getType();
        List<Chapter> qnas = gson.fromJson(jsonOutput, listType);
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
