package vsu.kurs2.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {

    private final ShipType shipType;
    private int size;
    private List<Cell> body = new ArrayList<>();


    public ShipType getShipType() {
        return shipType;
    }

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        setSize(shipType.getSizeShip());
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void setBody(List<Cell> cellList) {
        body = cellList;
    }

    public List<Cell> getBody() {
        return body;
    }
    public Cell getCell(Cell cell){
        return body.get(body.indexOf(cell));
    }
    public boolean contains(Cell cell) {
        return body.contains(cell);
    }
}
