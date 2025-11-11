package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.*;

class ForestRoomTest {
    @Test
    public void enterRoom() {
        //undersöker glittret och hittar nyckeln
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player.Builder()
                .build();


        ForestRoom forestRoom = new ForestRoom();

        forestRoom.enterRoom(player,  fakeUI);

        assertTrue(player.hasFoundKey(), "Player har hittat nyckel");

    }
}