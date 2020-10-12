/**
 *
 *	迭代，使用队列存储每层节点
 *  
 *  
 *
 **/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null) return ans;
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                Node node = deque.poll();
                level.add(node.val);
                deque.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }
}