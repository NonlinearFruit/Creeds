package com.nonlinearfruit.creeds.main;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.canon.CanonActivity;
import com.nonlinearfruit.creeds.catechism.CatechismActivity;
import com.nonlinearfruit.creeds.creed.CreedActivity;
import com.nonlinearfruit.creeds.creed.CreedLookup;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;
import com.nonlinearfruit.creeds.confession.ConfessionActivity;

import java.util.ArrayList;
import java.util.List;

public class MainDatabase {

    private List<MainMenuItem> items = new ArrayList<MainMenuItem>(){{
        add(new MainMenuItem(){{
            CreedTitle = "First Catechism";
            CreedYear = 1996;
            CreedOrigin = "Copyright 2003 - Great Commission Publications, Inc";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.first_catechism;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Westminster Shorter Catechism";
            CreedYear = 1647;
            CreedOrigin = "";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.westminster_shorter_catechism;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Westminster Larger Catechism";
            CreedYear = 1647;
            CreedOrigin = "";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.westminster_larger_catechism;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Westminster Confession of Faith";
            CreedYear = 1647;
            CreedOrigin = "";
            IntentClass = ConfessionActivity.class;
            JsonFileId = R.raw.westminster_confession_of_faith;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Canons of Dort";
            CreedYear = 1619;
            CreedOrigin = "";
            IntentClass = ConfessionActivity.class;
            JsonFileId = R.raw.canons_of_dort;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Heidelberg Catechism";
            CreedYear = 1563;
            CreedOrigin = "";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.heidelberg_catechism;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Belgic Confession of Faith";
            CreedYear = 1561;
            CreedOrigin = "";
            IntentClass = CanonActivity.class;
            JsonFileId = R.raw.belgic_confession_of_faith;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Athanasian Creed";
            CreedYear = 800;
            CreedOrigin = "The oldest surviving manuscripts of the Athanasian Creed date from the late 8th century";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.AthanasianCreed.Id;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Apostles' Creed";
            CreedYear = 710;
            CreedOrigin = "De singulis libris canonicis scarapsus ('Excerpt from Individual Canonical Books') of St. Pirminius (Migne, Patrologia Latina 89, 1029 ff.), written between 710 and 714.";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.ApostlesCreed.Id;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Chalcedonian Definition";
            CreedYear = 451;
            CreedOrigin = "Adopted at the Council of Chalcedon in AD 451";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.ChalcedonianDefinition.Id;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Nicene Creed";
            CreedYear = 381;
            CreedOrigin = "Adopted at the Second Ecumenical Council held in Constantinople in 381 as a modification of the original Nicene Creed of 325";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.NiceneCreed.Id;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Confession of Peter";
            CreedYear = 30;
            CreedOrigin = "Matthew 16:16";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.ConfessionOfPeter.Id;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Shema Yisrael";
            CreedYear = -1500;
            CreedOrigin = "Deuteronomy 6:4";
            IntentClass = CreedActivity.class;
            JsonFileId = CreedLookup.ShemaYisrael.Id;
        }});
    }};

    public List<MainMenuItem> getMainMenuItems() {
        return items;
    }
}
