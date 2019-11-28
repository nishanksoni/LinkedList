public class NumberOfIslands {
    private int row;
    private int column;

    public int numIslands(int[][] grid) {
        int count = 0;
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }


    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        int i = new NumberOfIslands().numIslands(M);
        System.out.println(i);
    }
}
