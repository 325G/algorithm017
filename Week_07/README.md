##### Trie
	    字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串(但不仅限于 字符串)，所以经常被搜索引擎系统用于文本词频统计。
		优点:最大限度地减少无谓的字符串比较，查询效率比哈希表高。
		基本性质:
				1. 结点本身不存完整单词;
				2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
				3. 每个结点的所有子结点路径代表的字符都不相同。
##### Trie 代码模版
		    class Trie {
				boolean end;
				Trie[] next = new Trie[26];
				public Trie() {
				}
				public void insert(String word) {
					if (word == null || word.length() == 0)
						return;
					Trie trie = this;
					for (char c : word.toCharArray()) {
						if (trie.next[c - 'a'] == null)
							trie.next[c - 'a'] = new Trie();
							trie = trie.next[c - 'a'];
					}
					trie.end = true;
				}
				public boolean search(String word) {
					Trie node = findPrefix(word);
					return node != null && node.end;
				}
				public boolean startsWith(String prefix) {
					return findPrefix(prefix) != null;
				}
				private Trie findPrefix(String word) {
					if (word == null || word.length() == 0)
						return null;
					Trie node = this;
					for (char c : word.toCharArray()) {
							node = node.next[c - 'a'];
							if (node == null)
								return null;
					}
					return node;
				}
			}

##### 并查集
	解决组团 配对问题
	基本操作：
			makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
			unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
			find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
##### 并查集代码模版
	class UnionFind {
		 private int count = 0;
		 private int[] parent;
		 public UnionFind(int n) { 

		 count = n;
		 parent = new int[n];
		 for (int i = 0; i < n; i++) { 
			 parent[i] = i;
		 } 

	 } 
	 public int find(int p) { 
		 while (p != parent[p]) {
			 parent[p] = parent[parent[p]]; 
			 p = parent[p];
		 } 

		return p; 
	 }

	 public void union(int p, int q) {
		 int rootP = find(p);
		 int rootQ = find(q);
		 if (rootP == rootQ) return;
		 parent[rootP] = rootQ; 
		 count--; 
     }

	}
##### 红黑树
	 红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)，它能够确保任何一 个结	点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉 搜索树:

	• 每个结点要么是红色，要么是黑色  
	• 根结点是黑色  
	• 每个叶结点(NIL结点，空结点)是黑色的。  
	• 不能有相邻接的两个红色结点  
	• 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
