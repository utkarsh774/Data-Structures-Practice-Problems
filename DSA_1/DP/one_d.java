public class one_d {
    

    public static int frogJump(int n,int[] heights)
    {
        // base cond
        if(n==0)
        {
            return 0;
        }
         int rr1 = Integer.MAX_VALUE;
         int rr2 = Integer.MAX_VALUE;

        rr1 = frogJump(n-1,heights) + Math.abs(heights[n] - heights[n-1]);
        if(n-2>=0)
        rr2 = frogJump(n-2,heights) + Math.abs(heights[n] - heights[n-2]);

        return Math.min(rr1,rr2);
    }
//1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//    could jump to in a single move.  
//    You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.
// climb stairs with jump

public static int csjumps(int[] arr,int idx,int n)
{
            if(idx == n)
            {
                return 1;
            }
            else if(idx>n)
            {
                return 0;
            }
            
            int count = 0;
            for(int val = 1;val<=arr[idx];val++)
            {
                count += csjumps(arr,idx+val,n);
            }
            return count;
}

public static int csjumps_memo(int[] arr,int idx,int n,int[]dp)
{
           if(idx == n)
            {
                return 1;
            }
            else if(idx>n)
            {
                return 0;
            }
            if(dp[idx]!=0)
            {
                return dp[idx];
            }
            int count = 0;
            for(int val = 1;val<=arr[idx];val++)
            {
                count += csjumps_memo(arr,idx+val,n,dp);
            }
            dp[idx] = count;
            return count;   
}
// steps for tabulation
// 1> Storage dimention
// 2> Storeage meaning
// 3> Direction of traversal
public static int csjumps_tab(int[] arr,int[] dp)
{
    dp[dp.length - 1] = 1;
    for(int i = arr.length -1;i>=0;i--)
    {
        for(int jumps = 1;jumps<=arr[i];jumps++)
        {
            dp[i]+=dp[i + jumps];
        }
    }
    return dp[0];
}

// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  You can of-course fewer number of steps in the move.
// 4. You are required to print the number of minimum moves in which you can reach the top of 
//      staircase.
// Note -> If there is no path through the staircase print null.

    public static int csmj(int[])
    public static void main(String[] args)
    {
        int[] heights = new int[]{30,10,60,10,60,50};
        int ans   =   frogJump(5,heights);
        System.out.print(ans);
    }

    int sum = 0;

    for(int i = 1;i<=n;i++)
    {
        sum = sum + i;
    }
    return sum;
}
