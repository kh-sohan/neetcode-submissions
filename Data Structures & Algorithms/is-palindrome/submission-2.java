class Solution {
    public boolean isPalindrome(String s) {
        String rep = s.toLowerCase().trim();

        int leftPointer = 0, rightPointer = rep.length() - 1;
        while (leftPointer < rightPointer) {
            while (leftPointer < rep.length() && (!Character.isLetter(rep.charAt(leftPointer)) && !Character.isDigit(rep.charAt(leftPointer)))) {
                leftPointer++;
            }
            while (rightPointer >= 0 && (!Character.isLetter(rep.charAt(rightPointer)) && !Character.isDigit(rep.charAt(rightPointer)))) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer && rep.charAt(leftPointer) != rep.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true; 
    }
}
