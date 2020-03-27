package com.nonlinearfruit.creeds.westminsterconfessionoffaith.models;

import com.nonlinearfruit.creeds.catechism.models.ProofText;

import java.util.List;

public class Chapter {
    public String Title;
    public Integer Chapter;
    public List<Section> Sections;
    public List<ProofText> Proofs;
    public List<ProofText> ProofsWithScripture;
}
