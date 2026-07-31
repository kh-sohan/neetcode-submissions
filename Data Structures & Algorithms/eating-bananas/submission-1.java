class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = Arrays.stream(piles)
                .max()
                .getAsInt(), low = 1, high = ans;
        int possibleAns = low + (high - low) / 2;
        while (low <= high) {
            if (isPossibleWithLowerRate(piles, possibleAns, h)) {
                ans = possibleAns;
                high = ans - 1;
            } else {
                low = possibleAns + 1;
            }
            possibleAns = low + (high - low) / 2;
        }
        return ans;
    }

    private boolean isPossibleWithLowerRate(int[] piles, int rate, int h) {
        int hoursTaken = 0;
        for (int i = 0; i < piles.length; i++) {
            hoursTaken += (piles[i] + rate - 1) / rate;
        }
        return hoursTaken <= h;
    }
}
