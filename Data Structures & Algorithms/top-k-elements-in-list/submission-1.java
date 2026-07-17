class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Pair> frequentKElements = new PriorityQueue<>();

        countMap.forEach((num,freq) -> {
            Pair pair = new Pair(num, freq);
            if (frequentKElements.size() < k) {
                frequentKElements.add(pair);
            } else if (frequentKElements.peek().frequency < freq) {
                frequentKElements.poll();
                frequentKElements.add(pair);
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = frequentKElements.poll().element;
        }
        return ans;
    }


    static class Pair implements Comparable <Pair>{
        int element;
        int frequency;

        public Pair(int k, int v) {
            this.element = k;
            this.frequency = v;
        }

        @Override
        public int compareTo(Pair o) {
            return this.frequency - o.frequency;
        }
    }
}
