// 434. Number of Islands II

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
        
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }
    
    public int find(int x) {
        List<Integer> list = new ArrayList<>();
        while (father[x] != x) {
            list.add(x);
            x = father[x];
        }
        
        for (int i: list) {
            father[i] = x;
        }
        
        return x;
    }
    
    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        father[root_a] = root_b;
    }
    
} 

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return rst;
        }
        
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        UnionFind uf = new UnionFind(n * m);
        
        for (Point p: operators) {
            if (visited[p.x][p.y]) {
                rst.add(count);
                continue;
            }
            
            visited[p.x][p.y] = true;
            count++;
            
            for (int i = 0; i < 4; ++i) {
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];
                if (isValid(new_x, new_y, n, m) && visited[new_x][new_y]) {
                    int p_father = uf.find(p.x * m + p.y);
                    int new_p_father = uf.find(new_x * m + new_y);
                    
                    if (p_father != new_p_father) {
                        uf.union(p_father, new_p_father);
                        count--;
                    }
                }
            }
            
            rst.add(count);
        }
        
        return rst;
    }
    
    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}