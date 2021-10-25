package vsu.kurs2.oop.model;

public enum ShipType {

    FOUR_DECK(1, "▦", 4),
    THREE_DECK(2, "▦", 3),
    DOUBLE_DECK(3, "▦", 2),
    SINGLE_DECK(4, "▦", 1),
    MINESWEEPER(1, "✚", 1),
    MINE(2, "◉", 1),
    UBOOT(1, "▣", 1);
    private final int sizeShip;
    private final String viewShip;
    private final int valueShip;

    ShipType(int valueShip, String viewShip, int sizeShip) {
        this.valueShip = valueShip;
        this.viewShip = viewShip;
        this.sizeShip = sizeShip;
    }

    public int getSizeShip() {
        return sizeShip;
    }

    public int getValueShip() {
        return valueShip;
    }

    public String getViewShip() {
        return viewShip;
    }
}
