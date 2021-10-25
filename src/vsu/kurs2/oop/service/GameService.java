package vsu.kurs2.oop.service;

import vsu.kurs2.oop.model.*;

import java.util.List;

public class GameService {
    private int sizeDesk;
    private Game game;

    public Game createGame(List<Player> players, int sizeDesk) {
        game = new Game(sizeDesk);
        DeskService deskService1 = new DeskService(sizeDesk);
        DeskService deskService2 = new DeskService(sizeDesk);
        addDesk(deskService1.getDesk());
        addDesk(deskService2.getDesk());
        viewOut(deskService1, deskService2);

        return null;
    }

    public GameService(List<Player> playerList, int sizeDesk) {
        this.sizeDesk = sizeDesk;
        createGame(playerList, sizeDesk);
    }

    public void addDesk(Desk desk) {
        List<Desk> deskList = game.getDeskList();
        deskList.add(desk);
        game.setDeskList(deskList);
    }

    public void playGame(int stepCount) {
    }

    public void viewOut(DeskService deskService1, DeskService deskService2) {
        Cell cell = new Cell(-1,-1);
        System.out.print(0 + " ");
        for (int i = 0; i < sizeDesk; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.print("          ");
        System.out.printf("%2d ", 0);
        for (int i = 0; i < sizeDesk; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < sizeDesk; i++) {

            System.out.print(i + " ");
            for (int j = 0; j < sizeDesk; j++) {
                cell.setX(j);
                cell.setY(i);
                if(deskService1.contains(cell)) {
                    cell = deskService1.getCell(j, i);

                    System.out.printf("%2s ", cell.view());
                    cell = new Cell(-1, -1);
                }else{
                    System.out.printf("%2s ", cell.view());
                }

            }
            System.out.print("          ");
            System.out.printf("%2d ", i);
            for (int j = 0; j < sizeDesk; j++) {
                cell.setX(j);
                cell.setY(i);
                if(deskService2.contains(cell)) {
                    cell = deskService2.getCell(j, i);

                    System.out.printf("%2s ", cell.view());
                    cell = new Cell(-1, -1);
                }else{
                    System.out.printf("%2s ", cell.view());
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
