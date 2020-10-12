/**
 *	前序遍历模板 当前节点->子节点（从左到右）子树各节点规则一致
 *  迭代方式，使用队列处理
 *  由于处理顺序为从左到右，因此每层元素需要反转后加入队列然后取出队尾元素（取出队尾元素操作相当于处理了子树的根节点）
 *  
 *
 **/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null)
            return ans;
        deque.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            ans.add(node.val);
            Collections.reverse(node.children);
            deque.addAll(node.children);
        }
        return ans;
      }
}