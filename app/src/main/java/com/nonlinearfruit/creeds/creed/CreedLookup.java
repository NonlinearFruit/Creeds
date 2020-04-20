package com.nonlinearfruit.creeds.creed;

public enum CreedLookup {
    ShemaYisrael(0),
    ConfessionOfPeter(1),
    ChristHymnOfPhilippians(2),
    ChristHymnOfColossians(3),
    IrenaeusRuleOfFaith(4),
    ApostlesCreed(5),
    NiceneCreed(6),
    ChalcedonianDefinition(7),
    AthanasianCreed(8);

    public static CreedLookup get(int id) {
        for (CreedLookup lookup : CreedLookup.values())
            if (lookup.Id == id)
                return lookup;
        throw new RuntimeException("No CreedLookup for id:"+id);
    }

    public int Id;

    CreedLookup(int id){
        this.Id = id;
    }
}
