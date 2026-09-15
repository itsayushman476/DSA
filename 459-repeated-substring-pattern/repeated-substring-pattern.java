class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str=s+s;
        str=str.substring(1,str.length()-1);
        return str.contains(s);
    }
}