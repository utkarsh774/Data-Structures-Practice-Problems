import java.util.*;
public  class  ngnsSet {
    
//next greater on right
public static int[] ngor(int[] arr){
    // time:o(n) space:o(n)
 Stack<Integer> st = new Stack<>();
 int[] ans = new int[arr.length];
 st.push(arr[arr.length-1]);
 for(int i = arr.length-2;i>=0;i--)
 {
     int val = arr[i];
   //pop all smaller elet

   while(st.size()>0&&st.peek()<=val)
   {
       st.pop();
   }
   //update ans

   if(st.size()>0)
   {
    ans[i] = st.peek();
   }
   else{
    ans[i] = -1;
   }

   //push current ele in stack
   st.push(arr[i]);
 }
 return ans;
}
//next greater on left
public static int[] ngol(int[] arr){
int[] ans = new int[arr.length];
Stack<Integer> st = new Stack<>();
st.push(arr[0]);
for(int i = 1;i<arr.length;i++)
{
    int val = arr[i];
    //pop all smaller ele
    while(st.size()>0&&st.peek()<=val)
    {
        st.pop();
    }
    //update ans
    if(st.size()>0)
    {
        ans[i] = st.peek();
    }
    else
    {
        ans[i] = -1;
    }
    //push curr ele in stack
    st.push(arr[i]);

}
return ans;
}
//next smaller on left
public static int[] nsol(int[] arr){
  Stack<Integer> st = new Stack<>();
  int[] ans = new int[arr.length];
  st.push(arr[0]);
  for(int i = 1;i<arr.length;i++)
  {
      int val = arr[i];
     //pop all greater ele
     
     while(st.size()>0&&val<=st.peek())
     {
         st.pop();
     }
     //update ans
     if(st.size()==0)
     {
        ans[i] = -1;
     }
     else
     {
        ans[i] = st.peek();
     }
      //push curr ele in stack
    st.push(arr[i]);
  }
   return ans;
}
//next smaller on right
public static int[] nsor(int[] arr){
  Stack<Integer> st = new Stack<>();
  int[] ans = new int[arr.length];
  st.push(arr[arr.length-1]);
  for(int i = arr.length-2;i>=0;i--)
  {
      int val = arr[i];
   //pop all smaller ele
   while(st.size()>0&&val<=st.peek())
   {
       st.pop();
   }      
   //update ans
   if(st.size()==0)
   {
    ans[i] = -1;
   }
   else{
    ans[i] = st.peek();
   }
   //push curr ele in stack
   st.push(arr[i]);
  }
  return ans;
}
// index of next smaller element on left
public static int[] insol(int [] arr)
{
 Stack<Integer> st = new Stack<>();
 int[] ans = new int[arr.length];
 ans[0] = -1;
 st.push(0);

 for(int i = 0;i<arr.length;i++)
 {
     int val = arr[i];

     // pop all greater ele

     while(st.size()>0 && val<=arr[st.peek()])
     {
         st.pop();
     }

    
     // update ans
     if(st.size()==0)
     {
        ans[i] = -1;
     }
     else
     {
        ans[i] = st.peek();
     }
     //push curr ele in stack
     st.push(i);
 }
 return ans;
}

// index of next smaller on right

public static int[] insor(int[] arr)
{
    Stack<Integer> st = new Stack<>();

    int[] ans = new int[arr.length];
    ans[ans.length - 1 ] = -1;

    for(int i = arr.length - 2;i>=0;i--)
    {
        int val = arr[i];
        // pop all greater ele on right
        while(st.size()>0 && val<=arr[st.peek()])
        {
            st.pop();
        }
        // update ans
        if(st.size() == 0)
        {
            ans[i] = -1;
         }
        else{
            ans[i] = st.peek();

        }
        //push curr ele in stack
        st.push(i);
    }
    return ans;
}
//https://leetcode.com/problems/daily-temperatures/
public static int[] dailyTemperature(int[] arr){
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[arr.length];
    ans[arr.length - 1] = 0;
    st.push(arr.length - 1);
    for(int i = arr.length - 1;i>=0;i--)
    {
        int val = arr[i];
        // 1 pop all smaller ele
        while(st.size()>0 && val>arr[st.peek()])
        {
            st.pop();
        }
        // 2 update your ans
        if(st.size()==0)
        {
            ans[i] = 0;
        }
        else
        {
            ans[i] = st.peek() - i;

        }
        // push curr index in the stack
        st.push(i);
    }
    return ans;
}
//https://leetcode.com/problems/next-greater-element-i/
public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
      // num2 is  an array
      // num1 is  a query array
      Stack<Integer> st = new Stack<>();
      int[] nge = new int[nums2.length];
      st.push(nums2[nums2.length - 1]);
      nge[nge.length - 1] = -1;
      for(int i = nums2.length - 1;i>=0;i--)
      {
       int val = nums2[i];
       //pop all smaller ele
       while(st.size()>0&&val>=st.peek())
       {
          st.pop();     
       }
       //update ans
       if(st.size()>0)
       {
        nge[i] = st.peek();
       }
       else{
        nge[i] = -1;
       }
       //push curr ele in stack
       st.push(val);
      }

