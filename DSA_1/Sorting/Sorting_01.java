import java.util.*;
public class Sorting_01{

public static void bubbleSort(int[] arr){

   for(int itr=1;itr<=arr.length-1;itr++){
        for(int j=0;j<arr.length-itr;j++){
            if(arr[j+1]<arr[j]) swap(arr,j+1,j);
        }
   }


}
public static void swap(int [] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}



public static void main(String [] args) throws Exception{

int[] arr = {3,7,2,8,1,10,4};
for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
}
System.out.print("\n");
bubbleSort(arr);
for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
}

}

}