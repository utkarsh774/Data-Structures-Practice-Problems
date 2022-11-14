import java.util.Scanner;

public class fibodp {
    // condtion for dp
    // larger problem is dependent on smaller sub problems
    // overlap of smaller sub problem is present
    public static int fib_rec(int n)
    {
        if(n<=1)
        {  
            // base cond
            return n;
        }
        // 0   1   1   2   3   5    8
        // 0th 1st 2nd 3rd 4th 5th  6th

        int faith1 = fib_rec(n-1);
        int faith2 = fib_rec(n-2);

        return faith1 + faith2;
    }
    public static int fib_memo(int n,int[] dp)
    {
        if(n<=1)
        {  
            // base cond
            return n;
        }
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        //Meaning of storage -> dp[n] has nth fibonacci value
        int faith1 = fib_rec(n-1);
        int faith2 = fib_rec(n-2);
        dp[n] = faith1 + faith2;
        return faith1 + faith2;
    }
    public static int fib_tab(int n,int[] dp)
    {
        // hard code the base case in storage

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<dp.length;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }
//https://leetcode.com/problems/climbing-stairs/

public static int climbStair_rec(int n)
{
    // ways to climb from 0 to n 
    if(n==0) return 1;
    if(n==1) return 1;

    return climbStair_rec(n-1) + climbStair_rec(n-2);
}

public static int climbStairs_memo(int n,int[] dp)
{
    if(n == 0) return 1;
    if(n<0) return 0;

    if(dp[n]!=0)
    {
        return dp[n];
    }
    int rr1 = climbStairs_memo(n-1,dp);
    int rr2 = climbStairs_memo(n-2,dp);
    int ans = rr1 + rr2;
    dp[n] = ans;
    return ans;

}
public static int climbStairs_tab(int n)
{
    int[] dp = new int[n+1];
    
    dp[0] = 1;

    
}
    public static void main(String[] args)
    {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // System.out.println(fib_tab(n,new int[n+1]));
        System.out.print(climbStair_rec(3));
    
    }
}
