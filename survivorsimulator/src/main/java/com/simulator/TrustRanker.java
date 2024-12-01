package com.simulator;

import java.util.Comparator;

public class TrustRanker implements Comparator<PlayerConnection>{
    public int compare(PlayerConnection c1, PlayerConnection c2) {
        if(c1.getRelationship() != c2.getRelationship()) return c1.getRelationship().compareTo(c2.getRelationship());
        return c1.getPriority() - c2.getPriority();
    }
}
