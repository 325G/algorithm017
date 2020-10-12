/**
 *
 *	前序模板 中左右
 *  处理逻辑和中序一致，在加入栈时处理左节点即为中左中左，依次弹出再处理右子树
 *  
 *
 **/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                deque.push(root);
                root = root.left;
            }
            root = deque.pop().right;
        }
        return ans;
    }
}