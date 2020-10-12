package main;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    Status status;
    List<Cell> near;

    public Cell(){
        status = Status.NONE;
        near = new ArrayList<>();
    }

    void addNear(Cell cell) {
        near.add(cell);
    }

    void step1() {
        int around = countNearCells();
        status = status.step1(around);
    }

    void step2() {
        status = status.step2();
    }

    int countNearCells() {
        int count = 0;
        for (Cell cell : near) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    void turn() {
        for (Cell cell : near) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
