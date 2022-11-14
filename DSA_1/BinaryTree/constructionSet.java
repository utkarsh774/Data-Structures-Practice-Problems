public  class constructionSet{
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        int low = 0;
        int high = inOrder.length-1;
        return constructFromInOrder_(inOrder,low,high);
    }
    public static TreeNode constructFromInOrder_(int[] inOrder,int low,int high) {
        if(low>high){
            return null;
        }
        else if(low == high){
            TreeNode bn = new TreeNode(inOrder[low]);
           return bn;
        }
        int mid = (low + high)/2;
        TreeNode node = new TreeNode(inOrder[mid]);
        TreeNode left = constructFromInOrder_(inOrder,low,mid-1);
        node.left = left;
        TreeNode right = constructFromInOrder_(inOrder,mid+1,high);
        node.right = right;
        return node;
    }
}