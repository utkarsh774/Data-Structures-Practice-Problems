public class lecture4 {
// queen set problems
//queen combination 1D
// tq-> total queens,qpsf->qpsf,bn->box no,tb-> total box
public static void queenCombination1D(int tq,int qpsf,int bn,int tb,String asf){
    if(qpsf == tq){
        System.out.println(asf);
        return;
    }  

    for(int b = bn;b<tb;b++){
        queenCombination1D(tq,qpsf+1,b+1,tb,asf+"q"+qpsf+"b"+b);
    }
}
public static int count  = 0;
public static void queenPermutation1D(int tq,int qpsf,int tb,boolean[] visited,String asf){
    if(qpsf==tq){
        System.out.println(asf);
        count++;
        return;
    }
    for(int i = 0;i<tb;i++){
           if(visited[i]==false){
            visited[i] = true;
            queenPermutation1D(tq,qpsf+1,tb,visited,asf+"q"+qpsf+"b"+i);
            visited[i]  = false;
           }
    }
}
public static void queen(){
    // boolean[] visited = new boolean[7];
    // queenPermutation1D(4,0,7,visited,"");
    //  System.out.println(count);
     queenCombination1D(4,0,0,7,"");
}
public static void main(String[] args){
    queen();
}
}
