class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            List<Integer> list = new ArrayList<>(Collections.nCopies(26,0));
            for (int i = 0; i < word.length(); i++) {
                int wordIndex = word.charAt(i) - 'a';
                list.set(wordIndex, list.get(wordIndex) + 1);
            }
            map.putIfAbsent(list, new ArrayList<>());
            map.get(list).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
