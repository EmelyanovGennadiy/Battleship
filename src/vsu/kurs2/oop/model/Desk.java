package vsu.kurs2.oop.model;

import vsu.kurs2.oop.service.DeskService;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private int size;
    private DeskService deskService;
    private Player player;
    private List<Ship> playerShips = new ArrayList<>();

    public Desk(int size, DeskService deskService) {
        this.deskService = deskService;
        this.size = size;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public DeskService getDeskService() {
        return deskService;
    }
    public int getSize() {
        return size;
    }
}
