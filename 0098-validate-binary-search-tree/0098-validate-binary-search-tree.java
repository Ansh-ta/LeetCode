/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,null, null);
    }
    private boolean validate(TreeNode root,Integer low, Integer high){
        if(root == null) return true;
        return (low == null || low < root.val) && (high == null || high > root.val) && validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}