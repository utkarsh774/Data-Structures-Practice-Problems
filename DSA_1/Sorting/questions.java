import java.util.*;
public class questions {
//    https://leetcode.com/problems/find-k-closest-elements/submissions/

        public static ArrayList<Integer> findClosestElements(int[] arr,int k,int x)
        {
            int low = 0;
            int high = arr.length - 1;
            ArrayList<Integer> al = new ArrayList<>();
            while(high - low + 1 > k)
            {
               if(Math.abs(arr[low] - x)<=  Math.abs(arr[high] - x))
               {
                    high--;
               }
               else
               {
                   low++;
               }
            }
            for(int K = low;K<=high;K++)
            {
                al.add(arr[K]);
        
            }
            return al;
        }      

// https://leetcode.com/problems/valid-triangle-number/

public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1;i>=2;i--)
        {
            int high = i-1;
            int low = 0;

            while(nums[low]+nums[high]<=nums[i]&&low<high)
            {
                low++;
            }
            count = count + (high - low);
        }
}
//https://www.geeksforgeeks.org/chocolate-distribution-problem/
public static int find(int[]arr, int n, int m) {
    int st = 0;
    int ed = n - 1;
    Arrays.sort(arr);
    int min = Integer.MIN_VALUE;
    while(ed<n)
    {
        min = Math.min(min,(arr[ed]-arr[st]));
        st++;
        ed++;
    }
    return min;
  }

 // https://leetcode.com/problems/matrix-cells-in-distance-order/

 public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        int[][] ans = new int[rows*cols][2];

        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                int position = i*cols + j;
                ans[position][0] = i;
                ans[position][1] = j;
            }
        }
        Arrays.sort(ans,(a,b)->{
            int d1 = Math.abs(a[0]-rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0]-rCenter) + Math.abs(b[1] - cCenter);
            return d1 - d2;
        });

        return ans;
}
//https://leetcode.com/problems/largest-number/
public String largestNumber(int[] nums) {
    Arrays.sort(nums,(n1,n2)->{
        
    }); 
}
// https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/1
public static int countZeros(int A[][], int N)
{
    int i = 0;
    int j = A[0].length - 1;
    int ans  = 0;
    while(i>=0 && i<A.length && j >=0 && j<A[0].length)
    {
        if(A[i][j]==0)
        {
            ans = ans + (j + 1);
            i++;
        }
        else
        {
            j--;
        }
    }
    return ans;
    
}
// https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1
public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        int max_one = 0;
        int idx = 0;

        for(int i = 0;i<N;i++)
        {
           int fo =  binarySearch_maxOnes(Mat,i);

           int len = M - fo;

           if(len>max_one)
           {
               max_one = len;
               idx  = i;
           }
        }
        return idx;
    }
    public static int binarySearch_maxOnes(int[][] mat,int i)
    {
        int low = 0;
        int high = mat[0].length - 1;
        int ans = mat[0].length;
        while(low<=high)
        {
           int  mid = (low + high)/2;

            if(mat[i][mid] == 1)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low  = mid + 1;
            }
        }
        return ans;
    }

  //  https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1
    public static int[] countEleLessThanOrEqual(int[]arr1, int[]arr2) {
            // for every ele in arr1 , find number of smaller ele in arr2
            // brute force is by using 2 loops -> o(N*M)

            // optimization could be done using binary search 

            Array.sort(arr2);
            int[] ans = new int[arr1.length];
            for(int i = 0;i<arr1.length;i++)
            {
                int target = arr1[i];

                // first larger index of target
                int fli = binarySearch(arr2,target); 

                ans[i] = fli;
            }
            return ans;
    }

    public static int binarySearch_countEleLessThanOrEqual(int[] arr2,int target)
    {
                int low = 0;
                int high = arr2.length - 1;
                int ans = arr2.length;
                while(low<=high)
                {
                    int mid = (low + high)/2;

                    if(arr2[mid]<=target)
                    {
                        low = mid + 1;

                    }
                    else
                    {
                        ans = mid;
                        high = mid - 1;
                    }
                }
            return ans;
    }

    // https://practice.geeksforgeeks.org/problems/buildings-receiving-sunlight3032/1

    public static int longest(int arr[],int n)
    {
        int lm = 0;                   // left max so far
        int count = 0;
        for(int i = 0;i<arr.length;i++)
        {
            int building = arr[i];

            if(building>=lm)
            {
                lm = building;
                count++;
            }
        }
        return count;
    }


         public static void main(String[] args)
         {

         }
}
