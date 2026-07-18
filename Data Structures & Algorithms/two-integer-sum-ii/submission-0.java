class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] arr = new int[2];

        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum == target)
                break;

            if (currSum < target) {
                left++;
            } else right--;
        }
        arr[0] = left + 1;
        arr[1] = right + 1;
        return arr;
    }
}
