package vsu.kurs2.oop.service;

import vsu.kurs2.oop.model.*;

import java.util.*;

public class ShipService {

    private Ship ship;
    private final Map<Integer, Cell> vec = new HashMap<>();
    private DeskService deskService;
    private List<Cell> cellList = new ArrayList<>();
    private int sizeDesk;
    private List<Cell> shipCells = new ArrayList<>();

    private void createVec() {
        Cell cell = new Cell(0, -1);
        vec.put(0, cell);
        cell = new Cell(1, 0);
        vec.put(1, cell);
        cell = new Cell(0, 1);
        vec.put(2, cell);
        cell = new Cell(-1, 0);
        vec.put(3, cell);
    }

    private Cell getVec(int index) {
        return vec.get(index);
    }

    private void createCellList() {
        Cell cell;
        for (int i = 0; i < sizeDesk; i++) {
            for (int j = 0; j < sizeDesk; j++) {
                cell = new Cell(j, i);
                cellList.add(cell);
            }
        }
    }

    public ShipService(DeskService deskService) {
        this.deskService = deskService;
        this.sizeDesk = deskService.getSizeDesk();
        createVec();
        createCellList();
    }

    public void setShip(ShipType shiptype) {
        Ship ship = new Ship(shiptype);
        this.ship = ship;
        List<Integer> vecs = new ArrayList<>();
        Random rnd = new Random();
        int vec = -1;
        int sizeShip = ship.getSize();
        int num = -1;
        int cellInd = -1;
        int x, y;
        Cell cell;
        boolean created = false;
        while (!created) {
            for (int i = 0; i < 4; i++) {
                vecs.add(i);
            }
            cellInd = rnd.nextInt(cellList.size());
            cell = cellList.get(cellInd);
            x = cell.getX();
            y = cell.getY();
            cellList.remove(cellInd);
            while (!created && vecs.size() != 0) {
                num = rnd.nextInt(vecs.size());
                vec = vecs.get(num);

                if (canSet(x, y, vec, sizeShip)) {
                    if (createShip(x, y, vec, sizeShip))
                        created = true;
                }
                vecs.remove(num);
            }
            vecs.clear();

        }
        ship.setBody(shipCells);
        deskService.addShip(ship);
        shipCells = new ArrayList<>();
    }


    private boolean canSet(int x, int y, int vec, int size) {

        int vecX = getVec(vec).getX();
        int vecY = getVec(vec).getY();
        boolean flag = false;
        Cell cell = new Cell(x + vecX, y + vecY);
        if (cellList.contains(cell)) {
            flag = true;
        }
        if(size == 1){
            removeCells(x,y);
            return true;
        }
        if (flag && canSet(x + vecX, y + vecY, vec, size - 1)) {
            removeCells(x, y);
            return true;
        } else {
            return false;
        }
    }
    private void removeCells(int x, int y){
        int index = 0;
        Cell cell = new Cell(x, y);
        int[] shifts = {1, 0, -1};
        for (int dx : shifts) {
            for (int dy : shifts) {
                cell.setX(x + dx);
                cell.setY(y + dy);
                if (cellList.contains(cell)) {
                    index = cellList.indexOf(cell);
                    cellList.remove(index);
                }
            }
        }
    }

    private boolean createShip(int x, int y, Integer vec, int size) {
        Cell cell = new Cell(x, y, ship);
        shipCells.add(cell);
        size--;
        if (size == 0) {
            return true;
        }
        x += this.vec.get(vec).getX();
        y += this.vec.get(vec).getY();
        return createShip(x, y, vec, size);

    }

}


