import java.util.ArrayList;
public class lecture0 {
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
    // size is defined as the sum of all the nodes in the Tree.
    public static int size(Node root){
            if(root == null) return 0;

            int left = size(root.left);    //left subtree size
            int right = size(root.right);  // right subtree size 
            
            return 1+left+right;    // 1 for root
    }
    // height and depth are same. Height is calculated in terms of edges and in terms
    // of nodes. Height in terms of edges+1 = Height in terms of nodes
    public static int height(Node root){
            if(root==null){
                return -1;   //0 for height in terms of nodes
            }

            int left  = height(root.left);    //left subtree height
            int right = height(root.right);   // right subtree height
 
            int maxSubHeight = Math.max(left,right);  //max of left and right subtree height
            return maxSubHeight+1;        // 1 for root 
    }
    //Max is defined as the max of all the data in the tree
    public static int max(Node root){
            if(root==null){
                    return Integer.MIN_VALUE;
            }
            int left = max(root.left);
            int right = max(root.right);
            int maxFromSubTrees = Math.max(left,right);
            return Math.max(root.data,maxFromSubTrees);
    }
    //Min is defined as the min of all the data in the tree
    public  static int min(Node root){
        
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left = min(root.left);
        int right = min(root.right);

        int minFromSubTrees  = Math.min(left,right);

        return Math.min(minFromSubTrees,root.data);    
    }
    //sum is defined as the sum of all the nodes in the tree
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int left  = sum(root.left);
        int right  = sum(root.right);

        int ans  =  left+right;
        return ans+root.data;
    }

    // count leaves in a binary tree

    public static int countLeaves(Node root){

        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        
            int left = countLeaves(root.left);
            int right =  countLeaves(root.right);
            return left+right;

    }

    // return an arrayList of nodes which has single child
    // on the way up
    public static void nodeWithSingleChild(Node node,ArrayList<Integer> al){
            if(node==null) return;
            if(node.left==null&&node.right==null){
                return;
            }

            if(node.left==null||node.right==null){
                al.add(node.data);
            }
            nodeWithSingleChild(node.left,al);
            nodeWithSingleChild(node.right,al);
            
    }
     //return an arraylist of nodes which has single child
     // on the way down
    public static ArrayList<Integer> nodeWithSingleChild(Node node){

        if(node==null){
            return new ArrayList<Integer>();
        }
        if(node.right==null&&node.right==null){
         return new ArrayList<Integer>();   
        }   
            ArrayList<Integer> mr = new ArrayList<>();
            ArrayList<Integer> left  = nodeWithSingleChild(node.left);
            for(int i = 0;i<left.size();i++){
                mr.add(left.get(i));
            }
            ArrayList<Integer> right  = nodeWithSingleChild(node.right);
            for(int i = 0;i<right.size();i++){
                mr.add(right.get(i));
            }
            if(node.left==null||node.right==null){
                mr.add(node.data);
            }
            return mr;
    }

public static int countNodeWithSingleChild(Node node){
    if(node==null||node.left==null&&node.right==null){
        return 0;
    }
    int left  = countNodeWithSingleChild(node.left); //ask left subtree for the ans
    int right = countNodeWithSingleChild(node.right); //ask right subtree for the ans
    if(node.left==null||node.right==null){
        return left+right;         //if I am not the ans return the sum from left and right
    }
    return left+right+1; //if I am also the ans add 1 to left-sub and right-sub tree
}

    public static void main(String[] args){

    }
}
