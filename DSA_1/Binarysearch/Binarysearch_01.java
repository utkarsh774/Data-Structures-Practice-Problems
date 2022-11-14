import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class Binarysearch_01{

// implementation of binary search
public static int binarySearch(int[] arr,int tar){
    
    int left =0;
    int right = arr.length-1;
    while(left<=right){
        int mid = (left+right)/2;
        if(arr[mid]==tar){
            return mid; 
        }
        else if(tar<arr[mid]){
            right=mid-1;
        }
        else if(tar>arr[mid]){
           left=mid+1;
        }
    }
    return -1;
}
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
// first and last occurance of target in nums
public static  int[] searchRange(int[] nums, int target)
{
    int[] ans = {-1,-1};
    
    int l = 0;
    int h = nums.length - 1;
    
    while(l<=h)
    {
        int mid  = (l + (h - l)/2);
        
        if(nums[mid] == target)
        {
            ans[0] = mid;
            h = mid - 1;
        }
        else if(nums[mid]<target)
        {
            l = mid + 1;
        }
        else
        {
            h = mid - 1;
        }
    }
      l = 0;
      h = nums.length - 1;
       
    while(l<=h)
    {
        int mid  = (l + (h - l)/2);
        
        if(nums[mid] == target)
        {
            ans[1] = mid;
             l = mid + 1;
        }
        else if(nums[mid]<target)
        {
            l = mid + 1;
        }
        else
        {
            h = mid - 1;
        }
    }
    return ans;
}
//https://leetcode.com/problems/sqrtx/
public static int mySqrt(int x) {
    long start = 1;
    long end = x;
    long mid = 0;
    long sqrt = 0;
    while(start<=end)
    {
     
        mid = start + (end - start)/2;
        
        if(mid*mid == x)
        {
            return (int)mid;
        }
        
        else if(mid*mid<x)
        {
            sqrt = mid;
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return (int)sqrt;
}
//https://leetcode.com/problems/valid-perfect-square/submissions/
public static boolean isPerfectSquare(int num) {
      
    long start = 1;
    long end = num;
    long mid = -1;
    
    while(start<=end)
    {
        mid = start + (end - start)/2;
        
        if(mid*mid == num)
        {
            return true;
        }
        else if(mid*mid<num)
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return false;
}

//https://leetcode.com/problems/first-bad-version/submissions/

public static boolean isBadVersion(int n)
{
    return true;
}

public static  int firstBadVersion(int n) {
        
    int start = 0;
    int end = n;
    int fbv = -1;
    while(start<=end)
    {
        int mid = start - (end - start)/2;

        if(isBadVersion(mid))
        {
            fbv = mid;
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return fbv;
}  
//====================Binary search on ans===================================//
// We are applying BS when the array is not sorted

public static int findPeakElement(int[] nums)
{
    int low  = 0;
    int high = nums.length-1;

    while(low<=high)
    {
        int mid = (low + high)/2;

        if((mid==0||nums[mid-1]<nums[mid])&&(mid==nums.length-1||nums[mid]>nums[mid+1]))
        {
            return mid;
        }
        else if(mid-1>=0&&nums[mid-1]>nums[mid])
        {
            high = mid - 1;        // [1,2]
        }
        else
        {
            low = mid +1;
        }
    }
    return -1;           // peak always exist we won't hit this ever
}

public  static int[] findPeakGrid(int[][] mat) {
        
    int low = 0;
    int high = mat[0].length - 1;

    while(low<=high)
    {
        int mid = (low + high)/2;

        int row = getMax(mat,mid);

        if((mid == 0||mat[row][mid-1]<mat[row][mid]) && (mid==mat[0].length-1||mat[row][mid]>mat[row][mid+1]))
        {
            return new int[]{row,mid};
        }
        else if(mid - 1>=0 && mat[row][mid-1]>mat[row][mid])
        {
            high = mid - 1;        
        }
        else
        {
            low = mid + 1;
        }
    }
    return new int[]{-1,-1};  //peak will always exist 
}

public static  int getMax(int[][] mat,int col)
{
    int val  = -1;
    int row = -1;

    for(int i = 0;i<mat.length;i++)
    {
        if(mat[i][col]>val)
        {
            val = mat[i][col];
            row = i;
        }
    }
    return row;
}

//==============================Binary search on matrix====================//
// https://leetcode.com/problems/search-a-2d-matrix/submissions/
public static boolean searchMatrix(int[][] mat,int target)
{
    // linear approach -> o(m*n)

    // Binary search  approach 1

    int row = 0;
    int col = mat[0].length - 1;

    while(row>=0&&row<mat.length&&col>=0&&col<mat[0].length)
    {
            if(mat[row][col] == target)
            {
                return true;
            }

            else if(mat[row][col]<target)
            {
                // move down
                row++;
            }
            else
            {
                // move left
                col--;
            }
    }
    return false;

}

public static boolean searchMatrix_(int[][] mat,int target)
{

   // approach 2
   // log(m*n) -> log(m) + log(n)                                                               
    int low = 0;
    int high = mat[0].length*mat.length - 1;

    while(low<=high)
    {
        int mid = (low + high)/2;

        int row = mid/mat[0].length;
        int col = mid%mat[0].length;

        if(mat[row][col] == target)
        {
            return true;
        }
        else if(mat[row][col] < target)
        {
                low = mid + 1;
        }
        else{
            high = mid - 1;
        }
    }
    return false;
}

// =============Binary Search on rotated array==========================



public static void main(String[] args) throws Exception{
    int [] arr = {1,2,3,4,5,6,7,8,9,10};
    int tar = 2;
    System.out.println(binarySearch(arr,tar));


}


}