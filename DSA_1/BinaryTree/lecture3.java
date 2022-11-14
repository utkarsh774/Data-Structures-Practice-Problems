import java.util.ArrayList;
import java.util.Collections;
public class lecture3 {
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
//=============================================bst===================================
// T:o(n) 
public int height(Node node){

    if(node == null) return -1;
    int lh = height(node.left);
    int rh = height(node.right);
    return Math.max(lh,rh)+1;
}
// T:o(n)
public int size(Node node){
    if(node == null) return 0;
    
    int left =  height(node.left);
    int right = height(node.right);
    return left+right+1;
}
//T:o(N) 
public int sum(Node node){
    if(node==null) return  0;
    int ls = sum(node.left);
    int rs = sum(node.right);
    return ls + rs + node.data;
}
//T:o(logn)
public Node maximum(Node node){
    while(node.right!=null){
        node  = node.right;
    }
    return node;
}
//T:o(logn)
public Node minimum(Node node){
    while(node.left!=null){
        node = node.left;
    }
    return node;
}
//T:o(logn)
public boolean find(Node node,int data){
      while(node!=null){
            if(node.data==data){
                return true;
            }
            else if(node.data<data){
                node  = node.right;
            }
            else{
                node = node.left;
            }
      }
      return false;
}
//T:o(logn)
public ArrayList<Node> nodeToRootPath(Node node,int data){
            ArrayList<Node> ntrp = new ArrayList<>();
            boolean flag = false;
            while(node!=null){
                if(node.data==data){
                        ntrp.add(node);
                        flag = true;
                        break;
                }
                else if(node.data<data){
                        ntrp.add(node);
                        node=node.right;
                }
                else{
                    ntrp.add(node);
                    node = node.left;
                }
            }
            if(flag == false){
             ntrp.clear();
            }
         Collections.reverse(ntrp);
         return ntrp;
}
//T:o(logn)
public static Node lca(Node root,Node p,Node q){
    if(root == null) return null;

  while(root!=null){
    if(root.data<p.data&&root.data<q.data){
        root = root.right;
    }
    else if(root.data>p.data&&root.data>q.data){
        root = root.left;
    }
    else{
        return root;
    }
  }
    return null;
}
// A bst is given . Print all nodes from r1 to r2 in ascending order
//T o(n).
public static void printInRange(Node node,int r1,int r2){
        if(node == null) return;
        printInRange(node.left,r1,r2);
        if(r1<=node.data&&node.data<=r2){
            System.out.println(node.data);
        }
        printInRange(node.right,r1,r2);
}
//https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1/#
//Add all nodes in bst whose values are greater to it.
public static int sum = 0;
public static Node greaterNodesModify(Node node){
    greaterNodesModify_(node);
    return node;
}
public static void greaterNodesModify_(Node node){
    greaterNodesModify_(node.right);
    sum = sum+node.data;
    node.data = sum;
    greaterNodesModify_(node.left);
}
public static Node greaterNodesModify02(Node node){
    int[] arr = new int[1];
    greaterNodesModify02_(node,arr);
    return node;
}
public static void greaterNodesModify02_(Node node,int[] arr){
    if(node == null) return;
    greaterNodesModify02_(node.right,arr);
    arr[0] = arr[0]+node.data;
    node.data = arr[0];
    greaterNodesModify02_(node.left,arr);           
}
public static void main(String[] args){

}
}
