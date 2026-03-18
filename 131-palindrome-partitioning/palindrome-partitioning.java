class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<List<String>>> dp = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(isPalindrome(s, j, i - 1)) {
                    String part = s.substring(j, i);
                    for(List<String> prev : dp.get(j)) {
                        List<String> newList = new ArrayList<>(prev);
                        newList.add(part);
                        dp.get(i).add(newList);
                    }
                }
            }
        }
        return dp.get(n);
    }
    boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}