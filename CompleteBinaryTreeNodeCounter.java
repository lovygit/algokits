public class CompleteBinaryTreeNodeCounter{
    public int leftestStep(TreeNode root){
        int count=0;
        while(root!=null){
            root=root.left;
            count++;
        }
        return count;
    }
    
    public int rightestStep(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    
    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;
        
        int treeHeight=leftestStep(root);
        
        int k=1;
        int right=((int)Math.pow(2,treeHeight-1));
        int left=0;
        while(k<treeHeight){
            if(rightestStep(root.left)!=treeHeight-k){
                root=root.left;
                right=(right+left)/2;
            }else if(leftestStep(root.right)==treeHeight-k){
                root=root.right;
                left=(left+right)/2;
            }else{
                break;
            }
            k++;
        }
        right=((right+left)%2==0)?(left+right)/2:right;
        return right+((int)Math.pow(2,treeHeight-1))-1;
    }
}
