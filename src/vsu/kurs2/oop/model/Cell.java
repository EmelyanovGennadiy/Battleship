package vsu.kurs2.oop.model;

import java.util.Objects;


public class Cell {
    private CellState cellState;
    private int x;

    private int y;
    private Ship root;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellState = CellState.EMPTY_STATE;
    }

    public Cell(int x, int y, Ship ship) {
        this.x = x;
        this.y = y;
        root = ship;
        cellState = CellState.BUSY_STATE;
    }

    public Ship getShip() {
        return root;
    }

    public String view() {
        return switch (cellState) {
            case EMPTY_STATE -> "▢";
            case BUSY_STATE -> root.getShipType().getViewShip();

            case PADDED_STATE -> "✖";
        };
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return (x == cell.getX()) && (y == cell.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
