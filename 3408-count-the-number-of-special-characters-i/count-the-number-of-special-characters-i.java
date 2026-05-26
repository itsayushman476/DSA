class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            boolean lowerFound = false;
            boolean upperFound = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    lowerFound = true;
                }
                if (word.charAt(i) == Character.toUpperCase(ch)) {
                    upperFound = true;
                }
            }
            if (lowerFound && upperFound) {
                count++;
            }
        }
        return count;
    }
}