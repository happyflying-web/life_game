//test code
public class Cell {
    private int maxLength;
    private int maxWidth;
    private int nowGeneration;
    public int[][] grid; //一个数据代表一个细胞,0代表死，1代表活

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Cell(int maxLength, int maxWidth) {
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
        nowGeneration = 0;
        grid = new int[maxLength + 2][maxWidth + 2];
        for (int i = 0; i <= maxLength + 1; i++) {
            for (int j = 0; j <= maxWidth + 1; j++)
                grid[i][j] = 0;
        }
    }

    //用已有的数组对地图进行初始化
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    //返回地图所对应的数组
    public int[][] getGrid() {
        return grid;
    }

    //设置代数
    public void setNowGeneration(int nowGeneration){
        this.nowGeneration = nowGeneration;
    }

    //返回现在细胞的代数
    public int getNowGeneration(){
        return nowGeneration;
    }

    //随机初始化细胞
    public void randomCell() {
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = Math.random()>0.5?1:0;
    }

    //细胞清零
    public void deleteAllCell(){
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = 0;
    }

    //繁衍
    public void update() {
        int[][] newGrid = new int[maxLength + 2][maxWidth + 2];
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                switch (getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //细胞状态保持不变
                        break;
                    case 3:
                        newGrid[i][j] = 1; // Cell is alive.
                        break;
                    default:
                        newGrid[i][j] = 0; // Cell is dead.
                }
            /*{
                if(getNeighborCount(i, j)==2)
                    newGrid[i][j] = grid[i][j];
                else if(getNeighborCount(i, j)==3)
                    newGrid[i][j] = 1;
                else  newGrid[i][j] = 0;
            }*/
//        for (int i = 1; i <= maxLength+1; i++)
//           for (int j = 1; j <= maxWidth+1; j++)
//                grid[i][j] = newGrid[i][j];
       // grid=newGrid;
        nowGeneration++;
    }

    //获取细胞的邻居数量
    public int getNeighborCount(int i1, int j1) {
        int count = 0;
        for (int i = i1 - 1; i <= i1 + 1; i++)
            for (int j = j1 - 1; j <= j1 + 1; j++)
                count += grid[i][j]; //如果邻居还活着，邻居数便会+1
        count -= grid[i1][j1]; //每个细胞不是自己的邻居，则如果细胞还活着，邻居数-1.

        return count;
    }
}