class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxi = maxDepth(root); // maxi is the max depth
        return dfs(root, maxi, 0);
    }
    
    private TreeNode dfs(TreeNode root, int maxi, int len) {
        if (root == null) return null;
        if (maxi - 1 == len) return root;
        TreeNode left = dfs(root.left, maxi, len + 1);
        TreeNode right = dfs(root.right, maxi, len + 1);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

<img src="https://assets.leetcode.com/users/images/cc496d84-0690-4377-b8a3-f621f326df8f_1742786890.68028.png" width="400">