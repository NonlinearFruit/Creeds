package com.nonlinearfruit.creeds.main;

import com.nonlinearfruit.creeds.apostlescreed.ApostlesCreedActivity;
import com.nonlinearfruit.creeds.athanasiancreed.AthanasianCreedActivity;
import com.nonlinearfruit.creeds.chalcedoniancreed.ChalcedonianCreedActivity;
import com.nonlinearfruit.creeds.firstcatechism.FirstCatechismActivity;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;
import com.nonlinearfruit.creeds.nicenecreed.NiceneCreedActivity;

import java.util.ArrayList;
import java.util.List;

public class MainDatabase {

    private List<MainMenuItem> items = new ArrayList<MainMenuItem>(){{
        add(new MainMenuItem(){{
            CreedTitle = "First Catechism";
            CreedYear = 1996;
            CreedOrigin = "Copyright 2003 - Great Commission Publications, Inc";
            IntentClass = FirstCatechismActivity.class;
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
    }};

    public List<MainMenuItem> getMainMenuItems() {
        return items;
    }
}
