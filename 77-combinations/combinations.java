class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        ArrayList<Integer> list= new ArrayList<>();
        helper(1,n,k,list,result);
        return new ArrayList<> (result);
    }
    public void helper(int start,int n,int k,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result){
        if(list.size()==k){
            result.add(new ArrayList<>(list)); 
            return;
        }
        if(start>n) return;
        list.add(start);
            helper(start+1,n,k,list,result);
            list.remove(list.size()-1);
            helper(start+1,n,k,list,result);
        }
    }
