/**
 *
 *	中序遍历模板 左-中-右
 *  迭代方式，处理顺序为左中右 因此将所有左节点加入栈，直到左节点为空，弹出过程中如果不处理右子树则顺序为左中左中，因此在处理完中节点时再迭代右子树即可
 *
 **/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}