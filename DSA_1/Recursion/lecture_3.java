import java. util.ArrayList;
public class lecture_3{

public static int infi_permutation(int[] coins, int target,String asf){
      
    if(target==0){
        System.out.println(asf);
        return 1;
    }
    
    int count = 0;
      for(int i = 0;i<coins.length;i++){
          if(target-coins[i]>=0)
       count = count +  infi_permutation(coins,target-coins[i],asf+coins[i]);
      }

      return count;
    }
public static int infi_combination(int[] coins,int target,int idx,String asf){

    if(target==0){
        System.out.println(asf);
        return 1;
    }
    else if(target<0) return 0;
    int count  = 0;
    for(int i=idx;i<coins.length;i++){
        count += infi_combination(coins,target-coins[i],i,asf+coins[i]);
    }
    return count;
}
public static int single_combination(int[] coins,int target,int idx,String asf){
    
    if(target==0){
        System.out.println(asf);
        return 1;
    }
    else if(target<0) return 0;
    int count  = 0;
    for(int i = idx;i<coins.length;i++){
        count+= single_combination(coins,target-coins[i],i+1,asf+coins[i]);
    }
    return count;
}

public static int single_permutaion(int[] coins, int target ,String asf){

   if(target==0){
       System.out.println(asf);
       return 1;
   }
   
   else if(target<0) return 0;
   
    int count = 0;
    for(int i = 0;i<coins.length;i++){
         if(coins[i]>0){
         int backup = coins[i];
         coins[i]  = -coins[i];
         count += single_permutaion(coins,target-backup,asf+backup);
         coins[i]  = -coins[i];
         }
    }
    return count;
}
public static int single_combination_sub(int[] arr,int idx,int tar,String str){
    if(idx==arr.length){
        if(tar==0){
        System.out.println(str);
        return 1;
        }
        return  0;
    }

    int yes = single_combination_sub(arr,idx+1,tar-arr[idx],str+arr[idx]);  //yes
    int no = single_combination_sub(arr,idx+1,tar,str);   //no

    return yes+no;
}

public static int infi_combination_sub(int[] arr,int tar,int idx,String str){
            if(tar==0){
                System.out.println(str);
                return 1;
            }
            if(tar<0){
            return 0;
            }
            if(idx==arr.length){
                return 0;
            }
            int yes = infi_combination_sub(arr,tar-arr[idx],idx,str+arr[idx]);
            int no = infi_combination_sub(arr,tar,idx+1,str);
            return yes+no;

}


public static void main(String[] args){

int [] coins = {2,3,5,7};
// int[] arr = {2,4,6,8};
//int target = 10;
// int[] visited = {0,0,0,0};
//System.out.print(single_permutaion(coins,target,""));
// System.out.println(single_combination(coins,10,0,""));
// System.out.println("===========================");
// System.out.print(single_combination_sub(coins,0,10,""));

System.out.println(infi_combination_sub(coins,10,0,""));
System.out.println("==========================================");
System.out.println(infi_combination(coins,10,0,""));
}
}
