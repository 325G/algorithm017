/**
 *
 * 1. 前序数组中第一个节点为二叉树根节点
 * 2. 构建Map 存储中序数组值和数组下标
 * 3. 通过前序数组找到二叉树根节点值，然后在中序数组Map中找到二叉树根节点下标；因为中序遍历是左子树、根节点、右子树方式排列 因此左子树长度也可以计算出
 * 4. 递归函数设计 参数：前序数组的左右界限，中序数组的左右界限，返回值树节点
 * 5. 左树计算：前序数组第一个节点为根 因此左界限+1开始，右界限为左界限+左树长度；中序数组根节点位置通过中序Map可以计算得到，左界限为参数左界限，右界限为根节点下表-1
 * 6. 右树计算：前序数组左节点左界限+1+左树长度，右界限为参数右界限；中序数组左界限为根节点下标+1右界限为参数右界限
 *
 **/
class Solution {
    HashMap<Integer, Integer> inorderCache = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i =0 ;i < n; ++i) {
            inorderCache.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    public TreeNode dfs(int[] preorder, int[] inorder, int preorderLeftIdx, int preorderRightIdx, int inorderLeftIdx, int inorderRightIdx) {
        if (preorderLeftIdx > preorderRightIdx) return null;
        int rootVal = preorder[preorderLeftIdx];
        int inorderMidIdx = inorderCache.get(rootVal);
        TreeNode tree = new TreeNode(rootVal);
        int leftTreeSize = inorderMidIdx - inorderLeftIdx;
        tree.left = dfs(preorder, inorder, preorderLeftIdx + 1, preorderLeftIdx + leftTreeSize, inorderLeftIdx, inorderMidIdx - 1);
        tree.right = dfs(preorder, inorder, preorderLeftIdx + leftTreeSize + 1, preorderRightIdx, inorderMidIdx + 1, inorderRightIdx);
        return tree;
    }
}