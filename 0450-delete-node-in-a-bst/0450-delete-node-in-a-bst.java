class Solution {
    public TreeNode iop(TreeNode root){
        root = root.left;
        while(root.right != null) root = root.right;
        return root;
    }
    public TreeNode parentPred(TreeNode root , TreeNode pred){
        if(root.left == pred) return root;
        root = root.left;
        while(root.right != pred) root = root.right;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        // case 1 : key found
        if(root.val == key){

            // case 1 : 0 child
            if(root.left == null && root.right == null) return null;
            
            // case 2 : 1 child
            else if(root.left == null || root.right == null){
                if(root.left == null) return root.right;
                else return root.left;
            }

            // case 3 : 2 childs
            else{
                TreeNode pred = iop(root);
                TreeNode pp = parentPred(root,pred);
                if(pp == root){
                    pred.right = pp.right;
                    return pred;
                }
                pp.right = pred.left;
                pred.left = root.left;
                pred.right = root.right;

                return pred;
            }
        }

        // case 2 : RST will change
        else if(root.val < key){
            root.right = deleteNode(root.right , key);
        }

        // case 3 : LST will change
        else { // root.val > key
            root.left = deleteNode(root.left , key);
        }
        return root;
    }
}