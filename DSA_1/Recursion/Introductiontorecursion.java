import java.util.*;
public class Introductiontorecursion {
    // recursion on the way up
    public static void printDecreasing(int n)
    {
        if(n == 0) return;

        System.out.println(n);
        printDecreasing(n-1);
    }
    // recursion on the way down
    public static void printIncreasing(int n)
    {
        if(n == 0) return;

        printIncreasing(n-1);
        System.out.println(n);
    }
    // recursion on the way up combined with recursion on the way down
    public static void pdi(int n)
    {
        if(n == 0) return;

        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n == 0) return 1;
        
        
        return n*factorial(n-1);
    }
    public static int powerLinear(int x,int n)
    {
        if(n == 0)
        {
            return 1;
        }
        int rr = powerLinear(x,n-1);
        int mr = x*rr;
        return mr;
    }
    public static int powerLog(int x,int n)
    {
        if(n == 0) return 1;

       int rr =  powerLog(x,n/2);
       int mr = 0;
       if(n%2==0)
       {
            mr = rr*rr;
       }
       else
       {
            mr  = x*rr*rr;
       }
       return mr;
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

       // int n = scn.nextInt();

      //  printDecreasing(n);
        //printIncreasing(n);
       // pdi(n);
       //factorial(n);
       System.out.print(powerLinear(2,5));
    }
}
