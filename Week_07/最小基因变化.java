class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] letters = {'A', 'C', 'G', 'T'};
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        if (!wordSet.contains(end))
            return -1;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(start);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(end);

        int step = 0;
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
                    for (char c : letters) {
                        if (originChar == c)
                            continue;
                        wordChar[i] = c;
                        String nextWord = String.valueOf(wordChar);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord))
                                return step + 1;
                            if (!visited.contains(nextWord)) {
                                nextVisited.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    wordChar[i] = originChar;
                }
            }
            beginVisited = nextVisited;
            step++;
        }
        return -1;
    }
}