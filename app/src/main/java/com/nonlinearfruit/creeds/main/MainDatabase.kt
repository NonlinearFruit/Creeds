package com.nonlinearfruit.creeds.main

import com.nonlinearfruit.creeds.R
import com.nonlinearfruit.creeds.canon.CanonActivity
import com.nonlinearfruit.creeds.catechism.CatechismActivity
import com.nonlinearfruit.creeds.creed.CreedActivity
import com.nonlinearfruit.creeds.henryscatechism.HenrysCatechismActivity
import com.nonlinearfruit.creeds.main.models.MainMenuItem
import com.nonlinearfruit.creeds.confession.ConfessionActivity

class MainDatabase {

        val mainMenuItems: List<MainMenuItem> = listOf(
MainMenuItem( "Abstract of Principles", 1858, "", CanonActivity::class.java, R.raw.abstract_of_principles),
MainMenuItem( "Apostles' Creed", 710, "", CreedActivity::class.java, R.raw.apostles_creed),
MainMenuItem( "Athanasian Creed", 800, "", CreedActivity::class.java, R.raw.athanasian_creed),
MainMenuItem( "Belgic Confession", 1561, "", CanonActivity::class.java, R.raw.belgic_confession_of_faith),
MainMenuItem( "Canons of Dort", 1619, "", ConfessionActivity::class.java, R.raw.canons_of_dort),
MainMenuItem( "Catechism For Young Children", 1840, "", CatechismActivity::class.java, R.raw.catechism_for_young_children),
MainMenuItem( "Chalcedonian Definition", 451, "", CreedActivity::class.java, R.raw.chalcedonian_definition),
MainMenuItem( "Chicago Statement on Biblical Inerrancy", 1978, "", CanonActivity::class.java, R.raw.chicago_statement_on_biblical_inerrancy),
MainMenuItem( "Christ Hymn of Colossians", 60, "", CreedActivity::class.java, R.raw.christ_hymn_of_colossians),
MainMenuItem( "Christ Hymn of Philippians", 60, "", CreedActivity::class.java, R.raw.christ_hymn_of_philippians),
MainMenuItem( "Confession of Peter", 30, "", CreedActivity::class.java, R.raw.confession_of_peter),
MainMenuItem( "Consensus Tigurinus", 1549, "", CanonActivity::class.java, R.raw.consensus_tigurinus),
MainMenuItem( "Council of Orange", 529, "", CanonActivity::class.java, R.raw.council_of_orange),
MainMenuItem( "First Catechism", 1996, "", CatechismActivity::class.java, R.raw.first_catechism),
MainMenuItem( "First Confession of Basel", 1534, "", CanonActivity::class.java, R.raw.first_confession_of_basel),
MainMenuItem( "First Helvetic Confession", 1536, "", CanonActivity::class.java, R.raw.first_helvetic_confession),
MainMenuItem( "French Confession of Faith", 1559, "", CanonActivity::class.java, R.raw.french_confession_of_faith),
MainMenuItem( "Heidelberg Catechism", 1563, "", CatechismActivity::class.java, R.raw.heidelberg_catechism),
MainMenuItem( "Helvetic Consensus", 1675, "", CanonActivity::class.java, R.raw.helvetic_consensus),
MainMenuItem( "Irenaeus' Rule of Faith", 180, "", CreedActivity::class.java, R.raw.irenaeus_rule_of_faith),
MainMenuItem( "Keach's Catechism", 1693, "", CatechismActivity::class.java, R.raw.keachs_catechism),
MainMenuItem( "1689 London Baptist Confession", 1677, "", ConfessionActivity::class.java, R.raw.london_baptist_1689),
MainMenuItem( "Matthew Henry's Scripture Catechism", 1703, "", HenrysCatechismActivity::class.java, R.raw.matthew_henrys_scripture_catechism),
MainMenuItem( "Nicene Creed", 381, "", CreedActivity::class.java, R.raw.nicene_creed),
MainMenuItem( "Puritan Catechism", 1855, "", CatechismActivity::class.java, R.raw.puritan_catechism),
MainMenuItem( "Scots Confession", 1560, "", CanonActivity::class.java, R.raw.scots_confession),
MainMenuItem( "Second Helvetic Confession", 1562, "", ConfessionActivity::class.java, R.raw.second_helvetic_confession),
MainMenuItem( "Shema Yisrael", -1500, "", CreedActivity::class.java, R.raw.shema_yisrael),
MainMenuItem( "Ten Theses of Berne", 1528, "", CanonActivity::class.java, R.raw.ten_theses_of_berne),
MainMenuItem( "Tetrapolitan Confession", 1530, "", CanonActivity::class.java, R.raw.tetrapolitan_confession),
MainMenuItem( "Waldensian Confession", 1120, "", CanonActivity::class.java, R.raw.waldensian_confession),
MainMenuItem( "Westminster Confession of Faith", 1646, "", ConfessionActivity::class.java, R.raw.westminster_confession_of_faith),
MainMenuItem( "Westminster Larger Catechism", 1647, "", CatechismActivity::class.java, R.raw.westminster_larger_catechism),
MainMenuItem( "Westminster Shorter Catechism", 1647, "", CatechismActivity::class.java, R.raw.westminster_shorter_catechism),
MainMenuItem( "Zwingli's 67 Articles", 1523, "", CanonActivity::class.java, R.raw.zwinglis_67_articles)
)}
