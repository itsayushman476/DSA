class Solution {
    int mod = (int)1e9 + 7;
    public int numberOfWays(String corridor) {
        ArrayList<Integer> pos_seats = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                pos_seats.add(i);
            }
        }
        if (pos_seats.size() % 2 != 0 || pos_seats.size() == 0)
            return 0;
        long result = 1;
        int prev = pos_seats.get(1);
        for (int i = 2; i < pos_seats.size(); i += 2) {
            int length = pos_seats.get(i) - prev;
            result = (result * length) % mod;
            prev = pos_seats.get(i + 1);
        }
        return (int) result;
    }
}