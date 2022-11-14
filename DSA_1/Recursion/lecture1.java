import java.util.ArrayList;

public class lecture1 {
    // https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
    //top down
    public static int longestPathInMatrix(int sr,int sc,int dr,int dc,int[][] matrix){
        
        if(sr<0||sc<0||sr>=3||sc>=10||matrix[sr][sc]==0){
            return Integer.MIN_VALUE;
        }
        if(sr==dr&&sc==dc){
            return 0;
        }

        matrix[sr][sc]  = 0;
        int  rr1 = longestPathInMatrix(sr-1,sc,dr,dc,matrix); //up
        int  rr2 = longestPathInMatrix(sr,sc-1,dr,dc,matrix); //left
        int  rr3 = longestPathInMatrix(sr+1,sc,dr,dc,matrix); //down
        int  rr4 = longestPathInMatrix(sr,sc+1,dr,dc,matrix); //right
        matrix[sr][sc] = 1;
        int max = Math.max(Math.max(rr1,rr2),Math.max(rr3,rr4));
        return max+1;
    }
    //bottom up
    public static int sum = 0;
    public static void lpm_void(int sr,int sc,int dr,int dc,int[][] matrix,int step){
        
        if(sr<0||sc<0||sr>=3||sc>=10||matrix[sr][sc]==0){
          return;
        }
        if(sr==dr&&sc==dc){
            sum = Math.max(sum,step);
            return;
        }
        matrix[sr][sc]  = 0;
           lpm_void(sr-1,sc,dr,dc,matrix,step+1); //up
           lpm_void(sr,sc-1,dr,dc,matrix,step+1); //left
           lpm_void(sr+1,sc,dr,dc,matrix,step+1); //down
           lpm_void(sr,sc+1,dr,dc,matrix,step+1); //right
        matrix[sr][sc] = 1;

    }
   // All paths in maze -->top down approach
   public static ArrayList<String> mazePath(int sr,int sc,int dr,int dc,int [][] mat){
        
         if(sr<0||sc<0||sr>mat.length-1||sc>mat[0].length-1||mat[sr][sc]==0){
             ArrayList<String> ba = new ArrayList<>();
             return ba;
         }
       else if(sr==dr&&sc==dc){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        mat[sr][sc] = 0;
         ArrayList<String> mr = new ArrayList<>();
         ArrayList<String>  rr1  = mazePath(sr-1,sc,dr,dc,mat); //u
         for(int i = 0;i<rr1.size();i++){
             mr.add("u"+rr1.get(i));
         }
         ArrayList<String>  rr2  = mazePath(sr,sc-1,dr,dc,mat); //l
         for(int i = 0;i<rr2.size();i++){
            mr.add("l"+rr2.get(i));
        }
        ArrayList<String> rr3  = mazePath(sr+1,sc,dr,dc,mat); //d
        for(int i = 0;i<rr3.size();i++){
            mr.add("d"+rr3.get(i));
        }
        ArrayList<String> rr4 = mazePath(sr,sc+1,dr,dc,mat); //r
        for(int i = 0;i<rr4.size();i++){
            mr.add("r"+rr4.get(i));
        }
        mat[sr][sc] =1;
        return mr;
   }
   // All paths in maze -- Bottom up Approach
   public static void mp(int sr,int sc,int dr,int dc,int[][] mat){
                


   }
   

   //count paths in a maze --> top down

   public static int countMazePath(int sr,int sc,int dr,int dc,int[][] mat){
       
    if(sr<0||sc<0||sr>=3||sc>=10||mat[sr][sc]==0){
        return 0;
    }
    else if(sr==dr&&sc==dc){
        return 1;
    }
       mat[sr][sc]=0;
       int rr1  = countMazePath(sr-1,sc,dr,dc,mat);  //up
       int rr2  = countMazePath(sr,sc-1,dr,dc,mat);  //left
       int rr3  = countMazePath(sr+1,sc,dr,dc,mat);   //down
       int rr4  = countMazePath(sr,sc+1,dr,dc,mat);  //right
       mat[sr][sc]=1;
       return rr1+rr2+rr3+rr4;

       
   }
   //count maze paths--> bottom up
   public static int count  = 0;
   public static void cmp(int sr,int sc,int dr,int dc,int[][] mat){
    if(sr<0||sc<0||sr>=3||sc>=10||mat[sr][sc]==0){
        return;
    }
    else if(sr==dr&&sc==dc){
        count++;
    }
    mat[sr][sc]=0;
    cmp(sr-1,sc,dr,dc,mat);  //up
    cmp(sr,sc-1,dr,dc,mat);  //left
    cmp(sr+1,sc,dr,dc,mat);   //down
    cmp(sr,sc+1,dr,dc,mat);  //right
    mat[sr][sc]=1;
   }
    public static void main(String[] args){
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
// find longest path with source (0, 0) and
// destination (1, 7)
        // lpm_void(0, 0, 1, 7,mat,0);
        // System.out.print(sum);
        System.out.println(mazePath(0,0,1,7,mat).size());
        System.out.println(countMazePath(0,0,1,7,mat));
        cmp(0,0,1,7,mat);
        System.out.println(count);

    }
}
