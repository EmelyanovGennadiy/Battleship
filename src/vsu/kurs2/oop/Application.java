package vsu.kurs2.oop;

import vsu.kurs2.oop.model.Game;
import vsu.kurs2.oop.model.Player;
import vsu.kurs2.oop.service.GameService;

import java.util.List;

public class Application {
    public static void main(String args[]){
        List<Player> playerList = List.of(new Player(), new Player());
        GameService gameService = new GameService(playerList, 10);
        gameService.playGame(100);
    }
}
