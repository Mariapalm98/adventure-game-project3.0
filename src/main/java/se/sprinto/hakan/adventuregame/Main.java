package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.view.AppInfo;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        //ui.showMessage("Version 1.0 av Håkan Gleissman");

        //kallar appinfp som läser upp från app.profitie file
        AppInfo appInfo = AppInfo.getInstance();

        String author = appInfo.getProperty("app.author");
        String version = appInfo.getProperty("app.version");

        ui.showMessage("Version: " + version + " av " + author);

        //Builder
        String name = ui.getInput("Ange ditt namn");
        Player player = new Player.Builder()
                .name(name)
                .health(100)
                .score(0)
                .strength(10)
                .build();

        //gamla innan builder
        //Player player = new Player(name, 100, 0, 10);

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

