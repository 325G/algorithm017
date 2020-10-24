/**
 *
 * 双向BFS搜索
 * 使用两个集合表示搜索的两端，每次从较少元素集合开始搜索，如果搜索的下层节点在另外一个集合中存在则为最短路径；中途需要使用另外一个集合记录已经搜索过的节点；
 * wordList转换为Set集合加速判断
 * 由于每次只能变换一个字母，所以将当前字母每一位从a-z一次尝试从wordList中判断 如果存在变换后的单词则为当前单词的变换单词（需要从已访问集合中判断一次，防止重复访问）
 **/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = new HashSet<>(beginVisited);
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> nextVisited = new HashSet<>();
            for (String word : beginVisited) {
                char[] wordChar = word.toCharArray();
                for (int i = 0; i < word.length(); ++i) {
                    char originChar = wordChar[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (originChar == c) 
                            continue;
                        wordChar[i] = c;
                        String nextWord = String.valueOf(wordChar);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                nextVisited.add(nextWord);
                            }
                        }
                    }
                    wordChar[i] = originChar;
                }
            }
            step++;
            beginVisited = nextVisited;
        }
        return 0;
    }
}