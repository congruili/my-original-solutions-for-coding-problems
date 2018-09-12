class Dir {
    int level, len;
    boolean isFile;
    public Dir(int level, int len, boolean isFile) {
        this.level = level;
        this.len = len;
        this.isFile = isFile;
    }
}

public class Solution {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        String[] strs = input.split("\n");
        Dir[] dirs = new Dir[strs.length];
        
        for (int i = 0; i < strs.length; ++i) {
            int level = strs[i].lastIndexOf("\t") + 1;
            int len = strs[i].length() - level + 1;
            boolean isFile = strs[i].contains(".");
            dirs[i] = new Dir(level, len, isFile);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int rst = 0;
        
        for (Dir dir: dirs) {
            int level = dir.level;
            int len = dir.len;
            
            if (map.containsKey(level - 1)) {
                len += map.get(level - 1);
            }
            
            map.put(level, len);
            
            if (dir.isFile) {
                rst = Math.max(rst, len);
            }
        }
        
        if (rst > 0) {
            return rst - 1;
        }
        
        return 0;
    }
}