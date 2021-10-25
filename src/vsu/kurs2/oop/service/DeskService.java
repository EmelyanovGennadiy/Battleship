package vsu.kurs2.oop.service;

import vsu.kurs2.oop.model.Cell;
import vsu.kurs2.oop.model.Desk;
import vsu.kurs2.oop.model.Ship;
import vsu.kurs2.oop.model.ShipType;

import java.util.List;

public class DeskService {
    private Desk desk;
    private int sizeDesk;
    private ShipService shipService;

    public DeskService(int sizeDesk) {
        setSizeDesk(sizeDesk);
        createDesk();
        createShipService();
        createShips();

    }

    public void createShipService() {
        shipService = new ShipService(this);
    }

    private void createDesk() {
        desk = new Desk(sizeDesk, this);
    }

    private void setDesk(Desk desk) {
        this.desk = desk;
    }

    private void setSizeDesk(int sizeDesk) {
        this.sizeDesk = sizeDesk;
    }

    private void createShips() {
        for (ShipType shipType : ShipType.values()) {
            for (int i = 0; i < shipType.getValueShip(); i++) {
                shipService.setShip(shipType);
            }
        }
    }

    public boolean contains(Cell cell) {
        for (Ship ship : desk.getPlayerShips()) {
            if (ship.contains(cell)) {
                return true;
            }
        }
        return false;
    }

    public Cell getCell(int x, int y) {
        Cell cell = new Cell(x, y);
        for (Ship ship : desk.getPlayerShips()) {
            if (ship.contains(cell)) {
                return ship.getCell(cell);
            }
        }
        return null;
    }


    public void addShip(Ship ship) {
        desk.getPlayerShips().add(ship);
    }

    public int getSizeDesk() {
        return sizeDesk;
    }

    public Desk getDesk() {
        return desk;
    }
}
