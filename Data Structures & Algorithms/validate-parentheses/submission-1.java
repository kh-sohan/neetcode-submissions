class Solution {
    public boolean isValid(String s) {
        int curr = 0;
        boolean isValid = true;
        Stack<Character> stack = new Stack<>();

        while (curr < s.length()) {
            char currChar = s.charAt(curr);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.add(currChar);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char poppedChar = stack.pop();
                if (!((poppedChar == '(' && currChar == ')') || (poppedChar == '{' && currChar == '}') || (poppedChar == '[' && currChar == ']'))) {
                    isValid = false;
                    break;
                }
            }
            curr++;
        }

        return isValid && stack.isEmpty();
    }
}
