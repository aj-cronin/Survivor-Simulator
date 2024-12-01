package com.simulator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameTests {
    
    static ArrayList<Integer> playerAttributes;
    static{
        playerAttributes = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) playerAttributes.add(0);
    }
    Player p1 = new Player(playerAttributes);

    @Test
	void testGetTitle() {
		assertEquals(p1.getAttribute(Player.Attribute.Physical), 0);
	}
}
