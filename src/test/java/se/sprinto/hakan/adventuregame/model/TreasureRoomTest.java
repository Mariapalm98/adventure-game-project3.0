package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class TreasureRoomTest {

    @Test
    public void enterRoom() {
        //spelaren har hittat nyckel och kistan öppnas
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player.Builder()
                .foundKey(true)
                .build();

        TreasureRoom treasureRoom = new TreasureRoom();

        treasureRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasOpenedChest(), "Player opened chest");

//        if (player.hasOpenedChest()){
//            System.out.println("Kista öppnad");
//        }
//        else {
//            System.out.println("Kista stängd");
//        }
    }
}