      HashMap<Integer,Integer> hm = new HashMap<>();
      for(int i = 0;i<nums2.length;i++)
         hm.put(nums2[i],nge[i]);
       
       int[] ans = new int[nums1.length];

       for(int i = 0;i<nums1.length;i++)
       {
           ans[i] = hm.get(nums1[i]);
       }
       return ans;
}
// https://leetcode.com/problems/next-greater-element-ii/
public static int[] ngeII(int[] arr){
    Stack<Integer> st = new Stack<>(); 
    for(int i = arr.length - 1;i>=0;i--)
    {
        int val = arr[i];
     // push all current ele in stack
     st.push(val);

    }
    int[] ans = new int[arr.length];
    for(int i = arr.length - 1;i>=0;i--)
    {
        //pop all smaller ele
        int val = arr[i];
        
        while(st.size()>0 && val>=st.peek())
        {
            st.pop();
        }

        // upade ans

        if(st.size()==0)
        {
            ans[i] = -1;
        }
        else
        {
            ans[i] = st.peek();
        }

        // push the current ele in stack
        st.push(val);
    }
    return ans;
}
//https://leetcode.com/problems/next-greater-element-ii/
public static int largestAreaHistogram(int[] arr){
              // r - l - 1 -> width an element can extent

     int[] r = insor(arr);
     int[] l = insol(arr);
     int area = 0;
     int max = 0;
    for(int i = 0;i<arr.length;i++)
    {
        int width = r[i] - l[i] - 1;
        int height = arr[i];
        area = width*height;
         max  = Math.max(max,area);
    }
    return max;
}
// //https://leetcode.com/problems/maximal-rectangle/
// public static int maximalAreaOfRect(int[][] arr){




// }

public static int validSubarrays(int[] nums)
{
    int count = 0;
    for(int i = 0;i<nums.length;i++)
    {
        int j = 0;
        for(j = i+1;j<nums.length;j++)
        {
            if(nums[i]<nums[j])
            {
                break;
            }

        }
        count+= (j - i);
    }
    return count;
}
public static int validSubarrays_(int[] nums)
{
    Stack<Integer> st = new Stack<>();
    int count = 0;
    for(int i = nums.length-1;i>=0;i--)
    {
        int val = nums[i];

        // 1 pop all greater ele
        while(st.size()>0&&val<=nums[st.peek()])
        {
            st.pop();
        }
        // update ans
        if(st.size()==0)
        {
            count+=(nums.length - i);
        }
        else{
            count+=(st.peek() - i);
        }
        //push curr index in stack
        st.push(i);
    }
    return count;
}

// public static void main(String[] args){

// }

}
