public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> rst = new ArrayList<String>();
        if (num > 8 || num < 0) return rst;
        HashMap<Integer, List<Integer>> hrMap = hrMap();
        HashMap<Integer, List<Integer>> minMap = minMap();
        
        for (int i = 0; i <= Math.min(num, 3); ++i) {
            int j = num - i;
            if (j >= 0 && j <= 5) {
                List<Integer> hours = hrMap.get(i);
                List<Integer> mins = minMap.get(j);
                for (int h: hours) {
                    for (int m: mins) {
                        if (m < 10) rst.add("" + h + ":" + "0" + m);
                        else rst.add("" + h + ":" + m);
                    }
                }
            }
        }
        
        return rst;
    }
    
    public HashMap<Integer, List<Integer>> hrMap() {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < 12; ++i) {
            int count = Integer.bitCount(i);
            map.get(count).add(i);
        }
        
        return map;
    }
    
    public HashMap<Integer, List<Integer>> minMap() {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 6; ++i) {
            map.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < 60; ++i) {
            int count = Integer.bitCount(i);
            map.get(count).add(i);
        }
        
        return map;
    }
    
}