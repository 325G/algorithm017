/**
 *
 * 双向BFS
 *
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
                            if (endVisited.contains(nextWord))
                                return step + 1;
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                nextVisited.add(nextWord);
                            }
                        }
                    }
                    wordChar[i] = originChar;
                }

            }
            beginVisited = nextVisited;
            step++;
        }
        return 0;
    }
}