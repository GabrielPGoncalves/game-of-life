package core;

public class LifeSimulator {

    private final LifeGrid lifeGrid;

    public LifeSimulator(LifeGrid grid) {
        this.lifeGrid = grid;
    }

    public void iterate(){
        LifeCell[][] grid = lifeGrid.getGrid();
        int gridSize = lifeGrid.getGridSize();

        for(int  i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                int neighborQuantity = getNeighborQuantity(i, j);

                if(grid[i][j] == null && neighborQuantity == 3){
                    grid[i][j] = new LifeCell(i, j);
                } else if (grid[i][j] != null && (neighborQuantity > 3 || neighborQuantity < 2)) {
                    grid[i][j] = null;
                }
            }
        }

    }

    private int getNeighborQuantity(int row, int col){
        LifeCell[][] grid = lifeGrid.getGrid();
        int size = lifeGrid.getGridSize();

        int aliveCells = 0;

        if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] != null) {
            aliveCells++;
        }
        if (row - 1 >= 0 && grid[row - 1][col] != null) {
            aliveCells++;
        }
        if (row - 1 >= 0 && col + 1 < size && grid[row - 1][col + 1] != null) {
            aliveCells++;
        }
        if (col - 1 >= 0 && grid[row][col - 1] != null) {
            aliveCells++;
        }
        if (col + 1 < size && grid[row][col + 1] != null) {
            aliveCells++;
        }
        if (row + 1 < size && col - 1 >= 0 && grid[row + 1][col - 1] != null) {
            aliveCells++;
        }
        if (row + 1 < size && grid[row + 1][col] != null) {
            aliveCells++;
        }
        if (row + 1 < size && col + 1 < size && grid[row + 1][col + 1] != null) {
            aliveCells++;
        }

        return aliveCells;
    }

}
