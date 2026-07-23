class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;

            while (j < n && temperatures[j] <= temperatures[i]) {
                if (ans[j] == 0)                // to account when no higher temperature is found even for the lower temp
                    j = n;                      // that means no higher temperature for current temp too
                else j += ans[j];
            }
            if (j < n) {
                ans[i] = j - i;
            }
        }

        return ans;
    }
}
