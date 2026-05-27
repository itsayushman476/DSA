class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            boolean lowerFound = false;
            boolean upperFound = false;
            int lastLower = -1;
            int firstUpper = -1;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    lowerFound = true;
                    lastLower = i;
                }
                if (word.charAt(i) == Character.toUpperCase(ch)) {
                    upperFound = true;
                    if (firstUpper == -1) {
                        firstUpper = i;
                    }
                }
            }
            if (lowerFound && upperFound && lastLower < firstUpper) {
                count++;
            }
        }
        return count;
    }
}