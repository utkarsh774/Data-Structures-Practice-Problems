import java.util.*;
import java.lang.reflect.Method;

public class miscellaneous {
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

    //  https://practice.geeksforgeeks.org/problems/expression-tree/1#
    public static int expressionTree(Node root){
         if(root.left==null&&root.right==null){
             return Integer.parseInt(root.data);
         }   

         int left = expressionTree(root.left);
         int right = expressionTree(root.right);

         if(root.data.equals("+")){
            return left+right;
        }
         if(root.data.equals("-")){
            return left-right;
         }
         if(root.data.equals("*")){
            return left*right;
         }
         if(root.data.equals("/")){
            return left/right;
         }
         return 0;
    }

    //https://leetcode.com/problems/same-tree/
    public static boolean sameTree(Node p,Node q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;   //structure diff
        if(p.data!=q.data) return false;     // diff by value

        boolean left = sameTree(p.left,q.left);
        if(left==false) return false;
        boolean right  = sameTree(p.right,q.right);
        if(right==false) return false;
        return true;
    }
    //https://leetcode.com/problems/symmetric-tree/
    public static boolean symmetricTree(Node p,Node q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;   //structure diff
        if(p.data!=q.data) return false;     // diff by value

        boolean left = sameTree(p.left,q.right);
        if(left==false) return false;
        boolean right  = sameTree(p.right,q.left);
        if(right==false) return false;
        return true;
    }
    //https://leetcode.com/problems/path-sum/
    public static boolean pathSum(Node root,int target){
            if(root == null) return false;

           return pathSum_helper(root,target,0);
    }
    public static boolean pathSum_helper(Node root,int target,int ssf){

        if(root == null) return false;
        if(root.left==null&&root.right==null){
            ssf = ssf + root.data;
            if(ssf == target) return true;
            return false;
        }
        boolean left = pathSum_helper(root.left,target,ssf+root.data);
        if(left==true){
            return true;
        }
        boolean right = pathSum_helper(root.right,target,ssf+root.data);
        if(right == true){
            return true;
        }
        return false;
    }
    //https://leetcode.com/problems/path-sum-ii/
    public static ArrayList<ArrayList<Integer>> pathSum02(Node root,int target){
        ArrayList<ArrayList<Integer>> ba = new ArrayList<>();
        ArrayList<Integer> sa = new ArrayList<>();
        pathSum02_(root,target,sa,ba);
        return ba;
    }
    public static void pathSum02_(Node root,int target,ArrayList<Integer> sa,ArrayList<ArrayList<Integer>> ba){
        if(root == null) return;
        if(root.left==null&&root.right==null){
            sa.add(root.val);
            target = target-root.val;
            if(target==0){
                ArrayList<Integer> ma = new ArrayList<>(sa);
                ba.add(ma);
            }
            sa.remove(sa.size()-1);
        }
        sa.add(root.val);
        pathSum02_(root.left,target-root.val,sa,ba);
        pathSum02_(root.right,target-root.val,sa,ba);
        sa.remove(sa.size()-1);
    }
    public static void main(String[] args){

    }
}

