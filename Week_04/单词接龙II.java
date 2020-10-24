/**
 *
 * 双向BFS + DFS
 * 双向BFS思路与单词接龙方式一样，不同之处是需要将所有相邻的节点找出并记录
 * 然后使用DFS 回溯方式将路径全部找出
 *
 **/
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return ans;
        Map<String, Set<String>> allComboDict = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, allComboDict);
        if (!found)
            return ans;
        dfs(beginWord, endWord, allComboDict, ans, new ArrayList<>(){{add(beginWord);}});
        return ans;
        
    }
    public boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> allComboDict) {
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        boolean forword = true;
        boolean found = false;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = new HashSet<>(beginVisited);
                beginVisited = endVisited;
                endVisited = temp;
                forword = !forword;
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
                                found = true;
                                addDict(word, nextWord, allComboDict, forword);
                            }
                            if (!visited.contains(nextWord)) {
                                nextVisited.add(nextWord);
                                addDict(word, nextWord, allComboDict, forword);
                            }
                        }
                    }
                    wordChar[i] = originChar;
                }
            }
            beginVisited = nextVisited;
            visited.addAll(nextVisited);
            if (found)
                break;
        }
        return found;
    }
    public void addDict(String fromWord, String toWord, Map<String, Set<String>> allComboDict, boolean forword) {
        if (!forword) {
            String temp = fromWord;
            fromWord = toWord;
            toWord = temp;
        }
        allComboDict.computeIfAbsent(fromWord, x -> new HashSet<>());
        allComboDict.get(fromWord).add(toWord);
    }
    public void dfs(String beginWord, String endWord, Map<String, Set<String>> allComboDict, List<List<String>> ans, List<String> temp) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (!allComboDict.containsKey(beginWord)) 
            return;
        for (String nextWord : allComboDict.get(beginWord)) {
            temp.add(nextWord);
            dfs(nextWord, endWord, allComboDict, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

}