import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class lecture7{
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
//==================LEVEL ORDER TRAVERSAL SET==============================================
//https://leetcode.com/problems/binary-tree-level-order-traversal/
//left->right
public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
   ArrayList<ArrayList<Integer>> ma = new ArrayList<>();
   if(root == null) return ma;
   LinkedList<Node> que = new LinkedList<>();
   que.addFirst(root);
   int level = 0;
   while(que.size()!=0){
      int size = que.size();
      System.out.println(level);
      ArrayList<Integer> sa  = new ArrayList<>();
      for(int  i = 0;i<size;i++){
         Node rem = que.removeFirst();
         sa.add(rem.data);
         if(rem.left!=null){
            que.addLast(rem.left);
         }
         if(rem.right!=null){
            que.addLast(rem.right);
         }
      }
      ma.add(sa);
      level++;
   }
   return ma;
}
//right->left
public static ArrayList<ArrayList<Integer>> levelOrder02(Node root){
   ArrayList<ArrayList<Integer>> ma = new ArrayList<>();
   if(root == null) return ma;
   LinkedList<Node> que = new LinkedList<>();
   que.addFirst(root);
   int level = 0;
   while(que.size()!=0){
      int size = que.size();
      System.out.println(level);
      ArrayList<Integer> sa  = new ArrayList<>();
      for(int  i = 0;i<size;i++){
         Node rem = que.removeFirst();
         sa.add(rem.data);
         if(rem.right!=null){
            que.addLast(rem.right);
         }
         if(rem.left!=null){
            que.addLast(rem.left);
         }
      }
      ma.add(sa);
      level++;
   }
   return ma;
}

//==================VIEW SET===========================================================

// left view

public static ArrayList<Integer> leftView(Node root){
   ArrayList<Integer> sa = new ArrayList<>();
   if(root == null) return sa;
   LinkedList<Node> que = new LinkedList<>();
   que.addFirst(root);
   while(que.size()!=0){
      int size = que.size();
      sa.add(que.getFirst().data);
      for(int  i = 0;i<size;i++){
         Node rem = que.removeFirst();
         if(rem.left!=null){
            que.addLast(rem.left);
         }
         if(rem.right!=null){
            que.addLast(rem.right);
         }
      }
   }
   return sa;
}

//right view
public static ArrayList<Integer> rightView(Node root){
   ArrayList<Integer> sa = new ArrayList<>();
   if(root == null) return sa;
   LinkedList<Node> que = new LinkedList<>();
   que.addFirst(root);
   while(que.size()!=0){
      int size = que.size();
      sa.add(que.getFirst().data);
      for(int  i = 0;i<size;i++){
         Node rem = que.removeFirst();
         if(rem.right!=null){
            que.addLast(rem.right);
         }
         if(rem.left!=null){
            que.addLast(rem.left);
         }

      }
   }
   return sa;
}
//Width of shadow of a binary tree from top to bottom
public static void widthOfShadow(Node root,int vl,int[] minMax){
   if(root == null) return;
   minMax[0] = Math.min(minMax[0],vl);
   minMax[1] = Math.max(minMax[1],vl);
   widthOfShadow(root.left,vl-1,minMax);
   widthOfShadow(root.right,vl+1,minMax);
  //vl -> vertical level.
}

// Vertical Order Traversal
public static class vPair{
   Node root = null;
   int level = 0;
  vPair(Node root,int level){
     this.root = root;
     this.level = level;
  }
}
  public static List<List<Integer>> verticalLevelTraversal(Node root){
   int[] minMax = new int[2];
   widthOfShadow(root,0,minMax);
   int vl = minMax[1] - minMax[0] + 1;
   List<List<Integer>> ba = new ArrayList<>();
   for(int i = 0;i<vl;i++){
      ba.add(new ArrayList<>());
   }
   LinkedList<vPair> que = new LinkedList<>();
   que.addLast(new vPair(root,Math.abs(minMax[0])));
   while(que.size()!=0){
      int size = que.size();
      for(int i = 0;i<size;i++){
         vPair rp =  que.removeLast();
         Node node = rp.root;
         int level = rp.level;
         ba.get(level).add(node.data);
         if(node.left!=null){
            que.addLast(new vPair(node,level-1));
         }
         if(node.right!=null){
            que.addLast(new vPair(node,level+1));
         }
      }
   }
   return ba;
  }
 //top view of binary tree
 public static List<Integer> topView(Node node){
   int[] minMax = new int[2];
   widthOfShadow(node,0,minMax);
   int vl  =  minMax[1] - minMax[0] + 1;
   List<Integer> sa = new ArrayList<>();
   for(int i = 0;i<vl;i++){
      sa.add(null);
   }
   LinkedList<vPair> que = new LinkedList<>();
   que.add(new vPair(node,Math.abs(minMax[0])));
   while(que.size()>0){
      int size = que.size();
      for(int i = 0;i<size;i++){
         vPair rp = que.removeLast();
         Node root = rp.root;
         int level = rp.level;
         if(sa.get(level)!=null){
            sa.set(level,root.data);
         }
         if(root.left!=null){
            que.addLast(new vPair(root,level-1));
         }
         if(root.right!=null){
            que.addLast(new vPair(root,level+1));
         }
      }
   }
   return sa;
 }

 //bottom view of binary tree
 public static List<Integer> bottomView(Node node){
   int[] minMax = new int[2];
   widthOfShadow(node,0,minMax);
   int vl  =  minMax[1] - minMax[0] + 1;
   List<Integer> sa = new ArrayList<>();
   for(int i = 0;i<vl;i++){
      sa.add(0);
   }
   LinkedList<vPair> que = new LinkedList<>();
   que.add(new vPair(node,Math.abs(minMax[0])));
   while(que.size()>0){
      int size = que.size();
      for(int i = 0;i<size;i++){
         vPair rp = que.removeLast();
         Node root = rp.root;
         int level = rp.level;
        
         sa.set(level,root.data);
         if(root.left!=null){
            que.addLast(new vPair(root,level-1));
         }
         if(root.right!=null){
            que.addLast(new vPair(root,level+1));
         }
      }
   }
   return sa;
 }


   public static void main(String[] args){

   }
    
}