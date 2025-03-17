package core;

import java.util.*;

public class LifeGrid {

    private final int gridSize;
    private final LifeCell[][] grid;

    public LifeGrid(int size) {
        this.gridSize = size;
        grid = new LifeCell[gridSize][gridSize];
    }

    public LifeGrid() {
        this(15);
    }

    public void randomizeGrid(){
        Random rand = new Random();

        int cellNum = rand.nextInt(0, (gridSize * (gridSize/2)));

        for(int i = 0; i < cellNum; i++){
            int x = rand.nextInt(0, gridSize);
            int y = rand.nextInt(0, gridSize);

            if(grid[x][y] != null){
                i--;
                continue;
            }

            LifeCell cell = new LifeCell(x, y);
            grid[x][y] = cell;
        }
    }

    public List<LifeCell> getCells(){
        List<LifeCell> cells = new ArrayList<>();

        for(int i = 0; i < gridSize; i++){
            List<LifeCell> rows = Arrays.stream(grid[i])
                    .filter(Objects::nonNull)
                    .toList();

            cells.addAll(rows);
        }

        return cells;
    }

    public int getGridSize(){
        return gridSize;
    }

    public LifeCell[][] getGrid(){
        return grid;
    }
}
