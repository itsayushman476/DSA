class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character,String>map1=new HashMap<>();
        HashMap<String,Character>map2=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char a=pattern.charAt(i);
            String b=words[i];
            if(map1.containsKey(a) && !map1.get(a).equals(b)) {
                return false;
            }
            if(map2.containsKey(b) && map2.get(b)!=(a)) {
                return false;
            }
            map1.put(a,b);
            map2.put(b,a);
        }
        return true;
    }
}