package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.*;

class DungeonRoomTest {

    @Test
    public void enterRoom() {
        //player besegrar enemy

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        Player player = new Player.Builder()
                .health(100)
                .strength(30)
                .build();

        DungeonRoom dungeonRoom = new DungeonRoom();

        dungeonRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasDefeatedEnemy(), "Player vunnit över enemy");
    }
}