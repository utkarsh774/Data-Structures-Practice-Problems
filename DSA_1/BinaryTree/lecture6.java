import java.util.ArrayList;
import java.util.List;
public class lecture6{
    public static class Node{
        int data;
        Node left;
        Node right;
      
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
      
        }
        Node(int data){
            this(data,null,null);
        }
      }
public static int getHeight(Node node){
    if(node == null) return 0;

    int lh = getHeight(node.left);
    int rh = getHeight(node.right);
    return Math.max(rh,lh)+1;
}
// get all path of root to leaf nodes
public static List<List<Integer>> rootToLeafPath(Node root){
            List<Integer> sa = new ArrayList<>();
            List<List<Integer>> ba = new ArrayList<>();
            rootToLeafPath_(root,sa,ba);
            return ba;
}
public static void rootToLeafPath_(Node root,List<Integer> sa,List<List<Integer>> ba){
    if(root == null) return;
    if(root.left==null&&root.right==null){
        sa.add(root.data);
        List<Integer> ma = new ArrayList<>(sa);
        ba.add(ma);
        sa.remove(sa.size()-1);
    }
    sa.add(root.data);
    rootToLeafPath_(root.left,sa,ba);
    rootToLeafPath_(root.right,sa,ba);
    sa.remove(sa.size()-1);

}
//get all such parents in an arraylist which has just 1 child
public static List<Integer> allSingleChildParent(Node root){
        List<Integer> ans =  new ArrayList<>();
        allSingleChildParent_(root,ans);
        return ans;
}
public static void allSingleChildParent_(Node root,List<Integer>ans){
       if(root == null||root.left==null&&root.right==null){
           return;
       }

       if(root.left==null||root.right==null){
            ans.add(root.data);
       }
       allSingleChildParent_(root.left,ans);
       allSingleChildParent_(root.right,ans);
}

// get the count of all such parents which has just 1 child
public static int countAllSingleChildParent(Node node){
    if(node == null) return 0;
    if(node.left==null&&node.right==null) return 0;

    int left = countAllSingleChildParent(node.left);
    int right = countAllSingleChildParent(node.right);
    int ans  = left+right;
    countAllSingleChildParent(node.right);
    if(node.left==null||node.right==null){
        return ans + 1;
    }
    return ans;
}

//node to root path
public static ArrayList<Node> ntrp(Node node,int data){
    if(node == null) return null;
    if(node.data==data){
        ArrayList<Node> al = new ArrayList<>();
        al.add(node);
        return al;
    }
    ArrayList<Node> left = ntrp(node.left,data);
    if(left!=null){
         left.add(node);
         return left;
    }

    ArrayList<Node> right = ntrp(node.right,data);
    if(right!=null){
        right.add(node);
        return right;
    }
    return null;
}

// get all the Node which are k  levels down the root
public static void Kdown(Node node,int k,List<Integer> ans,Node blockNode){
   if(node == null||node == blockNode||k<0) return;
   if(k==0){
       ans.add(node.data);
       return;
   }
   Kdown(node.left,k-1,ans,blockNode);
   Kdown(node.right,k-1,ans,blockNode);
   return;
}
// k away nodes  //T:o(n)  //S:o(n)
public static ArrayList<Integer> kAwayNodes(Node node,int data,int k,ArrayList<Integer>ans){
   
    ArrayList<Node> ntrp_list = ntrp(node,data);
    Node blockNode = null;
    for(int i = 0;i<ntrp_list.size();i++){
        Kdown(ntrp_list.get(i),k-i,ans,blockNode);
        blockNode = ntrp_list.get(i);
    }
    return ans;
}

public static ArrayList<Integer> kAwayNodes02(Node node ,int k,int data, ArrayList<Integer> ans){
   
    kAwayNodes02_(node,data,k,ans);
     return ans;
}


public static int kAwayNodes02_(Node node,int data,int k,ArrayList<Integer> ans){

    if(node == null) return 0;

    if(node.data == data){
        Kdown(node,k,ans,null);
        return 1;
    }
    int left = kAwayNodes02_(node.left,data,k,ans);
    if(left!=0){
        Kdown(node,k-left,ans,node.left);
        return left++;
    }
    int right = kAwayNodes02_(node.right,data,k,ans);
    if(right!=0){
        Kdown(node,k-right,ans,node.right);
        return right++;
    }
    return 0;
}

//Burning tree
//https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/


//=======================================================================================
//LCA TYPES

public static Node Lca(Node root,int p,int q){
    ArrayList<Node> l1 = 
}
public static void main(String[] args){

}

}