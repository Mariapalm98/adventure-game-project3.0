package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    public void attack() {
        //enemy har förlorat health av player strength
        Player player = new Player.Builder()
                .name("Player")
                .strength(100)
                .health(100)
                .build();

        Enemy enemy = new Enemy("Enemy",30,10,10);

        int expectedHealth = enemy.getHealth() - player.getStrength();
        if (expectedHealth < 0) {
            expectedHealth = 0;
        }

        player.attack(enemy);

        assertEquals(expectedHealth, enemy.getHealth());

    }
}