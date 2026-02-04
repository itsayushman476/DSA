class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int countT = 0;
        int countF = 0;
        int maxLen = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') countT++;
            else countF++;
            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(left) == 'T') countT--;
                else countF--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
