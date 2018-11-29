//Problem        : Tile Adventure
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.*;
//Your submission should *ONLY* use the following class name

public class Problem
{
    static class Point {
        char val;
        int row, col;
        public Point(char val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)
    {

       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int m = in.nextInt();
       int steps = in.nextInt();
       char[][] tiles = new char[n][m];
       
       for (int i = 0; i < n; ++i) {
           for (int j = 0; j < m; ++j) {
                tiles[i][j] = in.next().charAt(0);
                //System.out.print(tiles[i][j]);
           }
       }
       
       sb.append(tiles[0][0]);
       Point pre = new Point(tiles[0][0], 0, 0);
       
       for (int i = 0; i < steps; ++i) {
           Point curt = helper(tiles, pre.row, pre.col);
           pre = curt;
       }
       
       System.out.println(sb.toString());

    }
    
    private static Point helper(char[][] tiles, int r, int c) {
        int n = tiles.length, m = tiles[0].length;
        
        Comparator<Point> comp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.val != b.val) {
                    return a.val - b.val;
                } else if (a.row != b.row) {
                    return a.row - b.row;
                } else {
                    return a.col - b.col;
                }
            }
        };
        
        List<Point> list = new ArrayList<>();
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        
        for (int k = 0; k < 4; ++k) {
            int new_r = r + dr[k];
            int new_c = c + dc[k];
            if (new_r < 0 || new_r >= n || new_c < 0 || new_c >= m || tiles[new_r][new_c] == tiles[r][c]) {
                continue;
            }
            
            Point p = new Point(tiles[new_r][new_c], new_r, new_c);
            list.add(p);
        }
        
        Collections.sort(list, comp);
        Point first = list.get(0);
        
        sb.append(first.val);
        
        return first;
    }

}
