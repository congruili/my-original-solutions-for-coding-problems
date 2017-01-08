public class TwoSum {

    // Add the number to an internal data structure.
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public void add(int number) {
        if (!map.containsKey(number)) map.put(number, 0);
        map.put(number, map.get(number) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i: map.keySet()) {
            if (i * 2 == value) {
                if (map.get(i) > 1) return true;
            } else if (map.containsKey(value - i)) return true;
        }
        
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);