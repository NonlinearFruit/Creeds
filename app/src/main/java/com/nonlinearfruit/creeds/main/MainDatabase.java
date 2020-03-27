package com.nonlinearfruit.creeds.main;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.apostlescreed.ApostlesCreedActivity;
import com.nonlinearfruit.creeds.athanasiancreed.AthanasianCreedActivity;
import com.nonlinearfruit.creeds.chalcedoniancreed.ChalcedonianCreedActivity;
import com.nonlinearfruit.creeds.confessionofpeter.ConfessionOfPeterActivity;
import com.nonlinearfruit.creeds.catechism.CatechismActivity;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;
import com.nonlinearfruit.creeds.nicenecreed.NiceneCreedActivity;
import com.nonlinearfruit.creeds.shemayisrael.ShemaYisraelActivity;
import com.nonlinearfruit.creeds.westminsterconfessionoffaith.WcfActivity;

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
            CreedTitle = "Westminster Larger Catechism";
            CreedYear = 1648;
            CreedOrigin = "";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.wlc;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Westminster Confession of Faith";
            CreedYear = 1647;
            CreedOrigin = "";
            IntentClass = WcfActivity.class;
            JsonFileId = R.raw.westminster_confession_of_faith;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Heidelberg Catechism";
            CreedYear = 1563;
            CreedOrigin = "";
            IntentClass = CatechismActivity.class;
            JsonFileId = R.raw.heidelberg_catechism;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Athanasian Creed";
            CreedYear = 800;
            CreedOrigin = "The oldest surviving manuscripts of the Athanasian Creed date from the late 8th century";
            IntentClass = AthanasianCreedActivity.class;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Apostles' Creed";
            CreedYear = 710;
            CreedOrigin = "De singulis libris canonicis scarapsus ('Excerpt from Individual Canonical Books') of St. Pirminius (Migne, Patrologia Latina 89, 1029 ff.), written between 710 and 714.";
            IntentClass = ApostlesCreedActivity.class;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Chalcedonian Creed";
            CreedYear = 451;
            CreedOrigin = "Adopted at the Council of Chalcedon in AD 451";
            IntentClass = ChalcedonianCreedActivity.class;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Nicene Creed";
            CreedYear = 381;
            CreedOrigin = "Adopted at the Second Ecumenical Council held in Constantinople in 381 as a modification of the original Nicene Creed of 325";
            IntentClass = NiceneCreedActivity.class;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Confession of Peter";
            CreedYear = 30;
            CreedOrigin = "Matthew 16:16";
            IntentClass = ConfessionOfPeterActivity.class;
        }});
        add(new MainMenuItem(){{
            CreedTitle = "Shema Yisrael";
            CreedYear = -1500;
            CreedOrigin = "Deuteronomy 6:4";
            IntentClass = ShemaYisraelActivity.class;
        }});
    }};

    public List<MainMenuItem> getMainMenuItems() {
        return items;
    }
}
