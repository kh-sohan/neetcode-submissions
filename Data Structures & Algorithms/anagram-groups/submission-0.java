class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            List<Integer> list = new ArrayList<>(Collections.nCopies(26,0));
            for (int i = 0; i < word.length(); i++) {
                int wordIndex = word.charAt(i) - 'a';
                list.set(wordIndex, list.get(wordIndex) + 1);
            }
            if (map.containsKey(list)) {
                map.get(list).add(word);
            } else {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                map.put(list, wordList);
            }
        }

        return new ArrayList<>(map.values());
    }
}
