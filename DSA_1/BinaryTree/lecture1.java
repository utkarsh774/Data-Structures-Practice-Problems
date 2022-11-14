import java.util.ArrayList;
import java.util.List;
public class lecture1{
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

public static boolean findData(Node root,int data){
  if(root == null){
    return false;
  }
  if(root.data==data){
    return true;
  }
  boolean left  =  findData(root.left,data);
  if(left==true){
    return true;
  }
  boolean right = findData(root.right,data);
    if(right == true){
      return true;
    }
    return false;
  }
 

public static void nodeToRootPath(Node root,int data,ArrayList<Node> ans){
        if(root == null) return;
    
        if(root.data == data){
          ans.add(root);
          return;
        }
        nodeToRootPath(root.left,data,ans);
        if(ans.size()!=0){
          ans.add(root);
          return;
        }
        nodeToRootPath(root.right,data,ans);
        if(ans.size()!=0){
          ans.add(root);
          return;
        }
        return;
}
public static ArrayList<Node> nodeToRootPath(Node root,int data){
       ArrayList<Node> ans = new ArrayList<>();
       nodeToRootPath(root,data,ans);
       return ans;
}


public static ArrayList<Node> nodeToRootPath02(Node root,int data){
  if(root==null){
    return null;
  }
  else if(root.data==data){
      ArrayList<Node> ba = new ArrayList<>();
      ba.add(root);
      return ba;
  }
  ArrayList<Node> left = nodeToRootPath02(root.left,data);
  if(left!=null){
    left.add(root);
    return left;
  }
ArrayList<Node> right  = nodeToRootPath02(root.right,data);
if(right!=null){
  right.add(root);
  return right;
}
  return null;
}

// print all nodes at k level down--> root is at level 0
public static void kLevelDown(Node root,int k,ArrayList<Integer> ans,Node block){
  if(root == null||root == block)  return;

  if(k==0){
      ans.add(root.data);
      return;
  }
  kLevelDown(root.left,k,ans,block);
  kLevelDown(root.right,k,ans,block);
  
}

public static List<Integer> Kawaynodes(Node root,int data,int k){
     List<Node> ntrp =   nodeToRootPath02(root,data);
     List<Integer> ans  = new ArrayList<>();
    Node  block = null;
    for(int i = 0;i<ntrp.size();i++){
           kLevelDown(ntrp.get(i),k-i,ans,block);
           block = ntrp.get(i);
    }
    return ans;
}


public static void main(String[] args){

}
}


