public class maze {
    
  //  https://leetcode.com/problems/minimum-path-sum/
    public static int minPathSum(int[][] grid)
    {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPathSum_(grid,0,0,grid.length-1,grid[0].length-1,dp);
    }

    public static int minPathSum_(int[][] grid,int sr,int sc,int dr,int dc,int[][] dp)
    {
        if(sr == dr && sc == dc)
        {
            return grid[sr][sc];
        }
        if(sr<0 || sr>dr || sc<0 || sc>dc)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }
        int f1 = minPathSum_(grid,sr,sc+1,dr,dc,dp);           // h
        int f2 = minPathSum_(grid,sr+1,sc,dr,dc,dp);           // v
        return dp[sr][sc] = grid[sr][sc]+Math.min(f1,f2);

    }

    public static int minPathSum_memo(int[][] grid,int[][] dp)
    {
         for(int row = grid.length - 1;row>=0;row--)
         {
             for(int col = grid[0].length - 1;col>=0;col --)
             {
                 if(row == grid.length - 1 && col == grid[0].length - 1)
                 {
                     dp[row][col] = grid[row][col];
                 }
                 else if(row == grid.length - 1)
                 {
                     dp[row][col] =  grid[row][col]+dp[row][col+1];
                 }
                 else if(col == grid[0].length - 1)
                 {
                    dp[row][col] =  grid[row][col]+dp[row+1][col];   
                 }
                 else
                 {
                    dp[row][col] = grid[row][col]+Math.min(dp[row+1][col],dp[row][col+1]);  
                 }
             }
         }
         return dp[0][0];
    }

    //https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1

    public static int maxGold(int[][] maze)
    {
        int max = 0;
        for(int row = 0;row<maze.length;row++)
        {
         max =   Math.max(maxGold_(maze,row,0),max);
        }
        return max;
    }
    public static int maxGold_(int[][] maze,int sr,int sc)
    {
        if(sr<0 || sr>maze.length-1)
        {
            return Integer.MIN_VALUE;
        }
        if(sc == maze[0].length - 1)
        {
            return maze[sr][sc];
        }
        int f1 = maxGold_(maze,sr-1,sc+1);
        int f2 = maxGold_(maze,sr,sc+1);
        int f3 = maxGold_(maze,sr+1,sc+1);

        int ans = Math.max(Math.max(f1,f2),f3);
        return ans;

    }
    public static int maxGold_tab(int[][] maze,int[][] dp)
    {
        int m = maze.length -1;
        int n = maze[0].length -1;         // m*n

        for(int col = n;col>=0;col--)
        {
            for(int row = 0;row<=m;row++)
            {
                if(col == n)
                {
                    dp[row][col] = maze[row][col];
                }
                else if(row == 0)
                {
                    dp[row][col] = Math.max(dp[row][col+1],dp[row+1][col+1]) + maze[row][col];
                }
                else if(row == m)
                {
                    dp[row][col] = Math.max(dp[row][col+1],dp[row-1][col+1]) + maze[row][col];
                }
                else
                {
                    dp[row][col] = Math.max(dp[row+1][col+1],Math.max(dp[row][col+1],dp[row-1][col+1])) + maze[row][col];
                }
            }
        }
        int max = 0;
        for(int row = 0;row<=m;row++)
        {
           max = Math.max(dp[row][0],max);
        }
        return max;
    }
    public static void main(String[] args)
    {

    }
}
