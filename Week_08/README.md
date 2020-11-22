##### 位运算
	常用运算符：左移 << 
			  右移 >>
			  按位与 &
			  按位或 |
			  按位异或 ^
			  按位取反 ~
	高频位运算： X &(X - 1) 清零最低位的1
			   X & -X 得到最低位的1
			   X >> 1 等效 x/2
##### 布隆过滤器
	一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。 

	优点是空间效率和查询时间都远远超过一般的算法，
	缺点是有一定的误识别率和删除困难。
	应用，如：redis缓存、垃圾邮件评论过滤、爬虫URL判断重复等。


##### 冒泡排序
	
	// 冒泡排序，a表示数组，n表示数组大小
	public void bubbleSort(int[] a, int n) {
		  if (n <= 1) return;
	 
	 for (int i = 0; i < n; ++i) {
	    // 提前退出冒泡循环的标志位
	    boolean flag = false;
	    for (int j = 0; j < n - i - 1; ++j) {
	      if (a[j] > a[j+1]) { // 交换
	        int tmp = a[j];
	        a[j] = a[j+1];
	        a[j+1] = tmp;
	        flag = true;  // 表示有数据交换      
	      }
	    }
	    if (!flag) break;  // 没有数据交换，提前退出
	  }
	}
##### 插入排序
	
	// 插入排序，a表示数组，n表示数组大小
	public void insertionSort(int[] a, int n) {
	  if (n <= 1) return;

	  for (int i = 1; i < n; ++i) {
	    int value = a[i];
	    int j = i - 1;
	    // 查找插入的位置
	    for (; j >= 0; --j) {
	      if (a[j] > value) {
	        a[j+1] = a[j];  // 数据移动
	      } else {
	        break;
	      }
	    }
	    a[j+1] = value; // 插入数据
	  }
	}
##### 选择排序
	public int[] selectionSort(int[] arr) {
	    int len = arr.length;
	    int minIndex, temp;
	    for (int i = 0; i < len - 1; i++) {
	        minIndex = i;
	        for (int j = i + 1; j < len; j++) {
	            if (arr[j] < arr[minIndex]) {     // 寻找最小的数
	                minIndex = j;                 // 将最小数的索引保存
	            }
	        }
	        temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	    return arr;
	} 

##### 快速排序
	public static void quickSort(int[] array, int begin, int end) { if (end <= begin) return;  
		int pivot = partition(array, begin, end);  
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);
	} 

	static int partition(int[] a, int begin, int end) { // pivot: 标杆位置，counter: 小于pivot的元素的个数int pivot = end, counter = begin;  
		for (int i = begin; i < end; i++) {
			if (a[i] < a[pivot]) {  
				int temp = a[counter]; a[counter] = a[i]; a[i] = temp; counter++;
			} 
		}
		int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
		return counter;
	}
##### 归并排序
	public static void merge(int[] arr, int left, int mid, int right) { 	    				int[] temp = new int[right - left + 1]; // 中间数组
		 int i = left, j = mid + 1, k = 0; 
		 while (i <= mid && j <= right)
			 temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++]; 
		 while (i <= mid)  
		     temp[k++] = arr[i++]; 

		 while (j <= right) temp[k++] = arr[j++]; 
		 System.arraycopy(a, start1, b, start2, length);

	 }
