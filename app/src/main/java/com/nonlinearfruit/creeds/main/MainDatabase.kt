package com.nonlinearfruit.creeds.main

import com.nonlinearfruit.creeds.R
import com.nonlinearfruit.creeds.canon.CanonActivity
import com.nonlinearfruit.creeds.catechism.CatechismActivity
import com.nonlinearfruit.creeds.creed.CreedActivity
import com.nonlinearfruit.creeds.creed.CreedLookup
import com.nonlinearfruit.creeds.henryscatechism.HenrysCatechismActivity
import com.nonlinearfruit.creeds.main.models.MainMenuItem
import com.nonlinearfruit.creeds.confession.ConfessionActivity

class MainDatabase {

        val mainMenuItems: List<MainMenuItem> = listOf(
                //MainMenuItem(
                        //"First Catechism",
                        //1996,
                        //"Copyright 2003 - Great Commission Publications, Inc",
                        //CatechismActivity::class.java,
                        //R.raw.first_catechism
                //),
                MainMenuItem(
                        "Chicago Statement on Biblical Inerrancy",
                        1978,
                        "Copyright 1978 - International Council on Biblical Inerrancy",
                        CanonActivity::class.java,
                        R.raw.chicago_statement_on_biblical_inerrancy
                ),
                MainMenuItem(
                        "Abstract of Principles",
                        1858,
                        "",
                        CanonActivity::class.java,
                        R.raw.abstract_of_principles
                ),
                MainMenuItem(
                        "Puritan Catechism",
                        1855,
                        "",
                        CatechismActivity::class.java,
                        R.raw.puritan_catechism
                ),
                MainMenuItem(
                        "Matthew Henry's Scripture Catechism",
                        1714,
                        "",
                        HenrysCatechismActivity::class.java,
                        R.raw.matthew_henrys_scripture_catechism
                ),
                MainMenuItem(
                        "London Baptist 1689 Confession of Faith",
                        1689,
                        "",
                        ConfessionActivity::class.java,
                        R.raw.london_baptist_1689
                ),
                MainMenuItem(
                        "Keach's Catechism",
                        1677,
                        "",
                        CatechismActivity::class.java,
                        R.raw.keachs_catechism
                ),
                MainMenuItem(
                        "Westminster Shorter Catechism",
                        1647,
                        "",
                        CatechismActivity::class.java,
                        R.raw.westminster_shorter_catechism
                ),
                MainMenuItem(
                        "Westminster Larger Catechism",
                        1647,
                        "",
                        CatechismActivity::class.java,
                        R.raw.westminster_larger_catechism
                ),
                MainMenuItem(
                        "Westminster Confession of Faith",
                        1647,
                        "",
                        ConfessionActivity::class.java,
                        R.raw.westminster_confession_of_faith
                ),
                MainMenuItem(
                        "Canons of Dort",
                        1619,
                        "",
                        ConfessionActivity::class.java,
                        R.raw.canons_of_dort
                ),
                MainMenuItem(
                        "Heidelberg Catechism",
                        1563,
                        "",
                        CatechismActivity::class.java,
                        R.raw.heidelberg_catechism
                ),
                MainMenuItem(
                        "Second Helvetic Confession",
                        1562,
                        "",
                        ConfessionActivity::class.java,
                        R.raw.second_helvetic_confession
                ),
                MainMenuItem(
                        "Belgic Confession of Faith",
                        1561,
                        "",
                        CanonActivity::class.java,
                        R.raw.belgic_confession_of_faith
                ),
                MainMenuItem(
                        "Scots Confession",
                        1560,
                        "",
                        CanonActivity::class.java,
                        R.raw.scots_confession
                ),
                MainMenuItem(
                        "French Confession of Faith",
                        1559,
                        "",
                        CanonActivity::class.java,
                        R.raw.french_confession_of_faith
                ),
                MainMenuItem(
                        "Tetrapolitan Confession",
                        1530,
                        "",
                        CanonActivity::class.java,
                        R.raw.tetrapolitan_confession
                ),
                MainMenuItem(
                        "Ten Theses of Berne",
                        1528,
                        "",
                        CanonActivity::class.java,
                        R.raw.zwinglis_67_articles
                ),
                MainMenuItem(
                        "Zwingli's 67 Articles",
                        1523,
                        "",
                        CanonActivity::class.java,
                        R.raw.zwinglis_67_articles
                ),
                MainMenuItem(
                        "Athanasian Creed",
                        800,
                        "The oldest surviving manuscripts of the Athanasian Creed date from the late 8th century",
                        CreedActivity::class.java,
                        CreedLookup.AthanasianCreed.Id
                ),
                MainMenuItem(
                        "Apostles' Creed",
                        710,
                        "De singulis libris canonicis scarapsus ('Excerpt from Individual Canonical Books') of St. Pirminius (Migne, Patrologia Latina 89, 1029 ff.), written between 710 and 714.",
                        CreedActivity::class.java,
                        CreedLookup.ApostlesCreed.Id
                ),
                MainMenuItem(
                        "Council of Orange",
                        529,
                        "",
                        CanonActivity::class.java,
                        R.raw.council_of_orange
                ),
                MainMenuItem(
                        "Chalcedonian Definition",
                        451,
                        "Adopted at the Council of Chalcedon in AD 451",
                        CreedActivity::class.java,
                        CreedLookup.ChalcedonianDefinition.Id
                ),
                MainMenuItem(
                        "Nicene Creed",
                        381,
                        "Adopted at the Second Ecumenical Council held in Constantinople in 381 as a modification of the original Nicene Creed of 325",
                        CreedActivity::class.java,
                        CreedLookup.NiceneCreed.Id
                ),
                MainMenuItem(
                        "Irenaeus' Rule of Faith",
                        180,
                        "Irenaeus, Adversus Haereses",
                        CreedActivity::class.java,
                        CreedLookup.IrenaeusRuleOfFaith.Id
                ),
                MainMenuItem(
                        "The Christ Hymn of Philippians",
                        60,
                        "Philippians 2:6-11",
                        CreedActivity::class.java,
                        CreedLookup.ChristHymnOfPhilippians.Id
                ),
                MainMenuItem(
                        "The Christ Hymn of Colossians",
                        60,
                        "Colossians 1:15-20",
                        CreedActivity::class.java,
                        CreedLookup.ChristHymnOfColossians.Id
                ),
                MainMenuItem(
                        "Confession of Peter",
                        30,
                        "Matthew 16:16",
                        CreedActivity::class.java,
                        CreedLookup.ConfessionOfPeter.Id
                ),
                MainMenuItem(
                        "Shema Yisrael",
                        -1500,
                        "Deuteronomy 6:4",
                        CreedActivity::class.java,
                        CreedLookup.ShemaYisrael.Id
                ))
}
