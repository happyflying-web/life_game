import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.BorderUIResource;

import static org.junit.Assert.*;

public class CellTest {
    private static Cell cell=new Cell(35,20);
    int [][]testgrid = new int[cell.getMaxLength() + 2][cell.getMaxWidth() + 2];

    @Before
    public void setUp() throws Exception {
        cell.deleteAllCell();
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++)
                testgrid[i][j] = 0;
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setGrid() {
        cell.setGrid(testgrid);
        boolean tag = true;
        int[][] test = cell.getGrid();//test==grid
        int [][]termgrid = new int[cell.getMaxLength() + 2][cell.getMaxWidth() + 2];
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++)
                termgrid[i][j] = testgrid[i][j];
        }
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++) {
                if (test[i][j] != termgrid[i][j]){
                    tag = false;
                    break;
                }

            }
        }
        assertEquals(true, tag);
    }

    @Test
    public void getGrid() {
        cell.setGrid(testgrid);
        boolean tag = true;
        int[][] test = cell.getGrid();//test==grid
        int [][]termgrid = new int[cell.getMaxLength() + 2][cell.getMaxWidth() + 2];
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++)
                termgrid[i][j] = testgrid[i][j];
        }
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++) {
                if (test[i][j] != termgrid[i][j]){
                    tag = false;
                    break;
                }

            }
        }
        assertEquals(true, tag);
    }

    @Test
    public void setNowGeneration() {
        int generation=10;
        cell.setNowGeneration(generation);
        assertEquals(generation,cell.getNowGeneration());
    }

    @Test
    public void getNowGeneration() {
        int generation=10;
        cell.setNowGeneration(generation);
        assertEquals(generation,cell.getNowGeneration());
    }


    @Test
    public void deleteAllCell() {
        cell.deleteAllCell();
        boolean tag=true;
        for (int i = 0; i <= cell.getMaxLength() + 1; i++) {
            for (int j = 0; j <= cell.getMaxWidth() + 1; j++) {
                if (cell.grid[i][j] != 0)
                    tag = false;
                break;
            }
        }
        assertEquals(true, tag);
    }

    @Test
    public void update() {
        cell.grid[2][3]=cell.grid[3][4]=cell.grid[4][4]=1;
        cell.update();
        int term=cell.grid[3][3];
        assertEquals(1,term);
    }

    @Test
    public void getNeighborCount() {
        cell.grid[2][3]=cell.grid[3][4]=cell.grid[4][4]=1;
        int term=cell.getNeighborCount(3,3);
        assertEquals(3,term);

    }
}