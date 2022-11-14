public static class questions{

    //https://leetcode.com/problems/long-pressed-name/
    // Time:O(n) space: o(1)
    public static boolean longPress(String name,String typed){
        int i = 0; // name pointer
        int j = 0; // typed pointer

        while(i<name.length()&&j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else{
                if(i-1>=0&&name.charAt(i-1)==typed.charAt(j)){
                    j++;
                }
                else{
                    return false;
                }
            }
        }
        if(i<name.length()){
            return false;
        }
        while(j<typed.length()){
            if(name.charAt(i-1)!=typed.charAt(j)){
                return false;
            j++;
            }
        }
        return true;
    }
    //https://leetcode.com/problems/container-with-most-water/
    //time:o(n) space:o(1)
    public static int mostWater(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int maxWater = 0;
        while(i<j){
            int b = j - i;
            int h = Math.min(heights[i],heights[j]);
            int area  =  h*b;
            maxWater = Math.max(area,maxWater);

            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxWater;
    }
    //https://leetcode.com/problems/squares-of-a-sorted-array/
    // time: o(1) space:o(n)
    public static int[] ssa(int[] nums){
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;
        while(k>=0){
            int val1 = nums[i]*nums[i];
            int val2 = nums[j]*nums[j];
            if(val1>val2){
                ans[k] = val1;
                i++;
            }
            else{
                ans[k] = val2;
                j--;
            }
            k--;
        }
        return ans;
    }
    //https://leetcode.com/problems/majority-element/solution/
    //time: o(n) space: o(1)
    public static int majorityelement(int[] nums){
          int val = nums[0];
          int count  = 1;
          for(int i = 1;i<nums.length;i++){
                if(nums[i]==val){
                    count++;           //increasing freq
                }
                else{
                    count--;   //virtual pairing
                }
                if(count == 0){
                    val = nums[i];         //start the chain again
                    count = 1;
                }
          }
    }
    //https://leetcode.com/problems/next-greater-element-iii/
    public static String nextGreater3(String str){

    }
    //https://leetcode.com/problems/next-permutation/submissions/
    public static int[] nextPermutation(int[] nums){
        // find dip ele from LSB to MSB
        int  i = nums.length - 2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i == -1){
            return new int[]{-1};
        }
        // find smallest no. greater than dip from LSB to MSB
        int k = nums.length - 1;
        while(nums[k]<=nums[i]){
            k--;
        }

        //swap dip and k

        int temp = nums[dip];
        nums[dip] = nums[k];
        nums[k]  =  temp;

        // reverse from dip + 1
    }
  //  https://leetcode.com/problems/valid-anagram/

  public static boolean isAnagram(String s , String t)
  {
      int[] freq = new int[26];         //frequency array

      for(int i = 0;i<s.length();i++)
      {
          freq[s.charAt(i) - 'a']++;
      }
      for(int i = 0;i<t.length();i++)
      {
          freq[t.charAt(i) - 'a']--;
      }
      for(int i = 0;i<freq.length;i++)
      {
          if(freq[i]!=0) 
          return false;
      }
      return true;
  }

  //https://leetcode.com/problems/rotate-image/

  public static void rotateImage(int[][] matrix)
  {
      // take transpose

      for(int row = 0;row<matrix.length;row++)
      {
          for(int col = row;col<matrix.length;col++)
          {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;
          }
      }

      // swap rows

      int cmin = 0;
      int cmax = matrix.length - 1;

      while(cmin<=cmax)
      {
          for(int row = 0;row<matrix.length;row++)
          {
              int temp = matrix[row][cmin];
              matrix[row][cmin] = matrix[row][cmax];
              matrix[row][cmax] = temp;
          }
          cmin++;
          cmax--;
      }
      return;
  }
// https://leetcode.com/problems/rearrange-characters-to-make-target-string/
  public int rearrangeCharacters(String s, String target) {
        int[] s_freq = getFrequency(s);
        int[] target_freq = getFrequency(target);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<target_freq.length;i++)
        {
            if(target_freq[i]!=0)
            {
                min = Math.min(min,(s_freq[i]/target_freq[i]));
            }
        }
        return min;
}
public int[] getFrequency(String str)
{
    int[] freq = new int[26];

    for(int i = 0;i<str.length();i++)
    {
        char ch = str.charAt(i);
        freq[ch - 'a']++;
    }

    return freq;

}
    public static void main(String[] args){

    }
}