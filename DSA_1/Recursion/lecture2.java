import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class lecture2 {
 
// subset and subsequence based problems on strings and array=============================
// Recursion on 1d array and string================================================


// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

public static void permutationLexographical(char[] tempArray,boolean[] visited,String asf,List<String> ans){
    if(asf.length()==tempArray.length){
        ans.add(asf);
        return;
    }    
    
    for(int i = 0;i<tempArray.length;i++){
        if(visited[i]==false){
            visited[i] = true;
            permutationLexographical(tempArray,visited,asf+tempArray[i],ans);
            visited[i] = false;
        }
    }
}

//===========================SUBSET OF ARRAYS===========================================
// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
public static int equalPartition(int[] arr){
    int sum  = 0;
    for(int  i  = 0;i<arr.length;i++){
            sum+=arr[i];
    }
    if(sum%2!=0){
        return -1;
    }
    else{
        return equalPartition_helper(arr,0,sum/2);
    }
}
public static int equalPartition_helper(int [] arr,int idx,int tar){
    if(idx==arr.length){
        if(tar==0){
            return 1;
        }
        return 0;
    }
    int rr1 = equalPartition_helper(arr,idx+1,tar-arr[idx]); //yes;
    if(rr1==1){
        return 1;
    }
    int rr2 = equalPartition_helper(arr,idx+1,tar);  //no
    if(rr2==1){
        return 1;
    }
    else return 0;
}

    public static void main(String[] args){
      String  s = "dabc";
      char [] tempArray = s.toCharArray();
       Arrays.sort(tempArray);
       boolean[] visited = new boolean[s.length()];
       List<String> ans = new ArrayList<>();
       permutationLexographical(tempArray,visited,"",ans);
       System.out.println(ans);
    }
}
