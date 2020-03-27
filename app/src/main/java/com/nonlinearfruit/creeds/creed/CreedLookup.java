package com.nonlinearfruit.creeds.creed;

public enum CreedLookup {
    ShemaYisrael(0),
    ConfessionOfPeter(1),
    ApostlesCreed(2),
    NiceneCreed(3),
    ChalcedonianDefinition(4),
    AthanasianCreed(5);

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
