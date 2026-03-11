class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer>adj=new ArrayList<>();
        int n=nums.length;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);

        }
        for(int key:map.keySet()){
            if(map.get(key)>n/3){
                adj.add(key);
            }
        }
        return adj;
    }
}