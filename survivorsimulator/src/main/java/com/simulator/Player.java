package com.simulator;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    HashMap<Attribute, Integer> attributeMap;
    ArrayList<PlayerConnection> relationships;
    int threatPoints;

    public enum Attribute {Physical, Endurance, Mental, Stamina, SocialSkills, Tempermant,
                            Strategic, Loyalty, Forgivingness, Boldness, Influence, Intuition}
    
    public Player(ArrayList<Integer> attributeValues) {
        for (Attribute currAtr : Attribute.values()) {
            attributeMap.put(currAtr, attributeValues.get(currAtr.ordinal()));
        }

        relationships = new ArrayList<PlayerConnection>();
        threatPoints = 0;
    }
    
    public int getAttribute(Attribute search) {
        return attributeMap.get(search);
    }   

    public void generateConnections(ArrayList<Player> allPlayers) {
        for(Player currPlayer: allPlayers) {
            if(currPlayer != this && getConnection(this, currPlayer) != null){
                PlayerConnection newConnect = new PlayerConnection(this, currPlayer);
                this.addConnection(newConnect);
                currPlayer.addConnection(newConnect);
            }
        }
    }

    private PlayerConnection getConnection(Player p1, Player p2) {
        for(PlayerConnection connection : relationships) {
            if (connection.getP1() == p1 && connection.getP2() == p2 || connection.getP1() == p2 && connection.getP2() == p1) return connection;
        }
        return null;
    }

    public void addConnection(PlayerConnection connection) {
        relationships.add(connection);
    }

    public void increaseThreat() {
        threatPoints++;
    }

    public void increaseThreat(int inc) {
        threatPoints += inc;
    }
}
