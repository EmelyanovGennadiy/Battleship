package vsu.kurs2.oop.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int deskSize;
    private List<Desk> deskList = new ArrayList<>();
    private List<Player> playerList = new ArrayList<>();

    public Game(int deskSize) {
        this.deskSize = deskSize;

    }

    public List<Desk> getDeskList() {
        return deskList;
    }

    public void setDeskList(List<Desk> deskList) {
        this.deskList = deskList;
    }
}
