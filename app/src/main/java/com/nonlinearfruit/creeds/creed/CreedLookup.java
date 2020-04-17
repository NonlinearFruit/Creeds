package com.nonlinearfruit.creeds.creed;

public enum CreedLookup {
    ShemaYisrael(0),
    ConfessionOfPeter(1),
    ChristHymnOfPhilippians(2),
    ChristHymnOfColossians(3),
    ApostlesCreed(4),
    NiceneCreed(5),
    ChalcedonianDefinition(6),
    AthanasianCreed(7);

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
