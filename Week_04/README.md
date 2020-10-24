##### 深度优先搜索和广度优先搜索
	- 每个节点访问一次
	- 每个节点仅访问一次
##### 深度优先搜索模板
	Set visited = new HashSet<>();
	
	public void dfs(Node node, int target, Set visited) {
		if (visited.contains(node)
			return;
		if (node.val == target)
			return;
		visited.add(node);
		process(node);
		for (Node next : node.children) {
			dfs(next, target, visited);
		} 
	}
 ##### 广度优先搜索模板
		public void bfs(Node node, int target, Set visited) {
		 Deque deque = new LinkedList<>();
		 stack.offer(node);
		 while (!stack.isEmpty()) {
			 Node cur = stack.poll();
			 visited.add(cur);
			 process(cur);
			 for (Node next : gen_relation_nodes(cur)) 
				 deque.offer(next);
		 }
     } 
 ##### 贪心算法
	贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优的选择，从而希
	望导致结果是全局最好的或最优的算法。
	与动态规划不同点：贪心选择不能回退，动态规划可以保存中间运行结果可以回退。
	使用贪心算法关键点：1.贪心是可以得到全局最优解的 2.贪心角度可以有多种，如
	从前往后、从后往前、局部切入
	
 ##### 二分查找前提条件
	   1.目标函数单调性
	   2.存在边界
	   3.能够通过索引访问
 ##### 二分查找代码模板
		int left = 0， right = array.length() - 1;
	    while (left <= right) {
			int mid = (right - left) /2 + left;
		    if (array[mid] == target) 
				break or return;
			else if (array[mid] < target) 
				left = mid + 1;
			else 
				right = mid - 1;	 	
		 }
