public class Solution {
    public class Dir {
        private int len;
        private int level;
        private boolean file;
        
        public Dir(int len, int level, boolean file) {
            this.len = len;
            this.level = level;
            this.file = file;
        }
    }
    
    
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        int size = strs.length;
        Dir[] dirs = new Dir[size];
        for (int i = 0; i < size; ++i) {
            int level = strs[i].lastIndexOf("\t") + 1;
            int len = strs[i].length() - level + 1;
            boolean file = (strs[i].indexOf('.') != -1);
            dirs[i] = new Dir(len, level, file);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int rst = 0;
        for (int i = 0; i < size; ++i) {
            int lev = dirs[i].level;
            int length = dirs[i].len;
            if (map.containsKey(lev - 1)) {
                length += map.get(lev - 1);
            }
            dirs[i].len = length;
            map.put(lev, length);
            if (dirs[i].file && length > rst) rst = length;
        }
        
        if (rst > 0) return rst - 1;
        return rst;
    }
}