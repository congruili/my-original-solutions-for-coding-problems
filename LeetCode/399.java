public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; ++i) {
            String a = equations[i][0];
            String b = equations[i][1];
            if (!map.containsKey(a)) map.put(a, new HashMap<String, Double>());
            map.get(a).put(b, values[i]);
            if (!map.containsKey(b)) map.put(b, new HashMap<String, Double>());
            map.get(b).put(a, 1/values[i]);
        }
        
        double[] rst = new double[queries.length];
        
        for (int j = 0; j < queries.length; ++j) {
            rst[j] = search(map, queries[j][0], queries[j][1], 1.0, new HashSet<String>());
        }
        
        return rst;
    }
    
    public double search(HashMap<String, HashMap<String, Double>> map, String a, String b, double curt, HashSet<String> used) {
        if (used.contains(a)) return -1.0;
        if (a.equals(b) && map.containsKey(a)) return curt;
        if (!map.containsKey(a) || !map.containsKey(b)) return -1.0;
        if (map.get(a).containsKey(b)) return curt * map.get(a).get(b);
        HashMap<String, Double> nextMap = map.get(a);
        double rst = -1.0;
        used.add(a);
        for (String c: nextMap.keySet()) {
            rst = Math.max(search(map, c, b, curt * nextMap.get(c), used), rst);
        }
        used.remove(a);
        
        return rst;
    }
}