package com.simulator;

public class PlayerConnection {
    
    private Player p1;
    private Player p2;
    Relationship relationship;
    int priority;

    public enum Relationship{ExtremeHatred, StrongDislike, MediumDislike, MildDislike, SlightDislike,
                            Neutral, SlightBond, SmallBond, MediumBond, StrongBond, Unbreakable}

    public PlayerConnection(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.relationship = Relationship.Neutral;
        priority = 0;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    
}
