/**
 * 递归方式查找
 * 某节点的左右子树如果包含目标节点，则当前节点为公共祖先节点；因为要求解最近的公共祖先因此节点要尽可能靠下
 * 另外一种祖先节点为某节点的值为任意目标节点的值，并且另外一个节点存在与该节点的左子树或者右子树，则该节点为公共祖先节点
 * 
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        boolean l = dfs(node.left, p, q);
        boolean r = dfs(node.right, p, q);
        if (l && r || (node.val == p.val || node.val == q.val) && (l || r)) {
            ans = node;
            return true;
        }
        return l || r || node.val == p.val || node.val == q.val;
    }
}